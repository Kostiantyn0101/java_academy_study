package edu.itstep.academy.service;

import edu.itstep.academy.entity.*;
import edu.itstep.academy.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private UserService userService;

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


}
