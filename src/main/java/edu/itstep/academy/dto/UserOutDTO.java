package edu.itstep.academy.dto;

import edu.itstep.academy.entity.RoleName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserOutDTO {
    private Long userId;
    private String userName;
    private String firstName;
    private String lastName;
    private List<RoleName> roles;
}
