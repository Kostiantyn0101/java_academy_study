package edu.itstep.academy.dto;

import edu.itstep.academy.entity.Student;
import edu.itstep.academy.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentOutDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private User user;

    public StudentOutDTO(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.user = student.getUser();
    }
}
