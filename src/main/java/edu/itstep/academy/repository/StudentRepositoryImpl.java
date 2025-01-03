package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Student> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Student", Student.class)
                .getResultList();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    @Transactional
    public Student getById(Long id) {
        return sessionFactory
                .getCurrentSession()
                .get(Student.class, id);
    }

    @Override
    @Transactional
    public Student getByUsernameId(Long userId) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Student t where t.user.id = :userId", Student.class)
                .setParameter("userId", userId)
                .uniqueResult();
    }

    @Override
    @Transactional
    public void saveOrUpdate(Student student) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(student);
    }
}
