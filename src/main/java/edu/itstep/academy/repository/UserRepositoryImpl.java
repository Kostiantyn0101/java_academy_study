package edu.itstep.academy.repository;

import edu.itstep.academy.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<User> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    @Transactional
    public User getUserByUsername(String username) {
        return (User) sessionFactory
                .getCurrentSession()
                .createQuery("from User u where u.username = :username")
                .setParameter("username", username)
                .uniqueResult();
    }

    @Override
    @Transactional
    public void saveOrUpdate(User user) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(user);
    }
}
