package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAll();
    void saveOrUpdate(Student student);
    void deleteById(int id);
    Student getById(int id);
}
