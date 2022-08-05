package com.sirma.interview.eplwt;

import com.sirma.interview.eplwt.model.EmployeePairLargestWorkingPeriod;
import com.sirma.interview.eplwt.services.LargestWorkingPeriodService;
import com.sirma.interview.eplwt.services.LargestWorkingPeriodServiceImpl;
import com.sirma.interview.eplwt.storage.EmployeesRecordsData;
import com.sirma.interview.eplwt.storage.EmployeesRecordsDataImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = ChooseFileUI.chooseFile();

        EmployeesRecordsData dataset = new EmployeesRecordsDataImpl(filePath);

        LargestWorkingPeriodService service = new LargestWorkingPeriodServiceImpl(dataset);

        List<EmployeePairLargestWorkingPeriod> pairs = service.findPairsWithLargestWorkingPeriod();

        if (pairs.isEmpty()) {
            System.out.println("There are no pairs of employees, who have worked together on common projects. So the " +
                "the longest period of time is 0");
        } else {
            for (EmployeePairLargestWorkingPeriod pair : pairs) {
                System.out.println(pair.toString());
            }
        }

    }
}
