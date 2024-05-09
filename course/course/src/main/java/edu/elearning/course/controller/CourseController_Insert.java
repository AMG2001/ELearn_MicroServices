package edu.elearning.course.controller;


import edu.elearning.course.domain.model.Course;
import edu.elearning.course.domain.model.StudentModel;
import edu.elearning.course.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;

@RestController
@RequestMapping("/elearning/api/course")
public class CourseController_Insert {
    @Autowired
    private CourseRepo repo;
    @Autowired
    private RestTemplate getRestTemplate;

    @PostMapping("/add")
    public ResponseEntity<String> addCourse(@RequestParam String courseName) {
        Course course = new Course();
        course.setCourse_name(courseName);
        repo.save(course);
        return ResponseEntity.ok("Course Added Successfully!");
    }

    @PostMapping("/add/student")
    public ResponseEntity<String> addStudentToCourse(@RequestParam String courseId, @RequestParam String studentId) {
        Optional<Course> course = repo.findById(courseId);
        if (course.isPresent()) {
            course.get().getStudentsIds().add(studentId);
            repo.save(course.get());
            return ResponseEntity.ok("Student Added Successfully!");
        } else {
            return ResponseEntity.ok("Course Not Found!");
        }
    }
}
