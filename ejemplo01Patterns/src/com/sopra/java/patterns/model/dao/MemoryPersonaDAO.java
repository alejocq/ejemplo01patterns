package com.sopra.java.patterns.model.dao;

import java.util.Collection;
import java.util.Map;

import com.sopra.java.patterns.model.entities.Persona;

public class MemoryPersonaDAO implements IDaoPersonas{
	
	private Map<String, Persona> mapaPersonas;
	
	public MemoryPersonaDAO(Map<String, Persona> mapaPersonas) {
		super();
		this.mapaPersonas = mapaPersonas;
	}

	@Override
	public void insert(Persona persona) {
		mapaPersonas.putIfAbsent(persona.getDni(), persona);
		
	}

	@Override
	public Persona update(Persona persona) {
		mapaPersonas.replace(persona.getDni(), persona);
		return persona;
	}

	@Override
	public void delete(Persona persona) {
		mapaPersonas.remove(persona.getDni());
		
	}

	@Override
	public Collection<Persona> list() {
		return mapaPersonas.values();		
	}

}
