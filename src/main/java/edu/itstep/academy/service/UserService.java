package edu.itstep.academy.service;

import edu.itstep.academy.dto.UserRegistrationInDTO;
import edu.itstep.academy.entity.User;
import org.springframework.ui.Model;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getCurrentUser();
    void saveOrUpdate(User user);
    void registerUser(UserRegistrationInDTO userRegistrationInDTO);
    void prepareRegisterPage(Model model, UserRegistrationInDTO userRegistrationInDTO, int page, int pageSize);
}
