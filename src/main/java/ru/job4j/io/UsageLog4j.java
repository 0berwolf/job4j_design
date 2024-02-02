package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Andrei Golub";
        int age = 33;
        byte jobAgeStart = 23;
        short lengthOfService = 10;
        long salary = 1328L;
        float workingDay = 11.5f;
        double yearlyWorkingHours = 2040.5;
        boolean work = true;
        char n = 'Y';
        LOG.debug("User info name : {}, age : {}, jobAgeStart : {}, lengthOfService : {}, salary : {}, workingDay : {}, "
                        + "yearlyWorkingHours : {}, work : {}, n : {}", name, age, jobAgeStart, lengthOfService, salary, workingDay,
                yearlyWorkingHours, work, n);
    }
}
