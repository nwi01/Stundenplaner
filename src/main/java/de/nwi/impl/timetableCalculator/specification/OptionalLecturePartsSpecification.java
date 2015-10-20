package de.nwi.impl.timetableCalculator.specification;

import de.nwi.api.model.Lecture;
import de.nwi.api.model.LecturePart;
import de.nwi.api.model.OptionalLecturePart;
import de.nwi.impl.timetableCalculator.LectureHelper;

import java.util.List;

/**
 * Stellt sicher, dass min. 1 OptionalLecturePart in den Stundenplan passt.
 * <p>
 * FIXME: Funktioniert nur, wenn es eine Vorlesung mit OptionalLectureParts gibt
 * <p>
 * Created by niels on 20.10.2015.
 */
public class OptionalLecturePartsSpecification extends OverlappingSpecification {

    @Override
    public boolean isSatisfiedBy(List<Lecture> lectures) {
        //TODO: Funktioniert nur, wenn nicht mehr als eine Vorlesung variable LectureParts besitzt
        //Fuer jede variableLectureParts
        for (Lecture lecture : lectures) {
            List<OptionalLecturePart> optionalLectureParts = lecture.getVariableLectureParts();
            if (optionalLectureParts != null && !optionalLectureParts.isEmpty()) {
                optionalLectureParts = new LectureHelper().getAllOptionalLecturePartsAtSameDaysAsLectures(lecture.getVariableLectureParts(), lectures);
                for (OptionalLecturePart variableLecturePart : optionalLectureParts) {
                    // alle anderen LectureParts pruefen, ob es eine Ueberschneidung gibt
                    boolean overlappingFound = false;
                    for (Lecture lectureToCheck : lectures) {
                        overlappingFound = false;
                        for (LecturePart lecturePartToCheck : lectureToCheck.getLectureParts()) {
                            if (isLecturePartOverlapping(variableLecturePart, lecturePartToCheck))
                                overlappingFound = true;
                        }
                    }
                    // Falls eine ueberschneidung gefunden wurde
                    if (!overlappingFound) return true;
                }
            }
        }
        return false;
    }


}
