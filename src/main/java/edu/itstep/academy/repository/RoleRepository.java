package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Role;

import java.util.List;

public interface RoleRepository {
    void saveOrUpdate(Role role);
    List<Role> getByUserId(Long id);

}
