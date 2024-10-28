package edu.itstep.academy.service;

import edu.itstep.academy.entity.*;
import edu.itstep.academy.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher getById(Long id) {
        return teacherRepository
                .getById(id);
    }

    @Override
    public Teacher getByUserNameId(Long id) {
        return teacherRepository
                .getByUsernameId(id);
    }

    @Override
    public void saveOrUpdate(Teacher teacher) {
        teacherRepository.saveOrUpdate(teacher);
    }
}
