package de.nwi;

import de.nwi.api.LectureRepository;
import de.nwi.api.TimetableCalculator;
import de.nwi.api.model.Timetable;
import de.nwi.impl.DefaultLectureRepository;
import de.nwi.impl.DefaultTimetableCalculator;
import de.nwi.impl.SampleLectureRepository;

import java.sql.Time;
import java.util.List;

/**
 * Created by niels on 24.09.2015.
 */
public class Stundenplaner {
    private static int QUANTITY_LECTURES = 5;
    private static int QUANTITY_DAYS = 3;

    private static LectureRepository repository = new DefaultLectureRepository();

    public static void main(String[] args) {
        TimetableCalculator calculator = new DefaultTimetableCalculator(
                repository.getAllLectures(),
                QUANTITY_LECTURES, QUANTITY_DAYS);
        List<Timetable> possibleTimetables = calculator.getAllPossibleTimetables();

        if (possibleTimetables != null && !possibleTimetables.isEmpty()) {
            for (Timetable timetable : possibleTimetables) {
                System.out.println(timetable);
            }
            System.out.println("###############");
            System.out.println("Es wurden " + possibleTimetables.size() + " Stundepläne erstellt.");
            System.out.println("###############");
        } else {
            System.out.println("Es konnte kein Terminplan zusammengestellt werden.");
        }
    }
}
