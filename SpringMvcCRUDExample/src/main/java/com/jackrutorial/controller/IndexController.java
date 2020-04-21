package com.jackrutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jackrutorial.service.CompraService;
import com.jackrutorial.service.ReporteCompraService;

@Controller
public class IndexController {
	
	@Autowired
	ReporteCompraService reporteService;
	
	@RequestMapping("/")
	public String inicio() {
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
