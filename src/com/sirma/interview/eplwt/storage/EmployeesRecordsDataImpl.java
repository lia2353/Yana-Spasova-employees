package com.sirma.interview.eplwt.storage;

import com.sirma.interview.eplwt.model.EmployeeRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeesRecordsDataImpl implements EmployeesRecordsData {

    private static final String DATASET_PATH = "./resources/employees.csv";
    private final Map<Long, List<EmployeeRecord>> employeesRecordsByProject;

    public EmployeesRecordsDataImpl() {
        try (var reader = new BufferedReader(new FileReader(DATASET_PATH))) {
            employeesRecordsByProject = reader.lines()
                .map(EmployeeRecord::of)
                .collect(Collectors.groupingBy(EmployeeRecord::projectId));
        } catch (IOException e) {
            throw new IllegalStateException("A problem occurred while reading from the file", e);
        }
    }

    public Set<Long> getAllProjectsIds() {
        return employeesRecordsByProject.keySet();
    }

    public List<EmployeeRecord> getEmployeesRecordsByProjectId(long projectId) {
        return employeesRecordsByProject.get(projectId);
    }

}
