package edu.itstep.academy.service;

import edu.itstep.academy.entity.Teacher;


public interface TeacherService {
    Teacher getById(Long id);
    Teacher getByUserNameId(Long id);
    void saveOrUpdate(Teacher teacher);
}
