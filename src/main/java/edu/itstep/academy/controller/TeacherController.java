package edu.itstep.academy.controller;

import edu.itstep.academy.dto.GradeDTO;
import edu.itstep.academy.entity.Student;
import edu.itstep.academy.service.GradeService;
import edu.itstep.academy.service.StudentService;
import edu.itstep.academy.service.SubjectService;
import edu.itstep.academy.service.TeacherService;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeService gradeService;

    @RequestMapping("/students")
    public String getStudents(Model model) {
        List<Student> students = studentService.getAll();
        model.addAttribute("students", students);
        return "students";
    }

    @RequestMapping("/grades")
    public String getGrades(Model model,
                            @RequestParam(required = false) Long subjectId,
                            @RequestParam(required = false) String dateStr) {
        gradeService.prepareGradePage(model, new GradeDTO(), subjectId, dateStr);
        return "grades";
    }

    @RequestMapping("/grades/delete")
    public String delete(@RequestParam Long id) {
        gradeService.deleteById(id);
        return "redirect:/teacher/grades";
    }

    @RequestMapping("/grades/add")
    public String addGrade(Model model) {
        gradeService.prepareGradePage(model, new GradeDTO(), null, null);
        return "grade-form";
    }

    @RequestMapping("/grades/edit")
    public String editGrade(@RequestParam Long id, Model model) {
        gradeService.prepareEditPage(model, id);
        return "grade-form";
    }

    @PostMapping("/grades/save")
    public String saveGrade(@Valid @ModelAttribute("gradeDTO") GradeDTO gradeDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "grade-form";
        }
        gradeService.saveGradeDTO(gradeDTO);
        return "redirect:/teacher/grades";
    }
}
