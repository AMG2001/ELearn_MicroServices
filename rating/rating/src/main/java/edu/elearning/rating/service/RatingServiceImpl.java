package edu.elearning.rating.service;

import edu.elearning.rating.dto.RatingDTO;
import edu.elearning.rating.dto.RatingMapper;
import edu.elearning.rating.repository.RatingDao;
import edu.elearning.rating.entity.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingDao ratingDao;

    @Autowired
    private RatingMapper ratingMapper;

    @Override
    public Rating createRating(RatingDTO ratingDto) {
        Rating rating = ratingMapper.toRating(ratingDto);
        rating.setRatingDate(LocalDateTime.now());
        return ratingDao.save(rating);
    }

    @Override
    public List<RatingDTO> getAllRatings() {

        return  ratingDao.findAll().stream().map(ratingMapper::toRatingDTO).toList();

    }

    @Override
    public Optional<RatingDTO> getRatingById(Long id) {
        Rating rating = ratingDao.findById(id).get();
        return Optional.of(ratingMapper.toRatingDTO(rating));
    }

    @Override
    public RatingDTO updateRating(Long id, RatingDTO updatedRating) {

        Optional<Rating> existingRatingOptional = ratingDao.findById(id);

        if (existingRatingOptional.isPresent()) {
            Rating existingRating = existingRatingOptional.get();
            existingRating.setRatingValue(updatedRating.getRatingValue());
            return ratingMapper.toRatingDTO(ratingDao.save(existingRating));
        } else {
            throw new RuntimeException("Rating not found with id: " + id);
        }
    }

    @Override
    public void deleteRating(Long id) {
        ratingDao.deleteById(id);
    }

    @Override
    public List<RatingDTO> getRatingsByStudentId(String studentId) {
        return ratingDao.findByStudentId(studentId).stream().map(ratingMapper::toRatingDTO).toList();
    }
}
