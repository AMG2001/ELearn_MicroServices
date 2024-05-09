package edu.elearning.course.controller;


import edu.elearning.course.domain.model.Course;
import edu.elearning.course.domain.model.StudentModel;
import edu.elearning.course.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/elearning/api/course")
public class CourseController {

    @Autowired
    private CourseRepo repo;
    @Autowired
    private RestTemplate getRestTemplate;


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable String id) {
        repo.deleteById(id);
        return ResponseEntity.ok("Course Deleted Successfully!");
    }


}
