package edu.itstep.academy.service;

import edu.itstep.academy.entity.Grade;
import java.util.List;

public interface GradeService {

    public List<Grade> getAllGrades();
    public void addGrade(Grade grade);
    public void updateGrade(Grade grade);
    public void deleteGrade(Long gradeId);
}
