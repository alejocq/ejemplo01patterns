package com.sopra.java.patterns.model.entities;

import java.io.Serializable;

public class Profesor extends Persona implements Serializable{	

	public Profesor(String nombre, String dni) {
		super(nombre, dni);		
	}

	@Override
	public String Identificador() {		
		return "Profesor:" + this.getNombre();
	}

	
}
