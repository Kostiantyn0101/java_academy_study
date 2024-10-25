package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Grade;

import java.time.LocalDate;
import java.util.List;

public interface GradeRepository {
    List<Grade> getAll();
    void saveOrUpdate(Grade grade);
    void deleteById(Long id);
    Grade getById(Long id);
    List<Grade> getByStudentId(Long id);
    List<Grade> getByTeacherId(Long id);
    List<Grade> getByTeacherIdAndSubjectId(Long teacherId, Long subjectId);
    List<Grade> getByTeacherIdAndDate(Long teacherId, LocalDate date);
    List<Grade> getByTeacherIdAndSubjectIdAndDate(Long teacherId, Long subjectId, LocalDate date);
}
