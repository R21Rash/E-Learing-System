package com.providers;

public interface UserService {
		boolean registerUser(String name, String email);
		boolean loginUser(String email, String password);
}
