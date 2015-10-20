package de.nwi.impl.timetableCalculator.specification;

import de.nwi.api.model.Lecture;
import de.nwi.api.timetableCalculation.specification.LectureListSpecification;
import de.nwi.api.timetableCalculation.specification.SpecificationChecker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niels on 20.10.2015.
 */
public class DefaultSpecificationChecker implements SpecificationChecker<LectureListSpecification, Lecture> {
    private List<LectureListSpecification> specifications = new ArrayList<>();

    public DefaultSpecificationChecker(int days) {
        this.specifications.add(new DaysSpecification(days));
        this.specifications.add(new OverlappingSpecification());
        this.specifications.add(new OptionalLecturePartsSpecification());
    }

    @Override
    public void setSpecifications(List<LectureListSpecification> specifications) {
        this.specifications = specifications;
    }

    @Override
    public boolean isSatisfiedBy(List<Lecture> listToCheck) {
        for (LectureListSpecification spec : specifications) {
            if (!spec.isSatisfiedBy(listToCheck)) return false;
        }
        return true;
    }
}
