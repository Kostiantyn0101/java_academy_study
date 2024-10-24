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
                .getResultList();    }

    @Override
    public void saveOrUpdate(Student student) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Student getById(int id) {
        return null;
    }
}
