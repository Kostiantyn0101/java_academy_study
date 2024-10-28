package edu.itstep.academy.service;

import edu.itstep.academy.entity.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getAll();
    Subject getById(Long id);
}
