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
    public void saveGradeDTO(GradeDTO gradeDTO) {
        Grade grade = new Grade();
        grade.setId(gradeDTO.getId());
        grade.setStudent(studentService.getById(gradeDTO.getStudentId()));
        grade.setSubject(subjectService.getById(gradeDTO.getSubjectId()));
        grade.setTeacher(teacherService.getById(gradeDTO.getTeacherId()));
        grade.setDate(LocalDate.parse(gradeDTO.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        grade.setGrade(gradeDTO.getGrade());
        grade.setComment(gradeDTO.getComment());
        gradeRepository.saveOrUpdate(grade);
    }

    @Override
    public Grade getById(Long id){
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
    public void update(Grade grade) {
        gradeRepository.saveOrUpdate(grade);
    }

    @Override
    public void deleteById(Long gradeId) {
        gradeRepository.deleteById(gradeId);
    }

    @Override
    public void prepareGradePage(Model model, GradeDTO gradeDTO) {
        List<Student> students = studentService.getAll();
        List<Subject> subjects = subjectService.getAll();
        User user = userService.getCurrentUser();
        Teacher teacher = teacherService.getById(user.getId());
        List<Grade> grades = getGradesByTeacherId(teacher.getId());

        model.addAttribute("grades", grades);
        model.addAttribute("students", students);
        model.addAttribute("subjects", subjects);
        model.addAttribute("teacher", teacher);
        model.addAttribute("gradeDTO", gradeDTO);
    }

    @Override
    public void prepareEditPage(Model model, Long gradeId){
        Grade grade = getById(gradeId);
        GradeDTO gradeDTO = convertGradeToGradeDTO(grade);
        prepareGradePage(model, gradeDTO);
    }

    @Override
    public GradeDTO convertGradeToGradeDTO(Grade grade) {
        GradeDTO gradeDTO = new GradeDTO();

        gradeDTO.setId(grade.getId());
        gradeDTO.setGrade(grade.getGrade());
        gradeDTO.setComment(grade.getComment());
        gradeDTO.setDate(gradeDTO.getDate());
        gradeDTO.setTeacherId(grade.getTeacher().getId());
        gradeDTO.setStudentId(grade.getStudent().getId());
        gradeDTO.setSubjectId(grade.getSubject().getId());

        return gradeDTO;
    }
}
