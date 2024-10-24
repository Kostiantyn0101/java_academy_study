package edu.itstep.academy.service;

import edu.itstep.academy.entity.Grade;
import edu.itstep.academy.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    @Transactional
    public List<Grade> getAllGrades() {
        return gradeRepository.getAll();
    }

    @Override
    @Transactional
    public void addGrade(Grade grade) {
        gradeRepository.saveOrUpdate(grade);
    }

    @Override
    @Transactional
    public void updateGrade(Grade grade) {
        gradeRepository.saveOrUpdate(grade);
    }

    @Override
    @Transactional
    public void deleteGrade(Long gradeId) {
        gradeRepository.deleteById(gradeId);
    }
}
