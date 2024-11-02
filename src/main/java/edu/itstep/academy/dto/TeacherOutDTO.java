package edu.itstep.academy.dto;

import edu.itstep.academy.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeacherOutDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private User user;
}
