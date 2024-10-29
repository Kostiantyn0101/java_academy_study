package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Grade;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
    @Transactional
    public void deleteById(Long id) {
        sessionFactory
                .getCurrentSession()
                .createQuery("DELETE FROM Grade g WHERE g.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public Grade getById(Long id) {
        return sessionFactory
                .getCurrentSession()
                .get(Grade.class, id);
    }

    @Override
    @Transactional
    public List<Grade> getByStudentId(Long id, int page, int pageSize) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("FROM Grade g WHERE g.student.id = :studentId", Grade.class)
                .setParameter("studentId", id)
                .setFirstResult(page * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

    @Override
    @Transactional
    public List<Grade> getByStudentIdAndSubjectId(Long studentId, Long subjectId, int page, int pageSize) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Grade g WHERE g.student.id = :studentId AND g.subject.id = :subjectId", Grade.class)
                .setParameter("studentId", studentId)
                .setParameter("subjectId", subjectId)
                .setFirstResult(page * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

    @Override
    @Transactional
    public List<Grade> getByStudentIdAndDate(Long studentId, LocalDate date, int page, int pageSize) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Grade g WHERE g.student.id = :studentId AND g.date = :date", Grade.class)
                .setParameter("studentId", studentId)
                .setParameter("date", date)
                .setFirstResult(page * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

    @Override
    @Transactional
    public List<Grade> getByStudentIdAndSubjectIdAndDate(Long studentId, Long subjectId, LocalDate date, int page, int pageSize) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Grade g WHERE g.student.id = :studentId AND g.subject.id = :subjectId AND g.date = :date", Grade.class)
                .setParameter("studentId", studentId)
                .setParameter("subjectId", subjectId)
                .setParameter("date", date)
                .setFirstResult(page * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

    @Override
    @Transactional
    public List<Grade> getByTeacherId(Long id, int page, int pageSize) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Grade g WHERE g.teacher.id = :teacherId", Grade.class)
                .setParameter("teacherId", id)
                .setFirstResult(page * pageSize)
                .setMaxResults(pageSize)
                .setFirstResult(page * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

    @Override
    @Transactional
    public List<Grade> getByTeacherIdAndSubjectId(Long teacherId, Long subjectId, int page, int pageSize) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Grade g WHERE g.teacher.id = :teacherId AND g.subject.id = :subjectId", Grade.class)
                .setParameter("teacherId", teacherId)
                .setParameter("subjectId", subjectId)
                .setFirstResult(page * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

    @Override
    @Transactional
    public List<Grade> getByTeacherIdAndDate(Long teacherId, LocalDate date, int page, int pageSize) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Grade g WHERE g.teacher.id = :teacherId AND g.date = :date", Grade.class)
                .setParameter("teacherId", teacherId)
                .setParameter("date", date)
                .setFirstResult(page * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

    @Override
    @Transactional
    public List<Grade> getByTeacherIdAndSubjectIdAndDate(Long teacherId, Long subjectId, LocalDate date, int page, int pageSize) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Grade g WHERE g.teacher.id = :teacherId AND g.subject.id = :subjectId AND g.date = :date", Grade.class)
                .setParameter("teacherId", teacherId)
                .setParameter("subjectId", subjectId)
                .setParameter("date", date)
                .setFirstResult(page * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

}
