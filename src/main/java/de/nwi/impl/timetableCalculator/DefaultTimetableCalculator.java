package de.nwi.impl.timetableCalculator;

import de.nwi.api.model.Lecture;
import de.nwi.api.model.Timetable;
import de.nwi.api.timetableCalculation.TimetableCalculator;
import de.nwi.api.timetableCalculation.specification.LectureListSpecification;
import de.nwi.api.timetableCalculation.specification.SpecificationChecker;
import de.nwi.impl.model.DefaultTimetable;
import de.nwi.impl.timetableCalculator.specification.DefaultSpecificationChecker;
import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niels on 24.09.2015.
 */
public class DefaultTimetableCalculator implements TimetableCalculator {
    private List<Timetable> possibleTimetables = new ArrayList<Timetable>();
    private List<Lecture> allLectures;
    private int quantityOfLectures = 5;
    private int quantityOfDays = 3;

    public DefaultTimetableCalculator() {

    }

    public DefaultTimetableCalculator(List<Lecture> allLectures, int quantityOfLectures, int quantityOfDays) {
        this.allLectures = allLectures;
        this.quantityOfLectures = quantityOfLectures;
        this.quantityOfDays = quantityOfDays;
    }

    public List<Timetable> getAllPossibleTimetables() {
        if (allLectures != null) {
            calc();
        }
        return possibleTimetables;
    }

    private void calc() {
        SpecificationChecker<LectureListSpecification, Lecture> checker = new DefaultSpecificationChecker(quantityOfDays);
        List<List<Lecture>> lectureVariations = getLectureVariation(quantityOfLectures);
        for (List<Lecture> lectureVariation : lectureVariations) {
            if (checker.isSatisfiedBy(lectureVariation)) {
                Timetable timetable = DefaultTimetable.from(lectureVariation);
                possibleTimetables.add(timetable);
            }
        }
    }

    private List<List<Lecture>> getLectureVariation(int quantity) {
        List<List<Lecture>> lectureVariations = new ArrayList<List<Lecture>>();
        ICombinatoricsVector<Lecture> lectures = Factory.createVector(allLectures);
        Generator<Lecture> gen = Factory.createSimpleCombinationGenerator(lectures, quantity);
        gen.forEach((c) -> lectureVariations.add(c.getVector()));
        return lectureVariations;
    }

    public List<Lecture> getAllLectures() {
        return allLectures;
    }

    public void setPossibleTimetables(List<Timetable> possibleTimetables) {
        this.possibleTimetables = possibleTimetables;
    }
}
