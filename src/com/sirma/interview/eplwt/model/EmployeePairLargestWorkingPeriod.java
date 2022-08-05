package com.sirma.interview.eplwt.model;

/**
 * Stores a pair of employees, who have worked together on common projects for the longest
 * period of time, and the working period.
 **/
public record EmployeePairLargestWorkingPeriod(long firstEmployeeId, long secondEmployeeId, long period) {

    @Override
    public String toString() {
        return String.format("%d, %d, %d", firstEmployeeId, secondEmployeeId, period);
    }

}
