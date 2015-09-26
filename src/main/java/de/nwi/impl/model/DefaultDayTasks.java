package de.nwi.impl.model;

import de.nwi.api.model.DayTask;
import de.nwi.api.model.LecturePart;
import de.nwi.api.enums.Weekday;

import java.util.List;

/**
 * Created by niels on 24.09.2015.
 */
public class DefaultDayTasks implements DayTask {
    private Weekday weekday;
    private List<LecturePart> lecturePartsForDay;

    public Weekday getWeekDay() {
        return weekday;
    }

    public List<LecturePart> getAllLecturePartsForDay() {
        return lecturePartsForDay;
    }

    public void setWeekday(Weekday weekday) {
        this.weekday = weekday;
    }

    public void setLecturePartsForDay(List<LecturePart> lecturePartsForDay) {
        this.lecturePartsForDay = lecturePartsForDay;
    }
}
