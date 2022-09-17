package com.example.onlinecourse.repository;

import com.example.onlinecourse.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    List<Course> findAllByIsActive(Boolean isActive);
}
