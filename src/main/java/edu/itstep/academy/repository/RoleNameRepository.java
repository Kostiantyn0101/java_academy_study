package edu.itstep.academy.repository;

import edu.itstep.academy.entity.RoleName;

public interface RoleNameRepository {
    void saveOrUpdate(RoleName roleName);
    RoleName getRoleNameById(Long id);

}
