package edu.itstep.academy.repository;


import edu.itstep.academy.entity.User;

import java.util.List;

public interface UserRepository{
    List<User> getAll();
    User getUserByUsername(String username);
    void saveOrUpdate(User user);
}
