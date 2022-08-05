package com.sirma.interview.eplwt.services;

import com.sirma.interview.eplwt.model.EmployeePairWorkingPeriod;

public interface LongerWorkingPeriodService {
    /**
     * Returns a ReEmployeePairWorkingPeriod instance with the pair of employees who have worked together on common
     * projects for the longest period of time from the records dataset.
     *
     * @return ReEmployeePairWorkingPeriod instance
     **/
    EmployeePairWorkingPeriod findPeriod();
}
