package edu.itstep.academy.service;

import edu.itstep.academy.entity.Student;


import java.util.List;

public interface StudentService {

    List<Student> getAll();
    Student getById(Long id);
    Student getByUserNameId(Long id);
    void saveOrUpdate(Student student);

}
