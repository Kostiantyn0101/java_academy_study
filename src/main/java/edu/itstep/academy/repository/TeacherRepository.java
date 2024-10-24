package edu.itstep.academy.repository;


import edu.itstep.academy.entity.Teacher;

public interface TeacherRepository {
    Teacher getById(Long id);
    Teacher getByUserId(Long userId);
}
