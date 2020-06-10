package com.jackrutorial.dao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jackrutorial.model.UserInfo;


@Service
public class InicioSecionReq implements UserDetailsService{
	
	@Autowired
	private InicioDao inicioDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo user = inicioDao.getActiveUser(username);
		GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
		UserDetails userDetails = (UserDetails) new User(user.getUsername(), user.getPassword(),Arrays.asList(authority));
		return userDetails;
	}

}
