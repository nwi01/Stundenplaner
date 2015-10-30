package de.nwi.test.util;

import de.nwi.api.LectureRepository;
import de.nwi.api.model.Lecture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niels on 30.10.2015.
 */
public class TestLectureRepository implements LectureRepository {
    private List<Lecture> lectures = new ArrayList<>();

    public TestLectureRepository(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    @Override
    public List<Lecture> getAllLectures() {
        return null;
    }
}
