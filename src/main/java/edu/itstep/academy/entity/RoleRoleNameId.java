package edu.itstep.academy.entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class RoleRoleNameId implements Serializable {
    private Long userId;
    private Long roleId;

}
