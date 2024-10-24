package edu.itstep.academy.service;

import edu.itstep.academy.entity.Student;
import edu.itstep.academy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return studentRepository.getAll();
    }

    @Override
    @Transactional
    public Student getStudentById(Long id) {
        return studentRepository.getById(id);
    }
}
