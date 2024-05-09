package edu.elearning.student.services;

import edu.elearning.student.domain.model.Student;
import edu.elearning.student.repo.StudentRepo;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/elearn/api/student")
public class StudentService {

    @Autowired
    private StudentRepo repository;

    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        repository.save(student);
        return ResponseEntity.ok("Student added successfully");
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {
        Optional<Student> student = repository.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new RuntimeException("Student not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Delete Successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable String id, @RequestBody Student student) {

        // Find the existing student by ID
        Optional<Student> optionalStudent = repository.findById(id);

        // Check if the student exists
        if (optionalStudent.isPresent()) {
            // Update the student with the new details
            Student updatedStudent = optionalStudent.get();
            updatedStudent.setStudent_name(student.getStudent_name());
            updatedStudent.setStudent_email(student.getStudent_email());
            // Save the updated student
            repository.save(updatedStudent);
            // Return a success response
            return ResponseEntity.ok("Update Successfully");
        } else {
            // Handle the case where the student does not exist
            return ResponseEntity.notFound().build();
        }
    }

}
