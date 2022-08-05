package com.sirma.interview.eplwt.services;

import com.sirma.interview.eplwt.model.EmployeePairLargestWorkingPeriod;
import com.sirma.interview.eplwt.model.EmployeeRecord;
import com.sirma.interview.eplwt.storage.EmployeesRecordsData;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class LongerWorkingPeriodServiceImpl implements LargestWorkingPeriodService {
    private final EmployeesRecordsData repository;

    public LongerWorkingPeriodServiceImpl(EmployeesRecordsData repository) {
        this.repository = repository;
    }

    public EmployeePairLargestWorkingPeriod findPeriod() {
        EmployeePairLargestWorkingPeriod pair = new EmployeePairLargestWorkingPeriod();

        for (Long projectId : repository.getAllProjectsIds()) {
            List<EmployeeRecord> records = repository.getEmployeesRecordsByProjectId(projectId);

            for (int first = 0; first < records.size(); ++first) {
                for (int second = first + 1; second < records.size(); ++second) {
                    long period = calculateWorkPeriod(records.get(first), records.get(second));

                    if (period > pair.getPeriod()) {
                        pair.setPeriod(period);
                        pair.setFirstEmployeeId(records.get(first).employeeId());
                        pair.setSecondEmployeeId(records.get(second).employeeId());
                    }
                }
            }
        }
        return pair;
    }

    private long calculateWorkPeriod(EmployeeRecord firstRecord, EmployeeRecord secondRecord) {
        if (firstRecord.projectId() != secondRecord.projectId()) {
            return 0;
        }

        LocalDate periodFrom = getLaterDate(firstRecord.dateFrom(), secondRecord.dateFrom());
        LocalDate periodTo = getEarlierDate(firstRecord.dateTo(), secondRecord.dateTo());

        //  The start date is inclusive and end date is exclusive in between(), so adding 1 makes inclusive period.
        long period = DAYS.between(periodFrom, periodTo) + 1;
        System.out.println(period);

        return (period > 0) ? period : 0;
    }

    private LocalDate getEarlierDate(LocalDate first, LocalDate second) {
        return first.isBefore(second) ? first : second;
    }

    private LocalDate getLaterDate(LocalDate first, LocalDate second) {
        return first.isAfter(second) ? first : second;
    }

}