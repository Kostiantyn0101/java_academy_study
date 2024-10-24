package edu.itstep.academy.service;

import edu.itstep.academy.entity.User;
import org.springframework.ui.Model;

public interface UserService {
    public User getUserByUsername(String username);
}
