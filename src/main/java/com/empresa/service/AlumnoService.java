package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Alumno;

public interface AlumnoService {

	public abstract List<Alumno> listaAlumno();
	public abstract List<Alumno> listaAlumnoPorEmail(String email);
	public abstract List<Alumno> listaAlumnoPorDNI(String dni);
	public abstract List<Alumno> listaAlumnoPorNombreLike(String nombre);
	public abstract Alumno insertaAlumno(Alumno objAlumno);
	public abstract Alumno actualizaAlumno(Alumno objAlumno);
	public abstract void eliminaAlumno(int idAlumno);
	public abstract Optional<Alumno> buscaAlumno(int idAlumno);
	
}
