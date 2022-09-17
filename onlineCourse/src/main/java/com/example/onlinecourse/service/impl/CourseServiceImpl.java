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
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    private final CourseInfoRepository courseInfoRepository;
    private final CourseInfoPropertiesValidator validator;


    @Override
    public List<CourseDTOResponse> findAllActiveCourses(Boolean showAll) {
        if (showAll == null) {
            return courseRepository.findAll().stream()

                    .map(course -> CourseDTOResponse.builder()
                            .id(course.getId())
                            .name(course.getName())
                            .build())
                    .toList();
        }

        var courses = showAll ? courseRepository.findAll() : courseRepository.findAllByIsActive(true);

        return courses.stream()
                             .map(course -> CourseDTOResponse.builder()
                                     .id(course.getId())
                                     .name(course.getName())
                                     .build())
                             .toList();


    }

    @Override
    public void toggleCourse(Long courseId) {

        var course = courseRepository.findById(courseId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));

        var courseInfo = course.getCourseInfo();

        course.setIsActive(!course.getIsActive());


        courseRepository.save(course);


    }
}
