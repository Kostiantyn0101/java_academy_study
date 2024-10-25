package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Student;
import edu.itstep.academy.entity.Teacher;

import java.util.List;

public interface StudentRepository {
    List<Student> getAll();
    void saveOrUpdate(Student student);
    void deleteById(Long id);
    Student getById(Long id);
    Student getByUsernameId(Long userId);
}
