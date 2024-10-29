package edu.itstep.academy.repository;

import edu.itstep.academy.entity.RoleName;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoleNameRepositoryImpl implements RoleNameRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public RoleName getRoleNameById(Long id) {
        return sessionFactory
                .getCurrentSession()
                .get(RoleName.class, id);
    }
    @Override
    @Transactional
    public void saveOrUpdate(RoleName roleName) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(roleName);
    }

}
