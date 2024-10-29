package edu.itstep.academy.service;

import edu.itstep.academy.entity.RoleName;

public interface RoleNameService {
    void saveOrUpdate(RoleName roleName);
    RoleName getRoleNameById(Long id);
}
