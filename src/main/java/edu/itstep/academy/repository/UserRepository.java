package edu.itstep.academy.repository;


import edu.itstep.academy.entity.User;

public interface UserRepository {
    User getUserByUsername(String username);
}
