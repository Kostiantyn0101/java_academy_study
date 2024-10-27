package edu.itstep.academy.dto;

import edu.itstep.academy.entity.Grade;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;


@Data
@NoArgsConstructor
public class GradeDTO {
    private Long id;
    private Long studentId;
    private Long subjectId;
    private Long teacherId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private int grade;
    private String comment;

    public GradeDTO(Grade grade)
    {
        this.id = grade.getId();
        this.studentId = grade.getStudent().getId();
        this.subjectId = grade.getSubject().getId();
        this.teacherId = grade.getTeacher().getId();
        this.date = grade.getDate();
        this.grade = grade.getGrade();
        this.comment = grade.getComment();
    }
}