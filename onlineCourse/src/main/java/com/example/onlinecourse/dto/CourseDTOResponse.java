package com.example.onlinecourse.dto;


import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseDTOResponse {

    private Long id;
    private String name;
    private String description;
    private String lecturer;
    private LocalDate startsOn;
    private LocalDate endsOn;
    private Boolean isActive;
}
