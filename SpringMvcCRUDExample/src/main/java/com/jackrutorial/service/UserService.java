package com.jackrutorial.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.jackrutorial.model.UserInfo;


public interface UserService {

	public List listAllUsers();

	public void addUser(UserInfo user);

	public void updateUser(UserInfo user);

	public void deleteUser(int id);

	public UserInfo findUserById(int id);
	
	@Secured({"ROLE_ADMIN"})
	UserInfo getActiveUser(String username);
	
	@Secured({"ROLE_USER"})
	UserInfo getRoleUser(String username);
}
