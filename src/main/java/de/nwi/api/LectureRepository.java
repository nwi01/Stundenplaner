package de.nwi.api;

import de.nwi.api.model.Lecture;

import java.util.List;

/**
 * Created by niels on 24.09.2015.
 */
public interface LectureRepository {
    List<Lecture> getAllLectures();
}
