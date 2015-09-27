package de.nwi.impl.model;

import de.nwi.api.enums.Location;
import de.nwi.api.enums.Weekday;
import de.nwi.api.model.Lecture;
import de.nwi.api.model.OptionalLecturePart;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by niels on 27.09.2015.
 */
public class DefaultOptionalLecturePart extends DefaultLecturePart implements OptionalLecturePart {
    public DefaultOptionalLecturePart() {
        super();
    }

    public DefaultOptionalLecturePart(LocalTime startTime, LocalTime endTime, Location location, Weekday weekday, String lectureName) {
        super(startTime, endTime, location, weekday, lectureName);
    }
}
