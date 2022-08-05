package com.sirma.interview.eplwt.model;

import java.util.Objects;

public class EmployeePairLargestWorkingPeriod {

    private static final long INVALID_EMPLOYEE_ID = -1;
    private static final long MIN_PERIOD = 0;
    private long firstEmployeeId;
    private long secondEmployeeId;
    private long period;

    /**
     * Stores a pair of employees, who have worked together on common projects for the longest
     * period of time, and the working period.
     **/
    public EmployeePairLargestWorkingPeriod() {
        this.firstEmployeeId = INVALID_EMPLOYEE_ID;
        this.secondEmployeeId = INVALID_EMPLOYEE_ID;
        this.period = MIN_PERIOD;
    }

    public EmployeePairLargestWorkingPeriod(int firstEmployeeId, int secondEmployeeId, long period) {
        this.firstEmployeeId = firstEmployeeId;
        this.secondEmployeeId = secondEmployeeId;
        this.period = period;
    }

    public long getFirstEmployeeId() {
        return firstEmployeeId;
    }

    public long getSecondEmployeeId() {
        return secondEmployeeId;
    }

    public long getPeriod() {
        return period;
    }

    public void setFirstEmployeeId(long firstEmployeeId) {
        this.firstEmployeeId = firstEmployeeId;
    }

    public void setSecondEmployeeId(long secondEmployeeId) {
        this.secondEmployeeId = secondEmployeeId;
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    @Override
    public String toString() {
        if (firstEmployeeId == INVALID_EMPLOYEE_ID && secondEmployeeId == INVALID_EMPLOYEE_ID && period == MIN_PERIOD) {
            return String.format("There is no pair of employees, who have worked together on common projects. So the " +
                "the longest period of time is %d", MIN_PERIOD);
            // return String.format("NULL, NULL, %d", MIN_PERIOD);
        }

        return String.format("%d, %d, %d", firstEmployeeId, secondEmployeeId, period);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EmployeePairLargestWorkingPeriod that = (EmployeePairLargestWorkingPeriod) o;
        return firstEmployeeId == that.firstEmployeeId && secondEmployeeId == that.secondEmployeeId &&
            period == that.period;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstEmployeeId, secondEmployeeId, period);
    }
}
