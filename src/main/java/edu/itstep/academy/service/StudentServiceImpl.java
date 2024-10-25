package edu.itstep.academy.service;

import edu.itstep.academy.entity.Student;
import edu.itstep.academy.entity.Teacher;
import edu.itstep.academy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.getById(id);
    }

    @Override
    public Student getByUserNameId(Long id) {
        return studentRepository.getByUsernameId(id);
    }
}
