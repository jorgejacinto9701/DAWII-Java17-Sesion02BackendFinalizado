package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Deporte;
import com.empresa.service.DeporteService;
import com.empresa.util.AppSettings;

@RestController
@RequestMapping("/url/util")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class UtilController {

	@Autowired
	private DeporteService  deporteService;

	@GetMapping("/deporte")
	@ResponseBody
	public ResponseEntity<List<Deporte>> listaDeporte(){
		List<Deporte> lista = deporteService.listaDeporte();
		return ResponseEntity.ok(lista);
	}
	
}
