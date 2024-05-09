package edu.elearning.rating.dto;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class RatingDTO {
    private long id;
    private String studentId;
    private String courseId;
    private long ratingValue;
    private LocalDateTime ratingDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public long getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(long ratingValue) {
        this.ratingValue = ratingValue;
    }

    public LocalDateTime getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(LocalDateTime ratingDate) {
        this.ratingDate = ratingDate;
    }
}