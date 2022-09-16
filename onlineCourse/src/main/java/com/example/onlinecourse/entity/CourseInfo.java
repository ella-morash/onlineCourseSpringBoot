package com.example.onlinecourse.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "course_info")
@Entity
public class CourseInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDate startsOn;
    private LocalDate endsOn;
    private String lecturer;
    @OneToOne(mappedBy = "courseInfo")
    private Course course;


}
