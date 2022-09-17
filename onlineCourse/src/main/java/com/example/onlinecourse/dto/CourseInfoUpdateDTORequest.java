package com.example.onlinecourse.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseInfoUpdateDTORequest {
    private String name;
    private String description;
    private String lecturer;
}
