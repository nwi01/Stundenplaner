package de.nwi.impl.timetableCalculator;

import de.nwi.api.enums.Weekday;
import de.nwi.api.model.Lecture;
import de.nwi.api.model.LecturePart;
import de.nwi.api.model.OptionalLecturePart;
import de.nwi.impl.timetableCalculator.specification.OverlappingSpecification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niels on 20.10.2015.
 */
public class LectureHelper {
    public List<OptionalLecturePart> getAllOptionalLecturePartsAtSameDaysAsLectures(List<OptionalLecturePart> opList, List<Lecture> lectures) {
        List<Weekday> weekdays = getAllDaysForLecture(lectures);
        List<OptionalLecturePart> optionalLectureParts = new ArrayList<>();
        opList.forEach((l) -> {
            if (weekdays.contains(l.getWeekday())) optionalLectureParts.add(l);
        });
        return optionalLectureParts;
    }

    private List<Weekday> getAllDaysForLecture(List<Lecture> lectures) {
        List<Weekday> weekdays = new ArrayList<>();
        lectures.forEach((l) -> {
            l.getLectureParts().forEach((lp) -> {
                if (!weekdays.contains(lp.getWeekday())) {
                    weekdays.add(lp.getWeekday());
                }
            });
        });
        return weekdays;
    }

    /**
     * Muss alle optionalen LectureParts die moeglich sind identifizieren und zurueckliefern
     * TODO: geht nur mit einer Liste
     *
     * @param lectures
     */
    public List<LecturePart> getOptionalLecturePartsForLecture(List<Lecture> lectures) {
        List<LecturePart> possibleOptionalLP = new ArrayList<>();

        for (Lecture lecture : lectures) {
            List<OptionalLecturePart> optionalLectureParts = lecture.getVariableLectureParts();
            if (optionalLectureParts != null && !optionalLectureParts.isEmpty()) {
                // Liste vorhanden, nun pruefen, welche passen
                possibleOptionalLP.addAll(new LectureHelper().getPossibleOptionalLectureParts(optionalLectureParts, lectures));
            }
        }
        return possibleOptionalLP;
    }

    private List<LecturePart> getPossibleOptionalLectureParts(List<OptionalLecturePart> optionalLectureParts, List<Lecture> lectures) {
        List<LecturePart> possibleOptionalLP = new ArrayList<>();
        DefaultTimetableCalculator calculator = new DefaultTimetableCalculator();
        List<OptionalLecturePart> optionalLecturePartsFiltered = new LectureHelper().getAllOptionalLecturePartsAtSameDaysAsLectures(optionalLectureParts, lectures);
        // fuer alle optionalen LectureParts
        for (LecturePart optionalLecturePart : optionalLecturePartsFiltered) {
            boolean isOptionalLecturePartPossible = true;
            // pruefen, dass es keine Ueberlappung gibt
            for (Lecture lecture : lectures) {
                for (LecturePart lecturePart : lecture.getLectureParts()) {
                    if (new OverlappingSpecification().isLecturePartOverlapping(optionalLecturePart, lecturePart)) {
                        isOptionalLecturePartPossible = false;
                    }
                }
            }
            if (isOptionalLecturePartPossible) {
                possibleOptionalLP.add(optionalLecturePart);
            }
        }

        return possibleOptionalLP;
    }
}
