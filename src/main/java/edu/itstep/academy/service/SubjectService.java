package edu.itstep.academy.service;

import edu.itstep.academy.entity.Subject;

import java.util.List;

public interface SubjectService {
    public List<Subject> getAll();
    public Subject getById(Long id);
}
