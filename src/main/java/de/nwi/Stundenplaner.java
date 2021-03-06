package de.nwi;

import de.nwi.api.LectureRepository;
import de.nwi.api.model.Timetable;
import de.nwi.api.timetableCalculation.TimetableCalculator;
import de.nwi.impl.DefaultLectureRepository;
import de.nwi.impl.timetableCalculator.DefaultTimetableCalculator;

import java.util.List;

/**
 * Created by niels on 24.09.2015.
 */
public class Stundenplaner {
    private static int QUANTITY_LECTURES = 5;
    private static int QUANTITY_DAYS = 3;
    public static boolean DISPLAY_FULL_INFO = true;

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
            System.out.println("Es konnte kein Stundenplan zusammengestellt werden.");
        }
    }
}
