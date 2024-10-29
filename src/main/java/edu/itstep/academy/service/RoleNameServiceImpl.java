package edu.itstep.academy.service;

import edu.itstep.academy.entity.RoleName;
import edu.itstep.academy.repository.RoleNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleNameServiceImpl implements RoleNameService {
    @Autowired
    private RoleNameRepository roleNameRepository;

    @Override
    public void saveOrUpdate(RoleName roleName) {
        roleNameRepository.saveOrUpdate(roleName);
    }

    @Override
    public RoleName getRoleNameById(Long id) {
        return roleNameRepository.getRoleNameById(id);
    }
}
