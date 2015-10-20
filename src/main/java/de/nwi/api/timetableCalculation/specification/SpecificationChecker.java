package de.nwi.api.timetableCalculation.specification;

import java.util.List;

/**
 * Created by niels on 20.10.2015.
 */
public interface SpecificationChecker<T extends Specification, E> {
    void setSpecifications(List<T> specifications);

    boolean isSatisfiedBy(List<E> listToCheck);
}
