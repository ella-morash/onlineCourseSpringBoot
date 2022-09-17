package com.example.onlinecourse.service;

import com.example.onlinecourse.dto.CourseInfoDTORequest;
import com.example.onlinecourse.dto.CourseInfoDTOResponse;
import com.example.onlinecourse.dto.CourseInfoUpdateDTORequest;

public interface CourseInfoService {
    CourseInfoDTOResponse createCourse(CourseInfoDTORequest request);

    CourseInfoDTOResponse getCourseInfoById(Long courseID);

    void updateCourseInfo(Long courseId, CourseInfoUpdateDTORequest request);
}
