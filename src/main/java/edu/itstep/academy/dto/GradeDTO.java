package edu.itstep.academy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GradeDTO {
    private Long id;
    private Long studentId;
    private Long subjectId;
    private Long teacherId;
    private String date;
    private int grade;
    private String comment;
}