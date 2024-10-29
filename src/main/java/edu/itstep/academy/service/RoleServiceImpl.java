package edu.itstep.academy.service;

import edu.itstep.academy.entity.Role;
import edu.itstep.academy.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void saveOrUpdate(Role role) {
        roleRepository.saveOrUpdate(role);
    }
}
