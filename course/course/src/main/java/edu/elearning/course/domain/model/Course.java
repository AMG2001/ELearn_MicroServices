package edu.elearning.course.domain.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("courses")
@Data
public class Course {
    @Id
    private String course_id;
    private String course_name;
    ArrayList<String> studentsIds = new ArrayList<>();
}
