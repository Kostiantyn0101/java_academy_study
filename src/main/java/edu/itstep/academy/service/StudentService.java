package edu.itstep.academy.service;

import edu.itstep.academy.entity.Grade;
import edu.itstep.academy.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAll();
    public Student getById(Long id);
}
