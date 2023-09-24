package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
	

}