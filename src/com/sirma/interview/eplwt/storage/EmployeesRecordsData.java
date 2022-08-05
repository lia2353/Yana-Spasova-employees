package com.sirma.interview.eplwt.storage;

import com.sirma.interview.eplwt.model.EmployeeRecord;

import java.util.List;
import java.util.Set;

public interface EmployeesRecordsData {
    Set<Long> getAllProjectsIds();

    List<EmployeeRecord> getEmployeesRecordsByProjectId(long projectId);
}
