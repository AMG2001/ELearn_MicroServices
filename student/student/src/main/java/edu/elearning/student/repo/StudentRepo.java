package edu.elearning.student.repo;

import edu.elearning.student.domain.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, String> {

}