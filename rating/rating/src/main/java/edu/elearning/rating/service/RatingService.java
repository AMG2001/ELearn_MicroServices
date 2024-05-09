package edu.elearning.rating.service;


import edu.elearning.rating.dto.RatingDTO;
import edu.elearning.rating.entity.Rating;

import java.util.List;
import java.util.Optional;

public interface RatingService {
    Rating createRating(RatingDTO rating);
    List<RatingDTO> getAllRatings();
    Optional<RatingDTO> getRatingById(Long id);
    RatingDTO updateRating(Long id, RatingDTO updatedRating);
    void deleteRating(Long id);
    List<RatingDTO> getRatingsByStudentId(String studentId);
    List<RatingDTO> getRatingsByCourseId(String courseId);
}