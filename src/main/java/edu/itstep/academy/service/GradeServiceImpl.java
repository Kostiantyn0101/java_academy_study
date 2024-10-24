package edu.itstep.academy.service;

import edu.itstep.academy.dto.GradeDTO;
import edu.itstep.academy.entity.Grade;
import edu.itstep.academy.repository.GradeRepository;
import edu.itstep.academy.repository.StudentRepository;
import edu.itstep.academy.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

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
    public void saveGradeDTO(GradeDTO gradeDTO) {
        Grade grade = new Grade();
        grade.setStudent(studentRepository.getById(gradeDTO.getStudentId()));
        grade.setSubject(subjectRepository.getById(gradeDTO.getSubjectId()));
        grade.setDate(LocalDate.parse(gradeDTO.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        grade.setGrade(gradeDTO.getScore());
        grade.setComment(gradeDTO.getComment());
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
