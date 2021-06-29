package net.mofed.reportracking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.mofed.reportracking.app.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
