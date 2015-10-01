package de.nwi.impl.model;

import de.nwi.Stundenplaner;
import de.nwi.api.enums.Weekday;
import de.nwi.api.model.*;
import de.nwi.impl.DefaultTimetableCalculator;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by niels on 24.09.2015.
 */
public class DefaultTimetable implements Timetable {
    private LinkedHashMap<Weekday, DayTask> dayTasks = new LinkedHashMap<Weekday, DayTask>();
    private static final String SEPARATOR = "################\n";
    private static final String OPTIONAL_MARKER = "(Nur eins wählen)";
    private List<Lecture> lectures = new ArrayList();


    public DefaultTimetable(){

    }

    public DefaultTimetable(List<Lecture> lectures){
        this.lectures = lectures;
    }

    public LinkedHashMap<Weekday, DayTask> getAllDayTasks() {
        return dayTasks;
    }

    public void setDayTasks(LinkedHashMap<Weekday, DayTask> dayTasks) {
        this.dayTasks = dayTasks;
    }

    @Override
    public String toString() {
        if (Stundenplaner.DISPLAY_FULL_INFO) return getFullInfo();

        return getShortInfo();
    }

    private int getRating(){
        Integer rating = 0;
        for(Lecture lecture : lectures){
            rating += lecture.getRating();
        }
        return rating;
    }

    private StringBuilder getDefaultInfo(){
        StringBuilder builder = new StringBuilder();
        builder.append("\n")
                .append(SEPARATOR)
                .append("Stundenplan\n")
                .append(SEPARATOR);

        builder.append("Vorlesungen: (" + getRating() +" Credits):\n");

                lectures.forEach(l -> builder.append("\t" + l.getName() + "\n"));
        builder.append("\n");
        return builder;
    }

    private String getFullInfo() {
        StringBuilder builder = getDefaultInfo();
        dayTasks.forEach((w, t) -> {
            List<LecturePart> allLecturePartsForDay = t.getAllLecturePartsForDay();
            if (!allLecturePartsForDay.isEmpty()) {
                builder.append(w.getName() + "\n");
                Collections.sort(allLecturePartsForDay);
                allLecturePartsForDay.forEach((l) -> {
                    builder.append(l.getStartTime().format(DateTimeFormatter.ofPattern("HH:mm")) + "- ")
                            .append(l.getEndTime().format(DateTimeFormatter.ofPattern("HH:mm")))
                            .append("  - " + l.getLectureName())
                            .append("   (" + l.getLocation() + ")");
                    if (l instanceof OptionalLecturePart) {
                        builder.append(" " + OPTIONAL_MARKER);
                    }
                    builder.append("\n");
                });
            }
        });
        return builder.toString();
    }

    private String getShortInfo() {
        StringBuilder builder = getDefaultInfo();
        dayTasks.forEach((w, t) -> {
            List<LecturePart> allLecturePartsForDay = t.getAllLecturePartsForDay();
            if (!allLecturePartsForDay.isEmpty()) {
                builder.append(w.getName() + ": ");
                Collections.sort(allLecturePartsForDay);

                // Erster Vorlesungsbegin && Letztes Vorlesungsende
                builder.append(allLecturePartsForDay.get(0).getStartTime().format(DateTimeFormatter.ofPattern("HH:mm")) + "- ")
                        .append(allLecturePartsForDay.get(allLecturePartsForDay.size() - 1).getEndTime().format(DateTimeFormatter.ofPattern("HH:mm")))
                        .append("\n");
            }
        });
        return builder.toString();
    }

    public static Timetable from(List<Lecture> lectures) {
        Timetable timetable = new DefaultTimetable(lectures);

        LinkedHashMap<Weekday, DayTask> dayTasks = new LinkedHashMap<Weekday, DayTask>();

        for (Weekday weekday : Weekday.values()) {
            DayTask dayTask = new DefaultDayTask();
            List<LecturePart> lectureParts = new ArrayList<LecturePart>();
            for (Lecture lecture : lectures) {
                for (LecturePart lecturePart : lecture.getLectureParts()) {
                    if (lecturePart.getWeekday().equals(weekday)) {
                        lectureParts.add(lecturePart);
                    }
                }
            }
            dayTask.setLecturePartsForDay(lectureParts);
            dayTasks.put(weekday, dayTask);
        }

        List<LecturePart> optionalLectureParts = getOptionalLecturePartsForLecture(lectures);
        for (LecturePart optLecturePart : optionalLectureParts) {
            DayTask dayTaskTemp = dayTasks.get(optLecturePart.getWeekday());
            if (dayTaskTemp != null) {
                // Falls es noch kein optionalDayTask ist
                if (!(dayTaskTemp instanceof OptionalDayTask)) {
                    dayTasks.put(
                            optLecturePart.getWeekday(),
                            new OptionalDayTask(dayTaskTemp, optLecturePart));
                } else {
                    ((OptionalDayTask) dayTaskTemp).addOptionalLecturePart(optLecturePart);
                }
            }
        }

        timetable.setDayTasks(dayTasks);
        return timetable;
    }

    /**
     * Muss alle optionalen LectureParts die moeglich sind identifizieren und zurueckliefern
     * TODO: geht nur mit einer Liste
     *
     * @param lectures
     */
    private static List<LecturePart> getOptionalLecturePartsForLecture(List<Lecture> lectures) {
        List<LecturePart> possibleOptionalLP = new ArrayList<>();

        for (Lecture lecture : lectures) {
            List<OptionalLecturePart> optionalLectureParts = lecture.getVariableLectureParts();
            if (optionalLectureParts != null && !optionalLectureParts.isEmpty()) {
                // Liste vorhanden, nun pruefen, welche passen
                possibleOptionalLP.addAll(getPossibleOptionalLectureParts(optionalLectureParts, lectures));
            }
        }
        return possibleOptionalLP;
    }

    private static List<LecturePart> getPossibleOptionalLectureParts(List<OptionalLecturePart> optionalLectureParts, List<Lecture> lectures) {
        List<LecturePart> possibleOptionalLP = new ArrayList<>();
        DefaultTimetableCalculator calculator = new DefaultTimetableCalculator();
        List<OptionalLecturePart> optionalLecturePartsFiltered = calculator.filterForDays(optionalLectureParts, lectures);
        // fuer alle optionalen LectureParts
        for (LecturePart optionalLecturePart : optionalLecturePartsFiltered) {
            boolean isOptionalLecturePartPossible = true;
            // pruefen, dass es keine ueberlappung gibt
            for (Lecture lecture : lectures) {
                for (LecturePart lecturePart : lecture.getLectureParts()) {
                    if (calculator.isLecturePartOverlapping(optionalLecturePart, lecturePart)) {
                        isOptionalLecturePartPossible = false;
                    }
                }
            }
            if (isOptionalLecturePartPossible) {
                possibleOptionalLP.add(optionalLecturePart);
            }
        }

        return possibleOptionalLP;
    }
}
