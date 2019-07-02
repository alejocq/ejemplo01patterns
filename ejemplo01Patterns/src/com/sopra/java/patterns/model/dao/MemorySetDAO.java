package com.sopra.java.patterns.model.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import com.sopra.java.patterns.model.entities.Clasroom;

public class MemorySetDAO implements IDao<Clasroom> {
	private Set<Clasroom> miSet;
	@Override
	public void insert(Clasroom aula) {
		miSet.add(aula);		
	}

	@Override
	public Clasroom update(Clasroom aula) {
		if(miSet.remove(aula)) {			
			miSet.add(aula);
			return aula;
		}
		return null;
	}

	@Override
	public void delete(Clasroom aula) {
		miSet.remove(aula);
		
	}

	@Override
	public Collection<Clasroom> list() {		
		return miSet;
	}

	@Override
	public Collection<Clasroom> search(Clasroom aula) {	
		Collection<Clasroom> miColeccion = new ArrayList<>();
		if(miSet.contains(aula)) {
			for(Clasroom aulaActual: miSet) {
				if(aulaActual.equals(aula)) {
					miColeccion.add(aulaActual);
					return miColeccion;
				}
			}
		}
		return miColeccion;
	}
	
}
