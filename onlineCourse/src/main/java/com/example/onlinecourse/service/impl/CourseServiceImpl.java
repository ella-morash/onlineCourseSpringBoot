package com.example.onlinecourse.service.impl;

import com.example.onlinecourse.dto.CourseDTOResponse;
import com.example.onlinecourse.dto.CourseInfoDTORequest;
import com.example.onlinecourse.dto.CourseInfoDTOResponse;
import com.example.onlinecourse.entity.Course;
import com.example.onlinecourse.entity.CourseInfo;
import com.example.onlinecourse.repository.CourseInfoRepository;
import com.example.onlinecourse.repository.CourseRepository;
import com.example.onlinecourse.service.CourseService;
import com.example.onlinecourse.utils.CourseInfoPropertiesValidator;
import com.example.onlinecourse.utils.MyConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;





    @Override
    public List<CourseDTOResponse> findAllActiveCourses(Boolean showAll) {

        if (showAll == null || showAll) {
            return courseRepository.findAll().stream()
                    .map(MyConverter::convertToCourseDto)
                    .toList();
        }

        return courseRepository.findAllByIsActive(true).stream()
                             .map(MyConverter::convertToCourseDto)
                             .toList();


    }

    @Override
    public void toggleCourse(Long courseId) {

        var course = courseRepository.findById(courseId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));

        course.setIsActive(!course.getIsActive());

        courseRepository.save(course);


    }
}
