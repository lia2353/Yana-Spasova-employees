package com.sirma.interview.eplwt.model;

import java.util.Objects;

public class EmployeePairWorkingPeriod {

    private static final long INVALID_EMPLOYEE_ID = -1;
    private static final long MIN_PERIOD = 0;
    private long firstEmployeeId;
    private long secondEmployeeId;
    private long period;

    /**
     * Stores a pair of employees who worked together longer on the same project.
     *
     **/
    public EmployeePairWorkingPeriod() {
        this.firstEmployeeId = INVALID_EMPLOYEE_ID;
        this.secondEmployeeId = INVALID_EMPLOYEE_ID;
        this.period = MIN_PERIOD;
    }

    public EmployeePairWorkingPeriod(int firstEmployeeId, int secondEmployeeId, long period) {
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
            return String.format("There is no pair of employees, who have worked together. %d", firstEmployeeId, secondEmployeeId, period);
        }
        return String.format("%d, %d, %d", firstEmployeeId, secondEmployeeId, period);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass())  {
            return false;
        }
        EmployeePairWorkingPeriod that = (EmployeePairWorkingPeriod) o;
        return firstEmployeeId == that.firstEmployeeId && secondEmployeeId == that.secondEmployeeId &&
            period == that.period;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstEmployeeId, secondEmployeeId, period);
    }
}
