package edu.elearning.course.controller;


import edu.elearning.course.domain.model.Course;
import edu.elearning.course.domain.model.StudentModel;
import edu.elearning.course.repo.CourseRepo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/elearning/api/course")
public class CourseController_Get {
    @Autowired
    private CourseRepo repo;
    @Autowired
    private RestTemplate getRestTemplate;

    @GetMapping
    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable String id) {
        Optional<Course> course = repo.findById(id);
        if (course.isPresent()) {
            return ResponseEntity.ok(course.get());
        } else {
            return ResponseEntity.ok("Course Not Found!");
        }
    }

    /**
     * 1. get course data from cloud .
     * 2. loop of course students ids
     * 3. get all students information
     */
    @GetMapping("/{id}/students")
    public ResponseEntity<?> getStudentsByCourseId(@PathVariable String id) {
        List<StudentModel> studentsList = new ArrayList<>();
        Optional<Course> course = repo.findById(id);
        if (course.isPresent()) {
            if (course.get().getStudentsIds().size() == 0) {
                return ResponseEntity.ok("There is no students inside this course");
            } else {
                for (String studentId : course.get().getStudentsIds()) {
                    StudentModel studentModel = getRestTemplate.getForObject("http://localhost:8080/elearning/api/student/" + studentId, StudentModel.class);
                    studentsList.add(studentModel);
                }
            }
        } else {
            return ResponseEntity.ok("Course Not Found!");
        }
        return ResponseEntity.ok(studentsList);
    }


}
