package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Alumno;
import com.empresa.service.AlumnoService;

@RestController
@RequestMapping("/rest/alumno")
public class AlumnoController {

	@Autowired
	private AlumnoService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Alumno>> listaAlumno(){
		List<Alumno> lista = service.listaAlumno();
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/porEmail/{filtro}")
	@ResponseBody
	public ResponseEntity<List<Alumno>> listaPorEmail(@PathVariable("filtro") String filtro){
		List<Alumno> lista = service.listaAlumnoPorEmail(filtro);
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/porDNI/{filtro}")
	@ResponseBody
	public ResponseEntity<List<Alumno>> listaPorDNI(@PathVariable("filtro") String filtro){
		List<Alumno> lista = service.listaAlumnoPorDNI(filtro);
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/porNombre/{filtro}")
	@ResponseBody
	public ResponseEntity<List<Alumno>> listaPorNombre(@PathVariable("filtro") String filtro){
		List<Alumno> lista = service.listaAlumnoPorNombreLike(filtro+"%");
		return ResponseEntity.ok(lista);
	}
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> insertaAlumno(@RequestBody Alumno objAlumno){
		HashMap<String, String> mensaje = new HashMap<>();
		Alumno objSalida = service.insertaAlumno(objAlumno);
		if (objSalida == null) {
			mensaje.put("mensaje", "Error en el registro");
		}else {
			mensaje.put("mensaje", "Se ha registrado el Alumno de ID " + objSalida.getIdAlumno());
		}
		return ResponseEntity.ok(mensaje);
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<?> actualizaAlumno(@RequestBody Alumno objAlumno){
		HashMap<String, String> mensaje = new HashMap<>();
		
		Optional<Alumno> optAlumno = service.buscaAlumno(objAlumno.getIdAlumno());
		if (optAlumno.isPresent()) {
			Alumno objSalida = service.actualizaAlumno(objAlumno);
			if (objSalida == null) {
				mensaje.put("mensaje", "Error en el registro");
			}else {
				mensaje.put("mensaje", "Se ha actualizado el Alumno de ID " + objSalida.getIdAlumno());
			}
		}else {
			mensaje.put("mensaje", "No existe alumno de ID " + objAlumno.getIdAlumno());
		}
		return ResponseEntity.ok(mensaje);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> eliminaAlumno(@PathVariable("id") int idAlumno){
		HashMap<String, String> mensaje = new HashMap<>();
		Optional<Alumno> optAlumno = service.buscaAlumno(idAlumno);
		if (optAlumno.isPresent()) {
			service.eliminaAlumno(idAlumno);
			mensaje.put("mensaje", "Se ha eliminado el Alumno de ID " + idAlumno);
		}else {
			mensaje.put("mensaje", "No existe alumno de ID " + idAlumno);
		}
		return ResponseEntity.ok(mensaje);
	}
	
}




