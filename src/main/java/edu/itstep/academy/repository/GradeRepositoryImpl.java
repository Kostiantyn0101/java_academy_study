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
                .getResultList();    }

    @Override
    public void saveOrUpdate(Grade grade) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Grade getById(int id) {
        return null;
    }
}
