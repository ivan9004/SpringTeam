package com.jackrutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jackrutorial.service.UserService;

@Controller
@RequestMapping("/userRole")
public class IndexUserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user")
	public String user(ModelMap model, Authentication authentication) {
		authentication.getPrincipal();
		model.addAttribute("user", userService.getRoleUser(authentication.getName()));
		return "indexUser";
	}

}
