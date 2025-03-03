package com.providers;

public class UserServiceImpl implements UserService {

	@Override
	public boolean registerUser(String name, String email) {
		System.out.println("Register user: "+ name + " with email: " + email);
		return true;
	}

	@Override
	public boolean loginUser(String email, String password) {
		System.out.println("Logging in user: "+ email);
		return true;
	}
	
	

}
