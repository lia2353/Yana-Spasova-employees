package com.sirma.interview.eplwt.model;

import java.time.LocalDate;

public record EmployeeRecord(long employeeId, long projectId, LocalDate dateFrom, LocalDate dateTo) {

    private static final String FILE_DELIMITER = ", ";
    private static final String NULL_DATE = "NULL";
    private static final int EMPLOYEE_ID = 0;
    private static final int PROJECT_ID = 1;
    private static final int DATE_FROM = 2;
    private static final int DATE_TO = 3;

    /**
     * Returns a Record instance, based on the given @{line} from the dataset.
     *
     * @param line line from the dataset file
     * @return Record instance
     **/
    public static EmployeeRecord of(String line) {
        String[] tokens = line.split(FILE_DELIMITER);

        long employeeId = Long.parseLong(tokens[EMPLOYEE_ID]);
        long projectId = Long.parseLong(tokens[PROJECT_ID]);
        LocalDate dateFrom = LocalDate.parse(tokens[DATE_FROM]);
        LocalDate dateTo = tokens[DATE_TO].equalsIgnoreCase(NULL_DATE)
            ? LocalDate.now()
            : LocalDate.parse(tokens[DATE_TO]);

        return new EmployeeRecord(employeeId, projectId, dateFrom, dateTo);
    }
}

