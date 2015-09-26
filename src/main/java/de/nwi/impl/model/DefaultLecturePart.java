package de.nwi.impl.model;

import de.nwi.api.enums.Weekday;
import de.nwi.api.model.DayTask;
import de.nwi.api.model.LecturePart;
import de.nwi.api.enums.Location;

import java.time.LocalTime;

/**
 * Created by niels on 24.09.2015.
 */
public class DefaultLecturePart implements LecturePart {
    private LocalTime startTime;
    private LocalTime endTime;
    private Location location;
    private Weekday weekday;
    private String lectureName;

    public DefaultLecturePart() {

    }

    public DefaultLecturePart(LocalTime startTime, LocalTime endTime, Location location, Weekday weekday, String lectureName) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.weekday = weekday;
        this.lectureName = lectureName;
    }

    @Override
    public String getLectureName() {
        return lectureName;
    }

    @Override
    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public Weekday getWeekday() {
        return weekday;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Location getLocation() {
        return location;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public int compareTo(LecturePart o) {
        if (this.getStartTime().isBefore(o.getStartTime())) return -1;
        if (o.getStartTime().equals(this.getStartTime())) return 0;
        if (this.getStartTime().isAfter(o.getStartTime())) return 1;
        return 0;
    }
}
