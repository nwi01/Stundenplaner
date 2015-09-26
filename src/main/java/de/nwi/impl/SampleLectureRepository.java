package de.nwi.impl;

import de.nwi.api.LectureRepository;
import de.nwi.api.enums.Location;
import de.nwi.api.enums.Weekday;
import de.nwi.api.model.Lecture;
import de.nwi.api.model.LecturePart;
import de.nwi.impl.model.DefaultLecture;
import de.nwi.impl.model.DefaultLecturePart;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by niels on 25.09.2015.
 */
public class SampleLectureRepository implements LectureRepository {
    @Override
    public List<Lecture> getAllLectures() {
        List<Lecture> lectures = new ArrayList<Lecture>();
        lectures.add(createLecture("Virtuelle Realität",
                LocalTime.of(12, 15),
                LocalTime.of(13, 45),
                Weekday.MONDAY,
                LocalTime.of(12, 30),
                LocalTime.of(13, 15),
                Weekday.TUESDAY,
                LocalTime.of(13, 15),
                LocalTime.of(14, 0),
                Weekday.TUESDAY));

        lectures.add(createLecture("Communication Systems Engineering",
                LocalTime.of(16, 15),
                LocalTime.of(17, 45),
                Weekday.MONDAY,
                LocalTime.of(10, 15),
                LocalTime.of(11, 45),
                Weekday.TUESDAY,
                LocalTime.of(14, 15),
                LocalTime.of(15, 45),
                Weekday.THURSDAY));

        lectures.add(createLecture("Content-based Multimedia Search",
                LocalTime.of(15, 15),
                LocalTime.of(17, 30),
                Weekday.TUESDAY,
                LocalTime.of(16, 15),
                LocalTime.of(17, 45),
                Weekday.THURSDAY));

        lectures.add(createLecture("Objektorientierte Software-Konstruktion",
                LocalTime.of(8, 30),
                LocalTime.of(10, 0),
                Weekday.THURSDAY,
                LocalTime.of(8, 30),
                LocalTime.of(10, 0),
                Weekday.FRIDAY,
                LocalTime.of(10, 15),
                LocalTime.of(11, 45),
                Weekday.FRIDAY));

        lectures.add(createLecture("Modellierung und Verifikation probabilistischer Systeme",
                LocalTime.of(8, 30),
                LocalTime.of(10, 00),
                Weekday.TUESDAY,
                LocalTime.of(10, 15),
                LocalTime.of(11, 45),
                Weekday.WEDNESDAY,
                LocalTime.of(14, 15),
                LocalTime.of(15, 45),
                Weekday.WEDNESDAY));
        return lectures;
    }

    private Lecture createLecture(String lectureName,
                                  LocalTime start1, LocalTime end1, Weekday w1,
                                  LocalTime start2, LocalTime end2, Weekday w2,
                                  LocalTime start3, LocalTime end3, Weekday w3) {
        List<LecturePart> lecturePart = new ArrayList<LecturePart>();
        LecturePart lecturePart1 = new DefaultLecturePart(
                start1,
                end1,
                Location.INFORMATIK_ZENTRUM,
                w1,
                lectureName);
        lecturePart.add(lecturePart1);
        LecturePart lecturePart2 = new DefaultLecturePart(
                start2,
                end2,
                Location.INFORMATIK_ZENTRUM,
                w2,
                lectureName);
        lecturePart.add(lecturePart2);
        LecturePart lecturePart3 = new DefaultLecturePart(
                start3,
                end3,
                Location.INFORMATIK_ZENTRUM,
                w3,
                lectureName);
        lecturePart.add(lecturePart3);
        return new DefaultLecture(lectureName, lecturePart, null);
    }

    private Lecture createLecture(String lectureName,
                                  LocalTime start1, LocalTime end1, Weekday w1,
                                  LocalTime start2, LocalTime end2, Weekday w2,
                                  LocalTime start3, LocalTime end3, Weekday w3,
                                  LocalTime start4, LocalTime end4, Weekday w4) {
        List<LecturePart> lecturePart = new ArrayList<LecturePart>();
        LecturePart lecturePart1 = new DefaultLecturePart(
                start1,
                end1,
                Location.INFORMATIK_ZENTRUM,
                w1,
                lectureName);
        lecturePart.add(lecturePart1);
        LecturePart lecturePart2 = new DefaultLecturePart(
                start2,
                end2,
                Location.INFORMATIK_ZENTRUM,
                w2,
                lectureName);
        lecturePart.add(lecturePart2);
        LecturePart lecturePart3 = new DefaultLecturePart(
                start3,
                end3,
                Location.INFORMATIK_ZENTRUM,
                w3,
                lectureName);
        lecturePart.add(lecturePart3);
        LecturePart lecturePart4 = new DefaultLecturePart(
                start4,
                end4,
                Location.INFORMATIK_ZENTRUM,
                w4,
                lectureName);
        lecturePart.add(lecturePart4);
        return new DefaultLecture(lectureName, lecturePart, null);
    }

    private Lecture createLecture(String lectureName,
                                  LocalTime start1, LocalTime end1, Weekday w1,
                                  LocalTime start2, LocalTime end2, Weekday w2) {
        List<LecturePart> lecturePart = new ArrayList<LecturePart>();
        LecturePart lecturePart1 = new DefaultLecturePart(
                start1,
                end1,
                Location.INFORMATIK_ZENTRUM,
                w1,
                lectureName);
        lecturePart.add(lecturePart1);
        LecturePart lecturePart2 = new DefaultLecturePart(
                start2,
                end2,
                Location.INFORMATIK_ZENTRUM,
                w2,
                lectureName);
        lecturePart.add(lecturePart2);
        return new DefaultLecture(lectureName, lecturePart, null);
    }

    private Lecture createLecture(String lectureName,
                                  LocalTime start1, LocalTime end1, Weekday w1) {
        List<LecturePart> lecturePart = new ArrayList<LecturePart>();
        LecturePart lecturePart1 = new DefaultLecturePart(
                start1,
                end1,
                Location.INFORMATIK_ZENTRUM,
                w1,
                lectureName);
        lecturePart.add(lecturePart1);
        return new DefaultLecture(lectureName, lecturePart, null);
    }
}
