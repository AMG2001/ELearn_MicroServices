package edu.elearning.student.domain.model;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
@Data
@Builder
public class Student {
    @Id
    private String student_id;
    private String student_name;
    private String student_email;
}
