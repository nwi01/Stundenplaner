package de.nwi.api.model;

import java.util.List;

/**
 * Created by niels on 24.09.2015.
 */
public interface Lecture {
    String getName();

    // Einzelne Vorlesungstermine
    List<LecturePart> getLectureParts();

    public void setName(String name);

    public void setLectureParts(List<LecturePart> lectureParts);

    // Liste mit Elementen, bei denen nur eins gewählt werden muss
    List<OptionalLecturePart> getVariableLectureParts();

    void setVariableLectureParts(List<OptionalLecturePart> list);
}
