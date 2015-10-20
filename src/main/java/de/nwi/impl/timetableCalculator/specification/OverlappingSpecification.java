package de.nwi.impl.timetableCalculator.specification;

import de.nwi.api.model.Lecture;
import de.nwi.api.model.LecturePart;
import de.nwi.api.timetableCalculation.specification.LectureListSpecification;

import java.util.List;

/**
 * Created by niels on 20.10.2015.
 */
public class OverlappingSpecification implements LectureListSpecification {
    @Override
    public boolean isSatisfiedBy(List<Lecture> lectures) {
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
        return false;
    }

    public boolean isLecturePartOverlapping(LecturePart lecturePart, LecturePart otherLecturePart) {
        if (!lecturePart.getWeekday().equals(otherLecturePart.getWeekday())) return false;
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
}
