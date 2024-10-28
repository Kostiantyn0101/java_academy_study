package edu.itstep.academy.service;

import edu.itstep.academy.entity.User;

public interface UserService {
    User getCurrentUser();
    void saveOrUpdate(User user);
    void registerUser(String username, String password, String role, String firstName, String lastName);
}
