package de.nwi.api.timetableCalculation.specification;

/**
 * Interface fuer das Specification-Pattern
 * Created by niels on 20.10.2015.
 */
public interface Specification<T> {
    boolean isSatisfiedBy(T t);
}
