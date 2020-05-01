	package com.jackrutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.jackrutorial.service.ReporteCompraService;
import com.jackrutorial.service.UserService;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ReporteCompraService reporteService;
	
	
	@RequestMapping(value="/admin")
	public String inicio(ModelMap model, Authentication authentication) {
		authentication.getPrincipal();
		model.addAttribute("user", userService.getActiveUser(authentication.getName()));
		return "index";
	}
 

//Se añade un cometario a la clase IndexController
	 @RequestMapping("/report")
	    public String verReporte(Model model,
	            @RequestParam(
	                    name = "format",
	                    defaultValue = "pdf",
	                    required = false) String format) {

	        model.addAttribute("format", format);
	        model.addAttribute("datasource_report", reporteService.listCombinado());
	        model.addAttribute("AUTOR", "Ivan");

	        return "Blank_A4_report";
	    }

}
