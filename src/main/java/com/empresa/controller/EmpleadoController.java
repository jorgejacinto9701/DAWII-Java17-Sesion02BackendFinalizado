package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Empleado;
import com.empresa.service.EmpleadoService;

@RestController
@RequestMapping("/url/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping
	public List<Empleado> listaEmpleado(){
		List<Empleado> lstSalida = empleadoService.listaEmpleado();
		return lstSalida;
	}

	@PostMapping
	public Map<String, Object> insertaEmpleado (@RequestBody Empleado obj){
		Map<String, Object> salida = new HashMap<>();
		Empleado objSalida = empleadoService.insertaEmpleado(obj);
		if (objSalida == null) {
			salida.put("mensaje", "Error en el registro");
		}else {
			salida.put("mensaje", "Se registro el empleado con ID ==> " + objSalida.getIdEmpleado());
		}
		return salida;
	}
	
	
}







