package com.example.onlinecourse.repository;

import com.example.onlinecourse.entity.CourseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseInfoRepository extends JpaRepository<CourseInfo,Long> {
}
