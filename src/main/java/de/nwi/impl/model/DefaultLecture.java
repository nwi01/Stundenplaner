package de.nwi.impl.model;

import de.nwi.api.model.Lecture;
import de.nwi.api.model.LecturePart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niels on 24.09.2015.
 */
public class DefaultLecture implements Lecture {
    private String name;
    private List<LecturePart> lectureParts;
    private List<List<LecturePart>> variableLectureParts = new ArrayList<>();

    public DefaultLecture(){

    }

    public DefaultLecture(String name, List<LecturePart> lectureParts, List<List<LecturePart>> variableLectureParts){
        this.name = name;
        this.lectureParts = lectureParts;
        this.variableLectureParts = variableLectureParts;
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
    public List<List<LecturePart>> getVariableLectureParts() {
        return variableLectureParts;
    }

    @Override
    public void setVariableLectureParts(List<List<LecturePart>> list) {
        this.variableLectureParts = list;
    }
}
