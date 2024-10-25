package edu.itstep.academy.service;

import edu.itstep.academy.dto.GradeDTO;
import edu.itstep.academy.entity.Grade;
import org.springframework.ui.Model;

import java.util.List;

public interface GradeService {
    public Grade getById(Long id);
    public List<Grade> getAll();
    public void add(Grade grade);
    public void update(Grade grade);
    public void deleteById(Long gradeId);
    public void saveGradeDTO(GradeDTO gradeDTO);
    public List<Grade> getGradesByStudentId(Long studentId);
    public List<Grade> getGradesByTeacherId(Long teacherId);
    public void prepareGradePage(Model model, GradeDTO gradeDTO);
    public void prepareEditPage(Model model, Long gradeId);

    public GradeDTO convertGradeToGradeDTO(Grade grade);

}
