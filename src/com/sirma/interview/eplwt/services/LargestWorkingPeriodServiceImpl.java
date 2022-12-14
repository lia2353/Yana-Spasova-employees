package com.sirma.interview.eplwt.services;

import com.sirma.interview.eplwt.model.EmployeePairLargestWorkingPeriod;
import com.sirma.interview.eplwt.model.EmployeeRecord;
import com.sirma.interview.eplwt.storage.EmployeesRecordsData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class LargestWorkingPeriodServiceImpl implements LargestWorkingPeriodService {
    private static final long MIN_PERIOD = 0;
    private final EmployeesRecordsData recordsData;

    public LargestWorkingPeriodServiceImpl(EmployeesRecordsData recordsData) {
        this.recordsData = recordsData;
    }

    public List<EmployeePairLargestWorkingPeriod> findPairsWithLargestWorkingPeriod() {
        List<EmployeePairLargestWorkingPeriod> pairs = new ArrayList<>();
        long largestPeriod = MIN_PERIOD;

        for (Long projectId : recordsData.getAllProjectsIds()) {
            List<EmployeeRecord> records = recordsData.getEmployeesRecordsByProjectId(projectId);

            for (int firstIndex = 0; firstIndex < records.size(); ++firstIndex) {
                for (int secondIndex = firstIndex + 1; secondIndex < records.size(); ++secondIndex) {
                    long period = calculateWorkPeriod(records.get(firstIndex), records.get(secondIndex));

                    if (period > MIN_PERIOD && period == largestPeriod) {
                        pairs.add(new EmployeePairLargestWorkingPeriod(records.get(firstIndex).employeeId(),
                            records.get(secondIndex).employeeId(), period));
                    } else if (period > largestPeriod) {
                        pairs.clear();
                        largestPeriod = period;
                        pairs.add(new EmployeePairLargestWorkingPeriod(records.get(firstIndex).employeeId(),
                            records.get(secondIndex).employeeId(), period));
                    }
                }
            }

        }

        return pairs;
    }

    private long calculateWorkPeriod(EmployeeRecord firstRecord, EmployeeRecord secondRecord) {
        if (firstRecord.projectId() != secondRecord.projectId()) {
            return 0;
        }

        LocalDate periodFrom = getLaterDate(firstRecord.dateFrom(), secondRecord.dateFrom());
        LocalDate periodTo = getEarlierDate(firstRecord.dateTo(), secondRecord.dateTo());

        // In the method between() start date is inclusive and end date is exclusive, so adding 1 makes the period inclusive.
        long period = DAYS.between(periodFrom, periodTo) + 1;

        return (period > 0) ? period : 0;
    }

    private LocalDate getEarlierDate(LocalDate first, LocalDate second) {
        return first.isBefore(second) ? first : second;
    }

    private LocalDate getLaterDate(LocalDate first, LocalDate second) {
        return first.isAfter(second) ? first : second;
    }

}