package edu.itstep.academy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GradeDTO {
    private Long studentId;
    private Long subjectId;
    private String date;
    private int score;
    private String comment;

}