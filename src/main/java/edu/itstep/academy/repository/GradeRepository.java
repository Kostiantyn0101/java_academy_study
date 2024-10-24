package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Grade;
import java.util.List;

public interface GradeRepository {
    List<Grade> getAll();
    void saveOrUpdate(Grade grade);
    void deleteById(int id);
    Grade getById(int id);
}
