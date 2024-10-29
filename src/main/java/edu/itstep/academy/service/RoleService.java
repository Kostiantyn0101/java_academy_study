package edu.itstep.academy.service;

import edu.itstep.academy.entity.Role;

import java.util.List;

public interface RoleService {
    void saveOrUpdate(Role role);
    List<Role> getByUserId(Long id);
}
