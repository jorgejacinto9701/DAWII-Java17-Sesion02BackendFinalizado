package com.empresa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "deporte")
public class Deporte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDeporte;
	private String nombre;
	
	public int getIdDeporte() {
		return idDeporte;
	}
	public void setIdDeporte(int idDeporte) {
		this.idDeporte = idDeporte;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}



