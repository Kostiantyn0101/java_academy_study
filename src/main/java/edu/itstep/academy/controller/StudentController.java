package edu.itstep.academy.controller;

import edu.itstep.academy.dto.GradeDTO;
import edu.itstep.academy.service.GradeService;
import edu.itstep.academy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private GradeService gradeService;

    @RequestMapping("/grades")
    public String getGrades(Model model,
                            @RequestParam(required = false) Long subjectId,
                            @RequestParam(required = false) String dateStr,
                            @RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "10") int pageSize) {
        gradeService.prepareGradePage(model, new GradeDTO(), subjectId, dateStr, page, pageSize);
        return "grades";
    }
}
