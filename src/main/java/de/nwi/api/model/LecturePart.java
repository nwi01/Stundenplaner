package de.nwi.api.model;

import de.nwi.api.enums.Location;
import de.nwi.api.enums.Weekday;

import java.time.LocalTime;

/**
 * Created by niels on 24.09.2015.
 */
public interface LecturePart extends Comparable<LecturePart> {
    String getLectureName();

    void setLectureName(String lectureName);

    Weekday getWeekday();

    LocalTime getStartTime();

    LocalTime getEndTime();

    Location getLocation();

    void setStartTime(LocalTime startTime);

    void setEndTime(LocalTime endTime);

    void setLocation(Location location);
}
