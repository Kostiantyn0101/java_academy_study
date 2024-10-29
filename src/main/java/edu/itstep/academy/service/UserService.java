package edu.itstep.academy.service;

import edu.itstep.academy.entity.User;

public interface UserService {
    User getCurrentUser();
    void saveOrUpdate(User user);
    void registerUser(String username, String password, Long roleId, String firstName, String lastName);
}
