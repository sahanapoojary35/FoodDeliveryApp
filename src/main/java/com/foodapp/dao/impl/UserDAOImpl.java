
	package com.foodapp.dao.impl;

	import java.util.ArrayList;
	import java.util.List;

	import com.foodapp.dao.UserDAO;
	import com.foodapp.model.User;

	/*
	 * UserDAOImpl
	 * -----------
	 * This class implements the UserDAO interface.
	 * Here we will write the JDBC code later.
	 */

	public class UserDAOImpl implements UserDAO {

	    // Add User

	    @Override
	    public int addUser(User user) {

	        // JDBC code will be written here

	        System.out.println("addUser() called");

	        return 0;
	    }

	    // Get User By Id

	    @Override
	    public User getUserById(int userId) {

	        // JDBC code will be written here

	        System.out.println("getUserById() called");

	        return null;
	    }

	    // Get All Users

	    @Override
	    public List<User> getAllUsers() {

	        // Create an empty list

	        List<User> userList = new ArrayList<>();

	        // JDBC code will be written here

	        System.out.println("getAllUsers() called");

	        return userList;
	    }

	    // Update User

	    @Override
	    public int updateUser(User user) {

	        // JDBC code will be written here

	        System.out.println("updateUser() called");

	        return 0;
	    }

	    // Delete User

	    @Override
	    public int deleteUser(int userId) {

	        // JDBC code will be written here

	        System.out.println("deleteUser() called");

	        return 0;
	    }

	}
	
	
	
	
	
	
	
	
	
	


