package edu.itstep.academy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRegistrationInDTO {
    private String userName;
    private String password;
    private Long roleId;
    private String firstName;
    private String lastName;
}
