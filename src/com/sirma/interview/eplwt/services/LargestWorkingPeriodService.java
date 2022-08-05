package com.sirma.interview.eplwt.services;

import com.sirma.interview.eplwt.model.EmployeePairLargestWorkingPeriod;

import java.util.List;

public interface LargestWorkingPeriodService {
    /**
     * Returns a list of ReEmployeePairWorkingPeriod instances with pairs of employees who have worked together on common
     * projects for the largest period of time from the records dataset.
     *
     * @return List of EmployeePairWorkingPeriod instances
     **/
    List<EmployeePairLargestWorkingPeriod> findPairsWithLargestWorkingPeriod();
}
