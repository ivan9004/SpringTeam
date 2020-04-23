package com.jackrutorial.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jackrutorial.model.Autos;
import com.jackrutorial.model.Compra;
import com.jackrutorial.model.User;
import com.jackrutorial.service.AutosService;
import com.jackrutorial.service.CompraService;
import com.jackrutorial.service.UserService;

@Controller
@RequestMapping(value = "/compra")
public class CompraController {

	@Autowired
	CompraService compraService;

	@Autowired
	UserService userService;

	@Autowired
	AutosService autoService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("compra/compraP");
		List list = compraService.listAllCompras();
		model.addObject("listCompra", list);
		return model;
	}

	@RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
	public ModelAndView add(@PathVariable("id") int id) {

		ModelAndView model = new ModelAndView("compra/compraForm");

		Compra compra = compraService.findCompra(id);

		User user = userService.findUserById(id);

		List list = autoService.listAllAutos();

		Iterator<Autos> i = list.iterator();

		Map<Integer, String> autoMap = new HashMap<Integer, String>();

		while (i.hasNext()) {
			Autos autos = i.next();
			autoMap.put(autos.getIdAuto(), autos.getNombreAuto());
		}
		
		double total = compra.getPaInicial() - compra.getRest();

		model.addObject("userMap", user.getNombre() + " " + user.getApellidos());

		model.addObject("autoMap", autoMap);

		model.addObject("formCompra", compra);
		
		model.addObject("total",total);

		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("compraForm") Compra compra) {
		compraService.addCompra(compra);
		return new ModelAndView("redirect:/user/list");
	}

}
