package com.example.onlinecourse.utils;

import com.example.onlinecourse.dto.CourseDTOResponse;
import com.example.onlinecourse.dto.CourseInfoDTORequest;
import com.example.onlinecourse.dto.CourseInfoDTOResponse;
import com.example.onlinecourse.entity.Course;
import com.example.onlinecourse.entity.CourseInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MyConverter {
    private final CourseInfoPropertiesValidator validator;


    public  Course convertFromDTOCourse(CourseInfoDTORequest request, CourseInfo courseInfo) {

        return Course.builder()
                .name(request.getName())
                .isActive(validator.isActive(request.getStartsOn(),request.getEndsOn()))
                .courseInfo(courseInfo)
                .build();
    }

    public static CourseInfo convertFromDTOToCourseInfo(CourseInfoDTORequest request) {

        return CourseInfo.builder()
                .description(request.getDescription())

                .endsOn(request.getEndsOn())
                .startsOn(request.getStartsOn())
                .lecturer(request.getLecturer())
                .build();
    }

    public static CourseInfoDTOResponse convertToDTO(Course course,CourseInfo courseInfo) {

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

    public static CourseDTOResponse convertToCourseDto(Course course) {

        return CourseDTOResponse.builder()
                .id(course.getId())
                .name(course.getName())
                .build();
    }


}
