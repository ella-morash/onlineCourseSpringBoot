package com.example.onlinecourse.controller;


import com.example.onlinecourse.dto.CourseDTOResponse;
import com.example.onlinecourse.dto.CourseInfoDTORequest;
import com.example.onlinecourse.dto.CourseInfoDTOResponse;
import com.example.onlinecourse.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping(path = "/api/courses")
    public List<CourseDTOResponse> getAllActiveCourses(@RequestParam(name = "showAll",required = false) Boolean showAll) {

        return courseService.findAllActiveCourses(showAll);
    }

    @PutMapping(path = "/api/courses/{id}/toggle-active")
    public void toggleCourse(@PathVariable(name = "id") Long courseId) {

        courseService.toggleCourse(courseId);
    }


}
