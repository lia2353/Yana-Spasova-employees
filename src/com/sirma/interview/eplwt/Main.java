package com.sirma.interview.eplwt;

import com.sirma.interview.eplwt.model.EmployeePairLargestWorkingPeriod;
import com.sirma.interview.eplwt.services.LargestWorkingPeriodService;
import com.sirma.interview.eplwt.services.LargestWorkingPeriodServiceImpl;
import com.sirma.interview.eplwt.storage.EmployeesRecordsData;
import com.sirma.interview.eplwt.storage.EmployeesRecordsDataImpl;

public class Main {

    public static void main(String[] args) {
        EmployeesRecordsData dataset = new EmployeesRecordsDataImpl();

        LargestWorkingPeriodService service = new LargestWorkingPeriodServiceImpl(dataset);

        EmployeePairLargestWorkingPeriod pair = service.findPeriod();
        System.out.println(pair.toString());
    }
}
