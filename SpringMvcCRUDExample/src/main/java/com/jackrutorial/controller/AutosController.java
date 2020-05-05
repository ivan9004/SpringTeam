package com.jackrutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jackrutorial.model.Autos;
import com.jackrutorial.service.AutosService;


@Controller
@RequestMapping(value = "/auto")
public class AutosController {
	
	@Autowired
	AutosService autosService;
	
	@RequestMapping(value = "/listAuto", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("auto/auto_page");
		List list = autosService.listAllAutos();
		model.addObject("listAutos",list);
		return model;
	}
	
	@RequestMapping(value = "add",  method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("auto/autos_form");
		Autos autos = new Autos();
		model.addObject("autosForm",autos);
		return model;
	}
	
	@RequestMapping(value = "/update/{idAuto}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("idAuto") int idAuto) {
		ModelAndView model = new ModelAndView("auto/autos_form");
		Autos autos = autosService.findAuto(idAuto);
		model.addObject("autosForm",autos);
		
		return model;
		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("autosForm") Autos autos) {
		if (autos != null && autos.getIdAuto() != 0) {
			autosService.updateAuto(autos);
		} else {
			autosService.addAutos(autos);
		}
		return new ModelAndView("redirect:/auto/listAuto");
	}
	
	
	@RequestMapping(value = "/delete/{idAuto}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("idAuto") int idAuto) {
		autosService.deleteAutos(idAuto);
		return new ModelAndView("redirect:/auto/listAuto");
	}
	
	
}
