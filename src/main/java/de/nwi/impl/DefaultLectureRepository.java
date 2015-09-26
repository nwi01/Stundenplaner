package de.nwi.impl;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import de.nwi.api.LectureRepository;
import de.nwi.api.enums.Location;
import de.nwi.api.enums.Weekday;
import de.nwi.api.model.Lecture;
import de.nwi.api.model.LecturePart;
import de.nwi.impl.model.DefaultLecture;
import de.nwi.impl.model.DefaultLecturePart;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/**
 * Created by niels on 24.09.2015.
 */
public class DefaultLectureRepository implements LectureRepository {

    public List<Lecture> getAllLectures() {
        List<Lecture> lectures = new ArrayList<Lecture>();

        // 1
        lectures.add(createLecture("IT-Sicherheit 1 - Netzwerksicherheit",
                LocalTime.of(10, 15),
                LocalTime.of(11, 45),
                Weekday.MONDAY,
                LocalTime.of(10, 15),
                LocalTime.of(11, 45),
                Weekday.WEDNESDAY));
        lectures.add(createLecture("Foundations of Data Science",
                LocalTime.of(16, 15),
                LocalTime.of(17, 45),
                Weekday.MONDAY,
                LocalTime.of(8, 30),
                LocalTime.of(10, 0),
                Weekday.TUESDAY,
                LocalTime.of(15, 15),
                LocalTime.of(16, 45),
                Weekday.THURSDAY));

        lectures.add(createLecture("Modellbasierte Softwareentwicklung",
                LocalTime.of(10, 15),
                LocalTime.of(11, 45),
                Weekday.TUESDAY,
                LocalTime.of(15, 15),
                LocalTime.of(16, 0),
                Weekday.WEDNESDAY,
                LocalTime.of(12, 15),
                LocalTime.of(13, 45),
                Weekday.THURSDAY));

        lectures.add(createLecture("Advanced Internet Technology",
                LocalTime.of(12, 15),
                LocalTime.of(13, 45),
                Weekday.TUESDAY,
                LocalTime.of(14, 45),
                LocalTime.of(15, 45),
                Weekday.TUESDAY));

        lectures.add(createLecture("Advanced Methods of Cryptography (4,5 Credits)",
                LocalTime.of(8, 30),
                LocalTime.of(10, 0),
                Weekday.FRIDAY,
                LocalTime.of(10, 15),
                LocalTime.of(11, 0),
                Weekday.FRIDAY));

        // 2
        lectures.add(createLecture("Mobile Radio Networks 1 (4 Credits)",
                LocalTime.of(10, 15),
                LocalTime.of(12, 30),
                Weekday.MONDAY));

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

        // 3
        lectures.add(createLecture("Web Science (4 Credits)",
                LocalTime.of(10, 15),
                LocalTime.of(11, 45),
                Weekday.MONDAY,
                LocalTime.of(10, 15),
                LocalTime.of(11, 45),
                Weekday.FRIDAY));

        lectures.add(createLecture("Data Mining Algorithmen I",
                LocalTime.of(16, 15),
                LocalTime.of(17, 45),
                Weekday.MONDAY,
                LocalTime.of(13, 15),
                LocalTime.of(15, 30),
                Weekday.FRIDAY));

        lectures.add(createLecture("Basic Techniques in Computer Graphics",
                LocalTime.of(10, 15),
                LocalTime.of(11, 45),
                Weekday.TUESDAY,
                LocalTime.of(12, 15),
                LocalTime.of(13, 45),
                Weekday.WEDNESDAY,
                LocalTime.of(15, 15),
                LocalTime.of(16, 45),
                Weekday.WEDNESDAY,
                LocalTime.of(12, 15),
                LocalTime.of(13, 45),
                Weekday.FRIDAY));

        lectures.add(createLecture("Designing Interactive Systems I",
                LocalTime.of(13, 0),
                LocalTime.of(15, 30),  //CHECKME: Einmalig
                Weekday.TUESDAY,
                LocalTime.of(9, 15),
                LocalTime.of(11, 45),
                Weekday.WEDNESDAY,
                LocalTime.of(8, 30),
                LocalTime.of(10, 0),
                Weekday.THURSDAY));

        lectures.add(createLecture("Implementation of Databases",
                LocalTime.of(13, 30),
                LocalTime.of(15, 00),
                Weekday.TUESDAY,
                LocalTime.of(13, 30),
                LocalTime.of(15, 0),
                Weekday.THURSDAY));

        // 4
        lectures.add(createLecture("Einführung in statistische Klassifikation (8 Credits)",
                LocalTime.of(10, 15),
                LocalTime.of(11, 45),
                Weekday.MONDAY,
                LocalTime.of(10, 15),
                LocalTime.of(11, 45),
                Weekday.WEDNESDAY,
                LocalTime.of(12, 15),
                LocalTime.of(13, 45),
                Weekday.THURSDAY));

        lectures.add(createLecture("Automatic Speech Recognition (8Credits)",
                LocalTime.of(16, 15),
                LocalTime.of(17, 45),
                Weekday.MONDAY,
                LocalTime.of(10, 15),
                LocalTime.of(11, 45),
                Weekday.TUESDAY,
                LocalTime.of(10, 15),
                LocalTime.of(11, 45),
                Weekday.THURSDAY));

        lectures.add(createLecture("Computer Vision",
                LocalTime.of(14, 15),
                LocalTime.of(15, 45),
                Weekday.TUESDAY,
                LocalTime.of(14, 15),
                LocalTime.of(15, 45),
                Weekday.THURSDAY));

        // 5
        lectures.add(createLecture("Einführung in die technische Informatik",
                LocalTime.of(14, 15),
                LocalTime.of(15, 45),
                Weekday.MONDAY,
                LocalTime.of(16, 15),
                LocalTime.of(17, 45),
                Weekday.MONDAY,
                LocalTime.of(14, 15),
                LocalTime.of(15, 45),
                Weekday.THURSDAY));

        lectures.add(createLecture("Concurrency Theory",
                LocalTime.of(10, 15),
                LocalTime.of(11, 45),
                Weekday.MONDAY,
                LocalTime.of(14, 15),
                LocalTime.of(15, 45),
                Weekday.MONDAY,
                LocalTime.of(14, 15),
                LocalTime.of(15, 45),
                Weekday.THURSDAY));

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

        lectures.add(createLecture("Dynamische Systeme für Informatiker",
                LocalTime.of(10, 15),
                LocalTime.of(11, 45),
                Weekday.TUESDAY,
                LocalTime.of(12, 15),
                LocalTime.of(13, 45),
                Weekday.WEDNESDAY));


        // 6
        Lecture bukLecture = createLecture("Berechenbarkeit und Komplexität",
                LocalTime.of(18, 15),
                LocalTime.of(19, 45),
                Weekday.MONDAY,
                LocalTime.of(16, 15),
                LocalTime.of(17, 45),
                Weekday.FRIDAY);
        List<List<LecturePart>> list = new ArrayList<>();
        List<LecturePart> variableLectureParts = createLecturePartList(
                new DefaultLecturePart(
                        LocalTime.of(10, 15),
                        LocalTime.of(11, 45),
                        Location.INFORMATIK_ZENTRUM,
                        Weekday.MONDAY,
                        "Berechenbarkeit und Komplexität"),
                new DefaultLecturePart(
                        LocalTime.of(14, 15),
                        LocalTime.of(15, 45),
                        Location.INFORMATIK_ZENTRUM,
                        Weekday.MONDAY,
                        "Berechenbarkeit und Komplexität"),
                new DefaultLecturePart(
                        LocalTime.of(16, 15),
                        LocalTime.of(17, 45),
                        Location.INFORMATIK_ZENTRUM,
                        Weekday.MONDAY,
                        "Berechenbarkeit und Komplexität"),
                new DefaultLecturePart(
                        LocalTime.of(8, 30),
                        LocalTime.of(10, 00),
                        Location.INFORMATIK_ZENTRUM,
                        Weekday.TUESDAY,
                        "Berechenbarkeit und Komplexität"),
                new DefaultLecturePart(
                        LocalTime.of(12, 15),
                        LocalTime.of(13, 45),
                        Location.INFORMATIK_ZENTRUM,
                        Weekday.TUESDAY,
                        "Berechenbarkeit und Komplexität"),
                new DefaultLecturePart(
                        LocalTime.of(10, 15),
                        LocalTime.of(11, 45),
                        Location.INFORMATIK_ZENTRUM,
                        Weekday.WEDNESDAY,
                        "Berechenbarkeit und Komplexität"),
                new DefaultLecturePart(
                        LocalTime.of(12, 15),
                        LocalTime.of(13, 45),
                        Location.INFORMATIK_ZENTRUM,
                        Weekday.WEDNESDAY,
                        "Berechenbarkeit und Komplexität"),
                new DefaultLecturePart(
                        LocalTime.of(14, 15),
                        LocalTime.of(15, 45),
                        Location.INFORMATIK_ZENTRUM,
                        Weekday.WEDNESDAY,
                        "Berechenbarkeit und Komplexität"),
                new DefaultLecturePart(
                        LocalTime.of(16, 15),
                        LocalTime.of(17, 45),
                        Location.INFORMATIK_ZENTRUM,
                        Weekday.WEDNESDAY,
                        "Berechenbarkeit und Komplexität"),
                new DefaultLecturePart(
                        LocalTime.of(14, 15),
                        LocalTime.of(15, 45),
                        Location.INFORMATIK_ZENTRUM,
                        Weekday.THURSDAY,
                        "Berechenbarkeit und Komplexität"),
                new DefaultLecturePart(
                        LocalTime.of(16, 15),
                        LocalTime.of(17, 45),
                        Location.INFORMATIK_ZENTRUM,
                        Weekday.THURSDAY,
                        "Berechenbarkeit und Komplexität"),
                new DefaultLecturePart(
                        LocalTime.of(8, 30),
                        LocalTime.of(10, 0),
                        Location.INFORMATIK_ZENTRUM,
                        Weekday.FRIDAY,
                        "Berechenbarkeit und Komplexität"),
                new DefaultLecturePart(
                        LocalTime.of(10, 15),
                        LocalTime.of(11, 45),
                        Location.INFORMATIK_ZENTRUM,
                        Weekday.FRIDAY,
                        "Berechenbarkeit und Komplexität"),
                new DefaultLecturePart(
                        LocalTime.of(12, 15),
                        LocalTime.of(13, 45),
                        Location.INFORMATIK_ZENTRUM,
                        Weekday.FRIDAY,
                        "Berechenbarkeit und Komplexität")
        );

        list.add(variableLectureParts);
        bukLecture.setVariableLectureParts(list);
        lectures.add(bukLecture);

        lectures.add(createLecture("Advanced Internet Technology",
                LocalTime.of(12, 15),
                LocalTime.of(13, 45),
                Weekday.TUESDAY,
                LocalTime.of(14, 15),
                LocalTime.of(15, 45),
                Weekday.TUESDAY,
                LocalTime.of(10, 15),
                LocalTime.of(11, 45),
                Weekday.WEDNESDAY));

        lectures.add(createLecture("Infinite Computations",
                LocalTime.of(12, 15),
                LocalTime.of(13, 45),
                Weekday.THURSDAY,
                LocalTime.of(12, 15),
                LocalTime.of(13, 45),
                Weekday.FRIDAY,
                LocalTime.of(14, 15),
                LocalTime.of(15, 45),
                Weekday.FRIDAY));
        return lectures;
    }

    private List<LecturePart> createLecturePartList(LecturePart... lectureParts) {
        List<LecturePart> lecturePartList = new ArrayList<LecturePart>();
        for (LecturePart lecturePart : lectureParts) {
            lecturePartList.add(lecturePart);
        }

        return lecturePartList;
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
