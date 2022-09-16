package com.example.onlinecourse.controller;


import com.example.onlinecourse.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;
}
