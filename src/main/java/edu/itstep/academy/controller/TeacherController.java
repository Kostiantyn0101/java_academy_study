package edu.itstep.academy.controller;

import edu.itstep.academy.dto.GradeDTO;
import edu.itstep.academy.entity.Grade;
import edu.itstep.academy.entity.Student;
import edu.itstep.academy.entity.Subject;
import edu.itstep.academy.service.GradeService;
import edu.itstep.academy.service.StudentService;
import edu.itstep.academy.service.SubjectService;
import edu.itstep.academy.service.TeacherService;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/students")
    public String getStudents(Model model) {
        List<Student> students = studentService.getAll();
        model.addAttribute("students", students);
        return "students";
    }

    @RequestMapping("/grades")
    public String getGrades(Model model) {
        gradeService.prepareGradePage(model, new GradeDTO());
        return "grades";
    }

    @RequestMapping("/grades/delete")
    public String delete(@RequestParam Long id) {
        gradeService.deleteById(id);
        return "redirect:/teacher/grades";
    }


    //адаптувати для форми, розібратись з підготовкою даних щоб мінімізути кількість методів


    @RequestMapping("/grades/add")
    public String addGrade(Model model) {
        gradeService.prepareGradePage(model, new GradeDTO());
        return "grade-form";
    }

    @RequestMapping("/grades/edit")
    public String editGrade(@RequestParam Long id, Model model) {
        gradeService.prepareEditPage(model, id);
        return "grade-form";
    }

    @PostMapping("/grades/save")
    public String saveGrade(@ModelAttribute("grade") GradeDTO gradeDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "grades";
        }
        gradeService.saveGradeDTO(gradeDTO);
        return "redirect:/teacher/grades";
    }
}
