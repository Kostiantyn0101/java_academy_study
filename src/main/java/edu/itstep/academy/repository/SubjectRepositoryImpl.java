package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Student;
import edu.itstep.academy.entity.Subject;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SubjectRepositoryImpl implements SubjectRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Subject> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Subject ", Subject.class)
                .getResultList();
    }

    @Override
    public void saveOrUpdate(Subject grade) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    @Transactional
    public Subject getById(Long id) {
        return sessionFactory
                .getCurrentSession()
                .get(Subject.class, id);
    }
}
