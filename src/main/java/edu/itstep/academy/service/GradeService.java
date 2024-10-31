package edu.itstep.academy.service;

import edu.itstep.academy.dto.GradeInDTO;
import edu.itstep.academy.dto.GradeOutDTO;
import edu.itstep.academy.dto.StudentOutDTO;
import edu.itstep.academy.dto.SubjectOutDTO;
import edu.itstep.academy.entity.Grade;
import edu.itstep.academy.entity.Student;
import edu.itstep.academy.entity.Subject;
import edu.itstep.academy.entity.Teacher;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;

public interface GradeService {
    Grade getById(Long id);
    List<Grade> getAll();
    void add(Grade grade);
    void update(Grade grade);
    void deleteById(Long gradeId);
    void saveGradeDTO(GradeInDTO gradeInDTO);

    List<Grade> getGradesByTeacherId(Long teacherId, int page, int pageSize);
    List<Grade> getGradesByTeacherIdAndSubjectId(Long teacherId, Long subjectId, int page, int pageSize);
    List<Grade> getGradesByTeacherIdAndDate(Long teacherId, LocalDate date, int page, int pageSize);
    List<Grade> getGradesByTeacherIdAndSubjectIdAndDate(Long teacherId, Long subjectId, LocalDate date, int page, int pageSize);
    List<Grade> getGradesByStudentId(Long studentId, int page, int pageSize);
    List<Grade> getGradesByStudentIdAndSubjectId(Long studentId, Long subjectId, int page, int pageSize);
    List<Grade> getGradesByStudentIdAndDate(Long studentId, LocalDate date, int page, int pageSize);
    List<Grade> getGradesByStudentIdAndSubjectIdAndDate(Long studentId, Long subjectId, LocalDate date, int page, int pageSize);

    void prepareGradePage(Model model, GradeOutDTO gradeOutDTO, Long subjectId, String dateStr, int page, int pageSize);
    void prepareGradeModel(Model model, List<GradeOutDTO> grades, List<StudentOutDTO> students, List<SubjectOutDTO> subjects, Teacher teacher,
                           GradeOutDTO gradeOutDTO, String dateStr, Student student, int page, int pageSize);
    void prepareEditPage(Model model, Long gradeId);
    List<Grade> getGradesByTeacherIdAndFilters(Long subjectId, String dateStr, Long teacherId, int page, int pageSize);
    List<Grade> getGradesByStudentIdAndFilters(Long subjectId, String dateStr, Long studentId, int page, int pageSize);
}
