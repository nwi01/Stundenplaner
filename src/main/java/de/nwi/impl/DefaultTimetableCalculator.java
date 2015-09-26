package de.nwi.impl;

import de.nwi.api.enums.Weekday;
import de.nwi.api.model.Lecture;
import de.nwi.api.model.LecturePart;
import de.nwi.api.model.Timetable;
import de.nwi.api.TimetableCalculator;
import de.nwi.impl.model.DefaultTimetable;
import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;
import sun.nio.cs.Surrogate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niels on 24.09.2015.
 */
public class DefaultTimetableCalculator implements TimetableCalculator {
    private List<Timetable> possibleTimetables = new ArrayList<Timetable>();
    private List<Lecture> allLectures;
    private int quantityOfLectures = 5;
    private int quantityOfDays = 3;

    public DefaultTimetableCalculator(List<Lecture> allLectures, int quantityOfLectures, int quantityOfDays) {
        this.allLectures = allLectures;
        this.quantityOfLectures = quantityOfLectures;
        this.quantityOfDays = quantityOfDays;
    }

    public List<Timetable> getAllPossibleTimetables() {
        if (allLectures != null) {
            calc();
        }
        return possibleTimetables;
    }

    private void calc() {
        List<List<Lecture>> lectureVariations = getLectureVariation(quantityOfLectures);
        for (List<Lecture> lectureVariation : lectureVariations) {
            if (!areLecturesOverlapping(lectureVariation) && considerQuantityOfDays(lectureVariation)) {
                Timetable timetable = DefaultTimetable.from(lectureVariation);
                possibleTimetables.add(timetable);
            }
        }
    }

    private boolean considerQuantityOfDays(List<Lecture> lectures) {
        List<Weekday> weekdaysForLectures = new ArrayList<>();
        for (Lecture lecture : lectures) {
            for (LecturePart lecturePart : lecture.getLectureParts()) {
                if (!weekdaysForLectures.contains(lecturePart.getWeekday())) {
                    weekdaysForLectures.add(lecturePart.getWeekday());
                }
            }
        }

        return quantityOfDays >= weekdaysForLectures.size();
    }

    private List<List<Lecture>> getLectureVariation(int quantity) {
        List<List<Lecture>> lectureVariations = new ArrayList<List<Lecture>>();
        ICombinatoricsVector<Lecture> lectures = Factory.createVector(allLectures);
        Generator<Lecture> gen = Factory.createSimpleCombinationGenerator(lectures, quantity);
        gen.forEach((c) -> lectureVariations.add(c.getVector()));
        return lectureVariations;
    }

    /**
     * -----
     * -----
     * <p>
     * ----
     * -----
     * <p>
     * -----
     * -----
     * <p>
     * ----
     * ------
     * <p>
     * --------
     * ----
     *
     * @param lectures
     * @return
     */
    private boolean areLecturesOverlapping(List<Lecture> lectures) {
        // Normale Ueberlappung testen
        for (int i = 0; i < lectures.size() - 1; i++) {
            for (int j = i + 1; j < lectures.size(); j++) {
                List<LecturePart> lectureParts = lectures.get(i).getLectureParts();
                List<LecturePart> otherLectureParts = lectures.get(j).getLectureParts();
                for (LecturePart lecturePart : lectureParts) {
                    for (LecturePart otherLecturePart : otherLectureParts) {
                        if (isLecturePartOverlapping(lecturePart, otherLecturePart)) {
                            return true;
                        }
                    }
                }
            }
        }
        // Nun pruefen, ob aus den variableLectureParts LectureParts gibt, die sich ueberlappen
        List<LecturePart> allLectureParts = new ArrayList<>();
        lectures.forEach((l) -> allLectureParts.addAll(l.getLectureParts()));

        lectures.forEach((l) -> {
            if(l.getVariableLectureParts() != null && !l.getVariableLectureParts().isEmpty()){

            }
        });
        return false;
    }

    private boolean isLecturePartOverlapping(LecturePart lecturePart, LecturePart otherLecturePart) {
        if(!lecturePart.getWeekday().equals(otherLecturePart.getWeekday())) return false;
        boolean startTimesAreEqual = lecturePart.getStartTime().equals(otherLecturePart.getStartTime());
        boolean endTimesAreEqual = lecturePart.getEndTime().equals(otherLecturePart.getEndTime());
        return  // 10:00 - 11:00 | 10:00 - 11:00
                (startTimesAreEqual && endTimesAreEqual) ||
                        // 10:00 - 13:00 | 10:30 - 12:00
                        ((lecturePart.getStartTime().isBefore(otherLecturePart.getStartTime()) || startTimesAreEqual) &&
                                (lecturePart.getEndTime().isAfter(otherLecturePart.getStartTime()) || endTimesAreEqual)) ||
                        // 10:30 - 12:00 | 10:00 - 13:00
                        ((otherLecturePart.getStartTime().isBefore(lecturePart.getStartTime()) || startTimesAreEqual) &&
                                (otherLecturePart.getEndTime().isAfter(lecturePart.getStartTime()) || endTimesAreEqual)) ||
                        // 10:30 - 11:00 | 10:00 - 12:00
                        ((lecturePart.getStartTime().isAfter(otherLecturePart.getStartTime()) || startTimesAreEqual) &&
                                (lecturePart.getEndTime().isBefore(otherLecturePart.getEndTime()) || endTimesAreEqual)) ||
                        // 10:00 - 12:00 | 10:30 - 11:00
                        ((otherLecturePart.getStartTime().isAfter(lecturePart.getStartTime()) || startTimesAreEqual) &&
                                (otherLecturePart.getEndTime().isBefore(lecturePart.getEndTime()) || endTimesAreEqual));
    }

    public List<Lecture> getAllLectures() {
        return allLectures;
    }

    public void setPossibleTimetables(List<Timetable> possibleTimetables) {
        this.possibleTimetables = possibleTimetables;
    }
}
