package edu.itstep.academy.service;

import edu.itstep.academy.entity.Subject;
import edu.itstep.academy.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    @Transactional
    public List<Subject> getAllSubjects() {
        return subjectRepository.getAll();
    }

    @Override
    @Transactional
    public Subject getSubjectById(Long id) {
        return subjectRepository.getById(id);
    }
}
