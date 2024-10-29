package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void saveOrUpdate(Role role) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(role);
    }
}
