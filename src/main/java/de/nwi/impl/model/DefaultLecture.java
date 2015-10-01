package de.nwi.impl.model;

import de.nwi.api.model.Lecture;
import de.nwi.api.model.LecturePart;
import de.nwi.api.model.OptionalLecturePart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niels on 24.09.2015.
 */
public class DefaultLecture implements Lecture {
    private String name;
    private List<LecturePart> lectureParts;
    private List<OptionalLecturePart> variableLectureParts = new ArrayList<>();
    private int etcs = 0;

    public DefaultLecture() {

    }

    public DefaultLecture(String name, List<LecturePart> lectureParts, List<OptionalLecturePart> variableLectureParts) {
        this.name = name;
        this.lectureParts = lectureParts;
        this.variableLectureParts = variableLectureParts;
    }
    public DefaultLecture(String name, List<LecturePart> lectureParts, List<OptionalLecturePart> variableLectureParts, int etcs) {
        this.name = name;
        this.lectureParts = lectureParts;
        this.variableLectureParts = variableLectureParts;
        this.etcs = etcs;
    }


    public String getName() {
        return name;
    }

    public List<LecturePart> getLectureParts() {
        return lectureParts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLectureParts(List<LecturePart> lectureParts) {
        this.lectureParts = lectureParts;
    }

    @Override
    public List<OptionalLecturePart> getVariableLectureParts() {
        return variableLectureParts;
    }

    @Override
    public void setVariableLectureParts(List<OptionalLecturePart> list) {
        this.variableLectureParts = list;
    }

    @Override
    public int getRating() {
        return etcs;
    }

    @Override
    public void setRating(int rating) {
        this.etcs = etcs;
    }
}
