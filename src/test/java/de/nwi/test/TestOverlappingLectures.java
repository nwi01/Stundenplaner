package de.nwi.test;

import de.nwi.api.LectureRepository;
import de.nwi.api.model.Lecture;
import de.nwi.api.model.Timetable;
import de.nwi.api.timetableCalculation.TimetableCalculator;
import de.nwi.impl.timetableCalculator.DefaultTimetableCalculator;
import de.nwi.test.util.TestLectureRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niels on 30.10.2015.
 */
public class TestOverlappingLectures {

    /**
     *
     */
    @Test
    public void testOverlappingLectures() {
        int quantityLectures = 2;
        int quantityDays = 2;
        TimetableCalculator calculator = new DefaultTimetableCalculator(
                getLectureRepository().getAllLectures(),
                quantityLectures, quantityDays);
        List<Timetable> possibleTimetables = calculator.getAllPossibleTimetables();
        checkTimetables(possibleTimetables);
    }

    private void checkTimetables(List<Timetable> timetables) {
        //TODO: Ueberpruefungen
    }

    private LectureRepository getLectureRepository() {
        List<Lecture> lectureList = new ArrayList<>();
        //TODO lectures setzen
        return new TestLectureRepository(lectureList);
    }
}
