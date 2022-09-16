package com.example.onlinecourse.controller;

import com.example.onlinecourse.service.CourseInfoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CourseInfoController {

    private final CourseInfoService courseInfoService;
}
