package com.jackrutorial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jackrutorial.model.Autos;
import com.jackrutorial.service.AutosService;

@RestController
@RequestMapping("/rest")
public class AutosRestController {
	
	@Autowired
	private AutosService autoService;
	
	
	@GetMapping(path = "/autos/get", produces = MediaType.APPLICATION_JSON_VALUE)
	   public ResponseEntity<List<Autos>> getJSON() {
	      List<Autos> list = autoService.listAllAutos();
	      return ResponseEntity
	            .ok()
	            .cacheControl(CacheControl.noCache())
	            .body(list);
	   }

}
