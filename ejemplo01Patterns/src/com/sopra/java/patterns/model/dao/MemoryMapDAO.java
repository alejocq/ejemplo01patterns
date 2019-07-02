package com.sopra.java.patterns.model.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.sopra.java.patterns.model.entities.Clasroom;

public class MemoryMapDAO implements IDao<Clasroom> {
	
	private Map<String, Clasroom> miMapa; 
	
	
	
	public MemoryMapDAO(Map<String, Clasroom> miMapa) {
		super();
		this.miMapa = miMapa;
	}

	@Override
	public void insert(Clasroom aula) {
		miMapa.putIfAbsent(aula.getNombre(), aula);		
	}

	@Override
	public Clasroom update(Clasroom aula) {
		miMapa.replace(aula.getNombre(), aula);
		return aula;
	}

	@Override
	public void delete(Clasroom aula) {
		miMapa.remove(aula.getNombre());
		
	}

	@Override
	public Collection<Clasroom> list() {		
		return miMapa.values();
		
	}

	@Override
	public Collection<Clasroom> search(Clasroom aula) {
		Collection<Clasroom> coleccion = new ArrayList<>();
		
		Clasroom clasroom = miMapa.get(aula.getNombre());
		if(clasroom != null) {
			coleccion.add(clasroom);
		}
		
		return coleccion;
	}

}
