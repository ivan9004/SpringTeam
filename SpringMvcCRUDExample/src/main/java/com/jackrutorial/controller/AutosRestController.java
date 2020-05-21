package com.jackrutorial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jackrutorial.model.Autos;
import com.jackrutorial.service.AutosService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest")
public class AutosRestController {

	@Autowired
	private AutosService autoService;

	@GetMapping(path = "/autos/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Autos>> getJSON() {
		List<Autos> list = autoService.listAllAutos();
		return ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(list);
	}

	@PostMapping("/autos/save")
	public ResponseEntity<?> save(@RequestBody Autos autos) {
		autoService.addAutos(autos);
		return ResponseEntity.ok().body("Auto " + autos.getNombreAuto() + " fue agregado");
	}

	@GetMapping("/autos/auto/{id}")
	public ResponseEntity<Autos> findbyId(@PathVariable("id") int id) {
		Autos auto = autoService.findAuto(id);
		return ResponseEntity.ok().body(auto);
	}
	
	@PutMapping("/autos/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, Autos auto){
		Autos autpUp = autoService.findAuto(id);
		autoService.updateAuto(autpUp);
		return ResponseEntity.ok().body("Se actualizo el auto correctamente"+ autpUp.getIdAuto());
	}
	
	@DeleteMapping("/autos/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		autoService.deleteAutos(id);
		return ResponseEntity.ok().body("El auto se elimino");
	}

}
