package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Subject;

import java.util.List;

public interface SubjectRepository {
    List<Subject> getAll();
    void saveOrUpdate(Subject grade);
    void deleteById(Long id);
    Subject getById(Long id);
}
