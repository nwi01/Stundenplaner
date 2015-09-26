package de.nwi.impl.model;

import de.nwi.api.enums.Weekday;
import de.nwi.api.model.DayTask;
import de.nwi.api.model.Lecture;
import de.nwi.api.model.LecturePart;
import de.nwi.api.model.Timetable;

import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by niels on 24.09.2015.
 */
public class DefaultTimetable implements Timetable {
    private LinkedHashMap<Weekday, DayTask> dayTasks = new LinkedHashMap<Weekday, DayTask>();
    private static final String SEPARATOR = "################\n";

    public LinkedHashMap<Weekday, DayTask> getAllDayTasks() {
        return dayTasks;
    }

    public void setDayTasks(LinkedHashMap<Weekday, DayTask> dayTasks) {
        this.dayTasks = dayTasks;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder
                .append("\n")
                .append(SEPARATOR)
                .append("Stundenplan\n")
                .append(SEPARATOR);
        dayTasks.forEach((w, t) -> {
            if (!t.getAllLecturePartsForDay().isEmpty()) {
                builder.append(w.getName() + "\n");
                List<LecturePart> lectureParts = t.getAllLecturePartsForDay();
                Collections.sort(lectureParts);
                lectureParts.forEach((l) -> {
                    builder.append(l.getStartTime().format(DateTimeFormatter.ofPattern("HH:mm")) + "- ")
                            .append(l.getEndTime().format(DateTimeFormatter.ofPattern("HH:mm")))
                            .append("  - " + l.getLectureName())
                            .append("   (" + l.getLocation() + ")\n");
                });
            }
        });
        return builder.toString();
    }

    public static Timetable from(List<Lecture> lectures) {
        Timetable timetable = new DefaultTimetable();

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
     * Muss alle optionalen LectureParts die Moeglich sind identifizieren und zurueckliefern
     * TODO: geht nur mit einer Liste
     *
     * @param lectures
     */
    private static List<LecturePart> getOptionalLecturePartsForLecture(List<Lecture> lectures) {
        throw new RuntimeException("Noch nicht implementiert");
    }
}
