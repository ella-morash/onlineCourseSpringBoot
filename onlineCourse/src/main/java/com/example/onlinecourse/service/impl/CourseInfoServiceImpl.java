package com.example.onlinecourse.service.impl;

import com.example.onlinecourse.repository.CourseInfoRepository;
import com.example.onlinecourse.service.CourseInfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CourseInfoServiceImpl implements CourseInfoService {

    private final CourseInfoRepository courseInfoRepository;
}
