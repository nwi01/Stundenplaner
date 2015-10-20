package de.nwi.impl.timetableCalculator.specification;

import de.nwi.api.enums.Weekday;
import de.nwi.api.model.Lecture;
import de.nwi.api.model.LecturePart;
import de.nwi.api.timetableCalculation.specification.LectureListSpecification;

import java.util.ArrayList;
import java.util.List;

/**
 * Spezifikation, um die Anzahl der Tage, an denen die Vorlesungen statfinden
 * einzugrenzen
 * Created by niels on 20.10.2015.
 */
public class DaysSpecification implements LectureListSpecification {
    private int days = 5;

    public DaysSpecification(int days) {
        this.days = days;
    }

    @Override
    public boolean isSatisfiedBy(List<Lecture> lectures) {
        List<Weekday> weekdaysForLectures = new ArrayList<>();
        for (Lecture lecture : lectures) {
            for (LecturePart lecturePart : lecture.getLectureParts()) {
                if (!weekdaysForLectures.contains(lecturePart.getWeekday())) {
                    weekdaysForLectures.add(lecturePart.getWeekday());
                }
            }
        }

        return days >= weekdaysForLectures.size();
    }
}
