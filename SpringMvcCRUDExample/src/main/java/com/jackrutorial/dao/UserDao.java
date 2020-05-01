package com.jackrutorial.dao;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.jackrutorial.model.UserInfo;


public interface UserDao {

	public List listAllUsers();

	public void addUser(UserInfo user);

	public void updateUser(UserInfo user);

	public void deleteUser(int id);

	public UserInfo findUserById(int id);
	
	
}
