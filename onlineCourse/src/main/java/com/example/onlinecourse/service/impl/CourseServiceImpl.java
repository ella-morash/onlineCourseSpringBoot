package com.example.onlinecourse.service.impl;

import com.example.onlinecourse.repository.CourseRepository;
import com.example.onlinecourse.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
}
