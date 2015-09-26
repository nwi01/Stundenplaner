package de.nwi.api.model;

import de.nwi.api.enums.Weekday;

import java.util.List;

/**
 * Created by niels on 24.09.2015.
 */
public interface DayTask {
    Weekday getWeekDay();

    List<LecturePart> getAllLecturePartsForDay();

    void setWeekday(Weekday weekday);

    void setLecturePartsForDay(List<LecturePart> lecturePartsForDay);
}
