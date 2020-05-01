package com.jackrutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jackrutorial.dao.InicioDao;
import com.jackrutorial.dao.UserDao;
import com.jackrutorial.model.UserInfo;

@Service
public class UserServiceImpl implements UserService {

	UserDao userDao;
	
	@Autowired
	private InicioDao inicioDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List listAllUsers() {
		return userDao.listAllUsers();
	}

	public void addUser(UserInfo user) {
		userDao.addUser(user);
	}

	public void updateUser(UserInfo user) {
		userDao.updateUser(user);
	}

	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	public UserInfo findUserById(int id) {
		return userDao.findUserById(id);
	}

	public UserInfo getActiveUser(String username) {
		return inicioDao.getActiveUser(username);
	}

	public UserInfo getRoleUser(String username) {
		return inicioDao.getActiveUser(username);
	}
	

}
