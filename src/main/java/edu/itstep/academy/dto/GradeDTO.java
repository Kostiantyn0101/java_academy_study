package edu.itstep.academy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

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
}