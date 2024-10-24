package edu.itstep.academy.repository;

import edu.itstep.academy.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public User getUserByUsername(String username) {
        return (User) sessionFactory
                .getCurrentSession()
                .createQuery("from User u where u.username = :username")
                .setParameter("username", username)
                .uniqueResult();
    }
}
