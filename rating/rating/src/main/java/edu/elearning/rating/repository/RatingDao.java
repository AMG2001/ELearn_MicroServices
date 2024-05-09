package edu.elearning.rating.repository;

import edu.elearning.rating.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface RatingDao extends JpaRepository<Rating,Long> {

    List<Rating> findByStudentId(String studentId);

}
