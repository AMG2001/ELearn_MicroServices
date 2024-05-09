package edu.elearning.rating.dto;

import edu.elearning.rating.dto.RatingDTO;
import edu.elearning.rating.entity.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RatingMapper {

    @Mapping(source = "studentId", target = "studentId")
    @Mapping(source = "courseId", target = "courseId")
    Rating toRating(RatingDTO ratingDTO);

    @Mapping(source = "studentId", target = "studentId")
    @Mapping(source = "courseId", target = "courseId")
    RatingDTO toRatingDTO(Rating rating);
}
