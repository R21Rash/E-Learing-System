package com.providers;

public interface UserService {
    boolean registerUser(String name, String email, String role);  // Role: "Admin" or "Student"
    boolean loginUser(String email, String password);
    void displayUsers();
}