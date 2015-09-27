package de.nwi.impl.model;

import de.nwi.api.model.DayTask;
import de.nwi.api.model.LecturePart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niels on 26.09.2015.
 */
public class OptionalDayTask extends DefaultDayTask {
    private List<LecturePart> optionalLectureParts = new ArrayList<>();

    public OptionalDayTask() {
        super();
    }

    public OptionalDayTask(DayTask dayTask, LecturePart lecturePart) {
        this.setLecturePartsForDay(dayTask.getAllLecturePartsForDay());
        this.setWeekday(dayTask.getWeekDay());
        this.optionalLectureParts.add(lecturePart);
    }

    public List<LecturePart> getOptionalLectureParts() {
        return optionalLectureParts;
    }

    public void setOptionalLectureParts(List<LecturePart> optionalLectureParts) {
        this.optionalLectureParts = optionalLectureParts;
    }

    public void addOptionalLecturePart(LecturePart optLecturePart) {
        optionalLectureParts.add(optLecturePart);
    }

    @Override
    public List<LecturePart> getAllLecturePartsForDay() {
        List<LecturePart> allLecturePartsWithOptionalParts = super.getAllLecturePartsForDay();
        allLecturePartsWithOptionalParts.addAll(optionalLectureParts);
        return allLecturePartsWithOptionalParts;
    }
}
