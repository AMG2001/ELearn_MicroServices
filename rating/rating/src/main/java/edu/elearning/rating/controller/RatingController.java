package edu.elearning.rating.controller;

import edu.elearning.rating.dto.RatingDTO;
import edu.elearning.rating.dto.RatingMapper;
import edu.elearning.rating.entity.Rating;
import edu.elearning.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public Rating createRating(@RequestBody RatingDTO rating) {
        return ratingService.createRating(rating);
    }

    @GetMapping
    public List<RatingDTO> getAllRatings() {
        return ratingService.getAllRatings();
    }

    @GetMapping("/{id}")
    public Optional<RatingDTO> getRatingById(@PathVariable Long id) {
        return ratingService.getRatingById(id);
    }

    @GetMapping("/student/{studentId}")
    public List<RatingDTO> getRatingsByStudentId(@PathVariable String studentId) {
        return ratingService.getRatingsByStudentId(studentId);
    }

    @PutMapping("/{id}")
    public RatingDTO updateRating(@PathVariable Long id, @RequestBody RatingDTO updatedRating) {
        return ratingService.updateRating(id, updatedRating);
    }

    @DeleteMapping("/{id}")
    public void deleteRating(@PathVariable Long id) {
        ratingService.deleteRating(id);
    }
}
