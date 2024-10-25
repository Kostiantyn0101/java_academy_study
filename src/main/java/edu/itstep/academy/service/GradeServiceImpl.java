package edu.itstep.academy.service;

import edu.itstep.academy.dto.GradeDTO;
import edu.itstep.academy.entity.*;
import edu.itstep.academy.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    public StudentService studentService;

    @Autowired
    public SubjectService subjectService;

    @Autowired
    public TeacherService teacherService;

    @Autowired
    public UserService userService;

    @Override
    public List<Grade> getAll() {
        return gradeRepository.getAll();
    }

    @Override
    public void add(Grade grade) {
        gradeRepository.saveOrUpdate(grade);
    }

    @Override
    public Grade getById(Long id) {
        return gradeRepository.getById(id);
    }

    @Override
    public List<Grade> getGradesByStudentId(Long studentId) {
        return gradeRepository.getByStudentId(studentId);
    }

    @Override
    public List<Grade> getGradesByTeacherId(Long teacherId) {
        return gradeRepository.getByTeacherId(teacherId);
    }

    @Override
    public List<Grade> getGradesByTeacherIdAndSubjectId(Long teacherId, Long subjectId) {
        return gradeRepository.getByTeacherIdAndSubjectId(teacherId, subjectId);
    }

    @Override
    public List<Grade> getGradesByTeacherIdAndDate(Long teacherId, LocalDate date) {
        return gradeRepository.getByTeacherIdAndDate(teacherId, date);
    }

    @Override
    public List<Grade> getGradesByTeacherIdAndSubjectIdAndDate(Long teacherId, Long subjectId, LocalDate date) {
        return gradeRepository.getByTeacherIdAndSubjectIdAndDate(teacherId, subjectId, date);
    }

    @Override
    public void update(Grade grade) {
        gradeRepository.saveOrUpdate(grade);
    }

    @Override
    public void deleteById(Long gradeId) {
        gradeRepository.deleteById(gradeId);
    }

    @Override
    public void saveGradeDTO(GradeDTO gradeDTO) {
        Grade grade = new Grade();
        grade.setId(gradeDTO.getId());
        grade.setStudent(studentService.getById(gradeDTO.getStudentId()));
        grade.setSubject(subjectService.getById(gradeDTO.getSubjectId()));
        grade.setTeacher(teacherService.getById(gradeDTO.getTeacherId()));
        grade.setDate(gradeDTO.getDate());
        grade.setGrade(gradeDTO.getGrade());
        grade.setComment(gradeDTO.getComment());
        gradeRepository.saveOrUpdate(grade);
    }

    @Override
    public void prepareGradePage(Model model, GradeDTO gradeDTO, Long subjectId, String dateStr) {
        List<Student> students = studentService.getAll();
        List<Subject> subjects = subjectService.getAll();
        User user = userService.getCurrentUser();
        Teacher teacher = teacherService.getById(user.getId());

        List<Grade> grades = getGradesByTeacherIdAndFilters(subjectId, dateStr, teacher.getId());

        model.addAttribute("grades", grades);
        model.addAttribute("students", students);
        model.addAttribute("subjects", subjects);
        model.addAttribute("teacher", teacher);
        model.addAttribute("gradeDTO", gradeDTO);
        if (dateStr != null && !dateStr.isEmpty()) {
            model.addAttribute("dateStr", dateStr);
        }
    }

    @Override
    public void prepareEditPage(Model model, Long gradeId) {
        Grade grade = getById(gradeId);
        GradeDTO gradeDTO = convertGradeToGradeDTO(grade);
        prepareGradePage(model, gradeDTO, null, null);
    }

    @Override
    public GradeDTO convertGradeToGradeDTO(Grade grade) {
        GradeDTO gradeDTO = new GradeDTO();

        gradeDTO.setId(grade.getId());
        gradeDTO.setGrade(grade.getGrade());
        gradeDTO.setComment(grade.getComment());
        gradeDTO.setDate(grade.getDate());
        gradeDTO.setTeacherId(grade.getTeacher().getId());
        gradeDTO.setStudentId(grade.getStudent().getId());
        gradeDTO.setSubjectId(grade.getSubject().getId());

        return gradeDTO;
    }

    @Override
    public List<Grade> getGradesByTeacherIdAndFilters(Long subjectId, String dateStr, Long teacherId) {
        LocalDate date = null;
        if (dateStr != null && !dateStr.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            date = LocalDate.parse(dateStr, formatter);
        }

        if (subjectId != null && date != null) {
            return getGradesByTeacherIdAndSubjectIdAndDate(teacherId, subjectId, date);
        } else if (subjectId != null) {
            return getGradesByTeacherIdAndSubjectId(teacherId, subjectId);
        } else if (date != null) {
            return getGradesByTeacherIdAndDate(teacherId, date);
        } else {
            return getGradesByTeacherId(teacherId);
        }
    }


}
