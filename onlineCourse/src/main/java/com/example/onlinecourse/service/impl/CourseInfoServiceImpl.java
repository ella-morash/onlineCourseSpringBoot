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
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@AllArgsConstructor
public class CourseInfoServiceImpl implements CourseInfoService {

    private final CourseInfoRepository courseInfoRepository;
    private final CourseRepository courseRepository;
    private final CourseInfoPropertiesValidator validator;

    @Override
    public CourseInfoDTOResponse createCourse(CourseInfoDTORequest request) {
        Course course = Course.builder()
                .name(request.getName())
                .isActive(validator.isActive(request.getStartsOn(),request.getEndsOn()))
                .build();


        CourseInfo courseInfo = CourseInfo.builder()
                .description(request.getDescription())

                .endsOn(request.getEndsOn())
                .startsOn(request.getStartsOn())
                .lecturer(request.getLecturer())
                .build();

        courseInfoRepository.save(courseInfo);
        course.setCourseInfo(courseInfo);
        courseRepository.save(course);




        return CourseInfoDTOResponse.builder()
                .id(course.getId())
                .name(course.getName())
                .description(courseInfo.getDescription())
                .isActive(course.getIsActive())
                .lecturer(courseInfo.getLecturer())
                .startsOn(courseInfo.getStartsOn())
                .endsOn(courseInfo.getEndsOn())
                .build();
    }

    @Override
    public CourseInfoDTOResponse getCourseInfoById(Long courseID) {

        var course = courseRepository.findById(courseID)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));

        return CourseInfoDTOResponse.builder()
                .id(courseID)
                .name(course.getName())
                .isActive(course.getIsActive())
                .description(course.getCourseInfo().getDescription())
                .endsOn(course.getCourseInfo().getEndsOn())
                .startsOn(course.getCourseInfo().getStartsOn())
                .lecturer(course.getCourseInfo().getLecturer())
                .build();
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
