package edu.itstep.academy.dto;

import edu.itstep.academy.entity.Subject;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class SubjectOutDTO {
    private Long id;
    private String name;
    private List<GradeOutDTO> grades;

    public SubjectOutDTO(Subject subject) {
        this.id = subject.getId();
        this.name = subject.getName();
        this.grades = new ArrayList<>();
    }
}
