package edu.itstep.academy.service;

import edu.itstep.academy.entity.Teacher;
import org.springframework.ui.Model;

public interface TeacherService {
    public Teacher getById(Long id);
}
