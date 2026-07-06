package com.foodapp.dao;

import java.util.List;

import com.foodapp.model.User;

/*
 * UserDAO Interface
 * -----------------
 * This interface declares all the database operations
 * related to the User table.
 */

public interface UserDAO {

    // Insert a new user
    int addUser(User user);

    // Fetch a user using the primary key
    User getUserById(int userId);

    // Fetch all users
    List<User> getAllUsers();

    // Update an existing user
    int updateUser(User user);

    // Delete a user
    int deleteUser(int userId);

}