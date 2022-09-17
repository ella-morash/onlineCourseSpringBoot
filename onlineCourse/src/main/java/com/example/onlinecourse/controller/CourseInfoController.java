package com.example.onlinecourse.controller;

import com.example.onlinecourse.dto.CourseInfoDTORequest;
import com.example.onlinecourse.dto.CourseInfoDTOResponse;
import com.example.onlinecourse.dto.CourseInfoUpdateDTORequest;
import com.example.onlinecourse.service.CourseInfoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CourseInfoController {

    private final CourseInfoService courseInfoService;


    @PostMapping(path = "/api/courses")
    public CourseInfoDTOResponse createCourse(@RequestBody CourseInfoDTORequest request) {

        return courseInfoService.createCourse(request);
    }

    @GetMapping(path = "/api/courses/{id}")
    public CourseInfoDTOResponse getCourseInfoById (@PathVariable(name = "id") Long courseID) {

        return courseInfoService.getCourseInfoById(courseID);
    }

    @PutMapping(path = "/api/courses/{id}")
    public void updateCourse(@PathVariable(name = "id") Long courseId, @RequestBody CourseInfoUpdateDTORequest request) {

         courseInfoService.updateCourseInfo(courseId,request);
    }
}
