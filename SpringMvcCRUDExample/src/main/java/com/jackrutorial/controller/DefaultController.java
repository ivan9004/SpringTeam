package com.jackrutorial.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dafult")
public class DefaultController {
	
	@RequestMapping(value="/defaultAuth")
	public String defaultAuth(HttpServletRequest request) {
		System.out.println("Si entro");
		if (request.isUserInRole("ROLE_ADMIN")) {
			return "redirect:/index/admin"; 
		}
		return "redirect:/userRole/user";
	}
}
