package edu.itstep.academy.dto;

import edu.itstep.academy.entity.Grade;
import edu.itstep.academy.entity.Student;
import edu.itstep.academy.entity.Subject;
import edu.itstep.academy.entity.Teacher;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;


@Data
@NoArgsConstructor
public class GradeOutDTO {
    private Long id;
    private Long studentId;
    private Long subjectId;
    private Long teacherId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private int grade;
    private String comment;
    private Teacher teacher;
    private Student student;
    private Subject subject;


    public GradeOutDTO(Grade grade)
    {
        this.id = grade.getId();
        this.studentId = grade.getStudent().getId();
        this.subjectId = grade.getSubject().getId();
        this.teacherId = grade.getTeacher().getId();
        this.date = grade.getDate();
        this.grade = grade.getGrade();
        this.comment = grade.getComment();
        this.teacher = grade.getTeacher();
        this.student = grade.getStudent();
        this.subject = grade.getSubject();
    }
}