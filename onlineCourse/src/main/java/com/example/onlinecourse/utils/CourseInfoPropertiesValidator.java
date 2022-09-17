package com.example.onlinecourse.utils;


import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class CourseInfoPropertiesValidator {

    public boolean isActive(String start, String end) {

        var date1 = LocalDate.parse(start);
        var date2 = LocalDate.parse(end);


        return Period.between(date1,date2).getDays() > 0;
    }
}
