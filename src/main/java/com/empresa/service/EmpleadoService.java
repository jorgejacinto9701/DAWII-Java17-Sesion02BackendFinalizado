package com.empresa.service;

import java.util.List;

import com.empresa.entity.Empleado;

public interface EmpleadoService {

	public abstract List<Empleado> listaEmpleado();
	public abstract Empleado insertaEmpleado(Empleado obj);
	
}
