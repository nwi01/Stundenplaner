package de.nwi.api.model;

import de.nwi.api.enums.Weekday;
import de.nwi.api.model.DayTask;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by niels on 24.09.2015.
 */
public interface Timetable {
    public LinkedHashMap<Weekday,DayTask> getAllDayTasks();
    public void setDayTasks(LinkedHashMap<Weekday,DayTask> dayTasks);
}
