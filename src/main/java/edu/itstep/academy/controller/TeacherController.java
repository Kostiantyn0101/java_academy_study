package edu.itstep.academy.controller;

import edu.itstep.academy.dto.GradeInDTO;
import edu.itstep.academy.dto.GradeOutDTO;
import edu.itstep.academy.service.GradeService;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private GradeService gradeService;

    @RequestMapping("/grades")
    public String getGrades(Model model,
                            @RequestParam(required = false) Long subjectId,
                            @RequestParam(required = false) String dateStr,
                            @RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "10") int pageSize) {
        gradeService.prepareGradePage(model, new GradeOutDTO(), subjectId, dateStr, page, pageSize);
        return "grades";
    }

    @RequestMapping("/grades/delete")
    public String delete(@RequestParam Long id) {
        gradeService.deleteById(id);
        return "redirect:/teacher/grades";
    }

    @RequestMapping("/grades/add")
    public String addGrade(Model model) {
        gradeService.prepareGradePage(model, new GradeOutDTO(), null, null, 0, 0);
        return "grade-form";
    }

    @RequestMapping("/grades/edit")
    public String editGrade(@RequestParam Long id, Model model) {
        gradeService.prepareEditPage(model, id);
        return "grade-form";
    }

    @PostMapping("/grades/save")
    public String saveGrade(@ModelAttribute("gradeOutDTO") @Valid GradeInDTO gradeInDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            gradeService.prepareValidPage(gradeInDTO, model);
            return "grade-form";
        }
        gradeService.saveGradeDTO(gradeInDTO);
        return "redirect:/teacher/grades";
    }
}
