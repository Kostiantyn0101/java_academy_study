package edu.itstep.academy.service;

import edu.itstep.academy.dto.GradeDTO;
import edu.itstep.academy.entity.Grade;
import edu.itstep.academy.entity.Student;
import edu.itstep.academy.entity.Subject;
import edu.itstep.academy.entity.Teacher;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;

public interface GradeService {
    public Grade getById(Long id);
    public List<Grade> getAll();
    public void add(Grade grade);
    public void update(Grade grade);
    public void deleteById(Long gradeId);
    public void saveGradeDTO(GradeDTO gradeDTO);

    public List<Grade> getGradesByTeacherId(Long teacherId, int page, int pageSize);
    public List<Grade> getGradesByTeacherIdAndSubjectId(Long teacherId, Long subjectId, int page, int pageSize);
    public List<Grade> getGradesByTeacherIdAndDate(Long teacherId, LocalDate date, int page, int pageSize);
    public List<Grade> getGradesByTeacherIdAndSubjectIdAndDate(Long teacherId, Long subjectId, LocalDate date, int page, int pageSize);
    public List<Grade> getGradesByStudentId(Long studentId, int page, int pageSize);
    public List<Grade> getGradesByStudentIdAndSubjectId(Long studentId, Long subjectId, int page, int pageSize);
    public List<Grade> getGradesByStudentIdAndDate(Long studentId, LocalDate date, int page, int pageSize);
    public List<Grade> getGradesByStudentIdAndSubjectIdAndDate(Long studentId, Long subjectId, LocalDate date, int page, int pageSize);

    public void prepareGradePage(Model model, GradeDTO gradeDTO, Long subjectId, String dateStr, int page, int pageSize);
    public void prepareGradeModel(Model model, List<Grade> grades, List<Student> students, List<Subject> subjects, Teacher teacher,
                                  GradeDTO gradeDTO, String dateStr, Student student, int page, int pageSize);
    public void prepareEditPage(Model model, Long gradeId);
    public GradeDTO convertGradeToGradeDTO(Grade grade);
    public List<Grade> getGradesByTeacherIdAndFilters(Long subjectId, String dateStr, Long teacherId, int page, int pageSize);
    public List<Grade> getGradesByStudentIdAndFilters(Long subjectId, String dateStr, Long studentId, int page, int pageSize);
}
