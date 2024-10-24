package edu.itstep.academy.service;

import edu.itstep.academy.entity.Subject;

import java.util.List;

public interface SubjectService {
    public List<Subject> getAllSubjects();
    public Subject getSubjectById(Long id);
}
