package edu.itstep.academy.controller;

import edu.itstep.academy.dto.UserRegistrationInDTO;
import edu.itstep.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model,
                                       @RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int pageSize) {
        userService.prepareRegisterPage(model, new UserRegistrationInDTO(), page, pageSize);
        return "register-form";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserRegistrationInDTO userRegistrationInDTO) {
        userService.registerUser(userRegistrationInDTO);
        return "redirect:/admin/success";
    }

    @GetMapping("/success")
    public String registrationSuccess() {
        return "registration-success";
    }
}
