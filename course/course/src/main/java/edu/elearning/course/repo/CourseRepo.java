package edu.elearning.course.repo;

import edu.elearning.course.domain.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepo extends MongoRepository<Course, String> {

}
