package edu.itstep.academy.service;

import edu.itstep.academy.dto.GradeDTO;
import edu.itstep.academy.entity.Grade;
import java.util.List;

public interface GradeService {

    public List<Grade> getAll();
    public void add(Grade grade);
    public void update(Grade grade);
    public void deleteById(Long gradeId);
    public void saveGradeDTO(GradeDTO gradeDTO);
    public List<Grade> getGradesByStudent(Long studentId);
    public List<Grade> getGradesByTeacher(Long teacherId);
}
