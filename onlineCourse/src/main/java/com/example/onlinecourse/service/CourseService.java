package com.example.onlinecourse.service;

import com.example.onlinecourse.dto.CourseDTOResponse;
import com.example.onlinecourse.dto.CourseInfoDTORequest;
import com.example.onlinecourse.dto.CourseInfoDTOResponse;

import java.util.List;

public interface CourseService {

    List<CourseDTOResponse> findAllActiveCourses(Boolean showAll);

    void toggleCourse(Long courseId);
}
