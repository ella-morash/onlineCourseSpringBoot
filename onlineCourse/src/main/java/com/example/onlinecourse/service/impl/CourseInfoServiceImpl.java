package com.example.onlinecourse.service.impl;

import com.example.onlinecourse.dto.CourseInfoDTORequest;
import com.example.onlinecourse.dto.CourseInfoDTOResponse;
import com.example.onlinecourse.dto.CourseInfoUpdateDTORequest;
import com.example.onlinecourse.entity.Course;
import com.example.onlinecourse.entity.CourseInfo;
import com.example.onlinecourse.repository.CourseInfoRepository;
import com.example.onlinecourse.repository.CourseRepository;
import com.example.onlinecourse.service.CourseInfoService;
import com.example.onlinecourse.utils.CourseInfoPropertiesValidator;
import com.example.onlinecourse.utils.MyConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@AllArgsConstructor
public class CourseInfoServiceImpl implements CourseInfoService {

    private final CourseInfoRepository courseInfoRepository;
    private final CourseRepository courseRepository;
    private final MyConverter converter;


    @Override
    public CourseInfoDTOResponse createCourse(CourseInfoDTORequest request) {

        CourseInfo courseInfo = MyConverter.convertFromDTOToCourseInfo(request);
        Course course = converter.convertFromDTOCourse(request,courseInfo);

        courseInfoRepository.save(courseInfo);
        course.setCourseInfo(courseInfo);
        courseRepository.save(course);


        return MyConverter.convertToDTO(course,courseInfo);
    }

    @Override
    public CourseInfoDTOResponse getCourseInfoById(Long courseID) {

        var course = courseRepository.findById(courseID)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        var courseInfo = course.getCourseInfo();

        return MyConverter.convertToDTO(course,courseInfo);
    }

    @Override
    public void updateCourseInfo(Long courseId, CourseInfoUpdateDTORequest request) {


        var course = courseRepository.findById(courseId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        var courseInfo = course.getCourseInfo();

        courseInfo.setDescription(request.getDescription());
        courseInfo.setLecturer(request.getLecturer());
        course.setName(request.getName());
        course.setCourseInfo(courseInfo);

        courseInfoRepository.save(courseInfo);

        courseRepository.save(course);

    }
}
