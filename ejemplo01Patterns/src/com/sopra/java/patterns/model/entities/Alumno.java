package com.sopra.java.patterns.model.entities;

public class Alumno extends Persona {

	public Alumno(String nombre, String dni) {
		super(nombre, dni);
	}

	@Override
	public String Identificador() {
		
		return "Alumno: " + this.getNombre();
	}

}
