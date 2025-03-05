package com.providers;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
	  private Map<String, String> userDatabase = new HashMap<>();
	  
	  
	  @Override
	    public boolean registerUser(String name, String email, String role) {
	        if (!"Admin".equalsIgnoreCase(role) && !"Student".equalsIgnoreCase(role)) {
	            System.out.println(" Invalid role! Use 'Admin' or 'Student'.");
	            return false;
	        }

	        if (userDatabase.containsKey(email)) {
	            System.out.println(" User with email " + email + " already exists!");
	            return false;
	        }

	        userDatabase.put(email, role);
	        System.out.println(" Registered " + role + ": " + name + " (" + email + ")");
	        return true;
	    }

	    @Override
	    public boolean loginUser(String email, String password) {
	        if (!userDatabase.containsKey(email)) {
	            System.out.println(" Login failed! User not found.");
	            return false;
	        }

	        System.out.println(" Login successful: " + email + " (Role: " + userDatabase.get(email) + ")");
	        return true;
	    }

	    @Override
	    public void displayUsers() {
	        System.out.println("\n Registered Users:");
	        userDatabase.forEach((email, role) -> System.out.println("- " + email + " (" + role + ")"));
	    }
	}