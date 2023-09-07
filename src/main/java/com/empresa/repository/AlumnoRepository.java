package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {


	//Usando JPQL (Query usando clases)
	@Query("select p from Alumno p where p.correo = ?1")
	public List<Alumno> listaAlumnoPorEmail(String email);
	
	//Usando Query Method
	public List<Alumno> findByDni(String dni);
	public List<Alumno> findByNombreLike(String nombre);
	
	
	
}
