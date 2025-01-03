package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Teacher;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Teacher getById(Long id) {
        return sessionFactory
                .getCurrentSession()
                .get(Teacher.class, id);
    }

    @Override
    @Transactional
    public Teacher getByUsernameId(Long userId) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Teacher t where t.user.id = :userId", Teacher.class)
                .setParameter("userId", userId)
                .uniqueResult();
    }

    @Override
    @Transactional
    public void saveOrUpdate(Teacher teacher) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(teacher);
    }
}
