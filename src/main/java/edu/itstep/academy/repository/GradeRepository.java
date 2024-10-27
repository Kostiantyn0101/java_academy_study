package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Grade;

import java.time.LocalDate;
import java.util.List;

public interface GradeRepository {
    List<Grade> getAll();
    void saveOrUpdate(Grade grade);
    void deleteById(Long id);
    Grade getById(Long id);

    List<Grade> getByTeacherId(Long id, int page, int pageSize);
    List<Grade> getByTeacherIdAndSubjectId(Long teacherId, Long subjectId, int page, int pageSize);
    List<Grade> getByTeacherIdAndDate(Long teacherId, LocalDate date, int page, int pageSize);
    List<Grade> getByTeacherIdAndSubjectIdAndDate(Long teacherId, Long subjectId, LocalDate date, int page, int pageSize);
    List<Grade> getByStudentId(Long id, int page, int pageSize);
    List<Grade> getByStudentIdAndSubjectId(Long studentId, Long subjectId, int page, int pageSize);
    List<Grade> getByStudentIdAndDate(Long studentId, LocalDate date, int page, int pageSize);
    List<Grade> getByStudentIdAndSubjectIdAndDate(Long studentId, Long subjectId, LocalDate date, int page, int pageSize);
}
