package com.sopra.java.patterns.model.dao;

import java.util.Collection;

import com.sopra.java.patterns.model.entities.LineaDeLog;
import com.sopra.java.patterns.model.entities.Persona;

public interface IDaoPersonas {
	void insert(Persona persona);
	Persona update(Persona persona);
	void delete(Persona persona);
	Collection<Persona> list();
}
