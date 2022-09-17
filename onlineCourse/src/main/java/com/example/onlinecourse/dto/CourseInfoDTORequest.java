package com.example.onlinecourse.dto;


import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseInfoDTORequest {

    private String name;
    private String description;
    private String lecturer;
    private String startsOn;
    private String endsOn;
}
