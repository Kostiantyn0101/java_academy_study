package edu.itstep.academy.service;

import edu.itstep.academy.entity.Student;
import edu.itstep.academy.entity.Teacher;

import java.util.List;

public interface StudentService {

    public List<Student> getAll();
    public Student getById(Long id);
    public Student getByUserNameId(Long id);

}
