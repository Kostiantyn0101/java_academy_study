package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Grade;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class GradeRepositoryImpl implements GradeRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Grade> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Grade", Grade.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void saveOrUpdate(Grade grade) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(grade);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    @Transactional
    public Grade getById(Long id) {
        return sessionFactory
                .getCurrentSession()
                .get(Grade.class, id);
    }
}
