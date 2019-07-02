package com.sopra.java.patterns.model.entities;

public class Persona {
	private String nombre;
	private String dni;
	private Boolean esProfesor;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Boolean getEsProfesor() {
		return esProfesor;
	}
	public void setEsProfesor(Boolean esProfesor) {
		this.esProfesor = esProfesor;
	}
	
}
