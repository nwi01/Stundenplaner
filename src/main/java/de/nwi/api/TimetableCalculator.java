package de.nwi.api;

import de.nwi.api.model.Lecture;
import de.nwi.api.model.Timetable;

import java.util.List;

/**
 * Created by niels on 24.09.2015.
 */
public interface TimetableCalculator {
    List<Timetable> getAllPossibleTimetables();

    List<Lecture> getAllLectures();


}
