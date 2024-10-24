package edu.itstep.academy.controller;

import edu.itstep.academy.entity.Student;
import org.springframework.stereotype.*;
import edu.itstep.academy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("/students")
    public String getStudents(Model model) {
        List<Student> students = studentRepository.getAll();
        model.addAttribute("students", students);
        return "students";
    }
}
