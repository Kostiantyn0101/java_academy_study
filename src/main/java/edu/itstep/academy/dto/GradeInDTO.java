package edu.itstep.academy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
@NoArgsConstructor
public class GradeInDTO {
    private Long id;
    @NotNull(message = "Student is required")
    private Long studentId;
    @NotNull(message = "Subject is required")
    private Long subjectId;
    @NotNull(message = "Teacher is required")
    private Long teacherId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotNull(message = "Grade is required")
    private int grade;
    @NotNull(message = "Comment is required")
    @NotBlank(message = "Comment cannot be empty")
    private String comment;
}