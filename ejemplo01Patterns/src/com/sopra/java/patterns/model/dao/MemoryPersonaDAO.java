package com.sopra.java.patterns.model.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.sopra.java.patterns.model.entities.Persona;

public class MemoryPersonaDAO implements IMultipleDao<Persona, String>{
	
	private Map<String, Persona> almacenDepersonas;
	
	
	public MemoryPersonaDAO(Map<String, Persona> almacenDepersonas) {
		super();
		this.almacenDepersonas = almacenDepersonas;
	}

	@Override
	public void insert(Persona elemento) {
		almacenDepersonas.putIfAbsent(elemento.getDni(), elemento);
		
	}

	@Override
	public Persona update(Persona elemento) {
		if(almacenDepersonas.replace(elemento.getDni(), elemento) != null) {
			return elemento;
		}
		return null;
	}

	@Override
	public void delete(Persona elemento) {
		almacenDepersonas.remove(elemento.getDni());
		
	}

	@Override
	public Collection<Persona> list() {
		
		return almacenDepersonas.values();
	}

	@Override
	public List<Persona> searchByNames(String name) {
		List<Persona> lista = new ArrayList<>();
		for(Persona persona : almacenDepersonas.values()) {
			if(persona.getNombre().equals(name)) {
				lista.add(persona);
			}
		}
		return lista;
	}

	@Override
	public Persona searchById(String id) {		
		return almacenDepersonas.get(id);
	}
	
	
	

}
