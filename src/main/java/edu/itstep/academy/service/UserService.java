package edu.itstep.academy.service;

import edu.itstep.academy.dto.UserRegistrationInDTO;
import edu.itstep.academy.entity.User;

public interface UserService {
    User getCurrentUser();
    void saveOrUpdate(User user);
    void registerUser(UserRegistrationInDTO userRegistrationInDTO);
}
