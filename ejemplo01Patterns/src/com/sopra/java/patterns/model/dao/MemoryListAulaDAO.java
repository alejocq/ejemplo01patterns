package com.sopra.java.patterns.model.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sopra.java.patterns.model.entities.Clasroom;

public class MemoryListAulaDAO implements IDao<Clasroom> {

	private List<Clasroom> miListaDeAulas;
	
	@Override
	public void insert(Clasroom aula) {		
		if(miListaDeAulas.contains(aula)) {
			miListaDeAulas.add(aula);
		}
		/*
		Collection<Clasroom> aulasEncontradas = search(aula);
		if(aulasEncontradas.size() == 0) {
			miListaDeAulas.add(aula);
		}	*/	
		
	}

	@Override
	public Clasroom update(Clasroom aula) {	
		if(miListaDeAulas.remove(aula)) {			
			miListaDeAulas.add(aula);
			return aula;
		}
		return null;
		/*
		Collection<Clasroom> aulasEncontradas = search(aula);
		if(aulasEncontradas.size() == 1) {
			Clasroom aulaEncontrada = aulasEncontradas.iterator().next();		
			miListaDeAulas.remove(aulaEncontrada);
			miListaDeAulas.add(aula);
		}
		
		return aula; */
	}

	@Override
	public void delete(Clasroom aula) {
		miListaDeAulas.remove(aula);
		/*
		Collection<Clasroom> aulasEncontradas = search(aula);
		if(aulasEncontradas.size() == 1) {
			miListaDeAulas.remove(aulasEncontradas.iterator().next());
		}
		*/
	}

	@Override
	public Collection<Clasroom> list() {		
		return miListaDeAulas;
	}

	@Override
	public Collection<Clasroom> search(Clasroom aula) {
		Collection<Clasroom> coleccion = new ArrayList<>();
		miListaDeAulas.contains(aula);
		int indexOf = miListaDeAulas.indexOf(aula);
		Clasroom aulaEncontrada = miListaDeAulas.get(indexOf);
		coleccion.add(aulaEncontrada);
		/*
		Collection<Clasroom> coleccion = new ArrayList<>();
		for(Clasroom aulaActual: miListaDeAulas) {
			if(aula.getNombre().equals(aulaActual.getNombre())) {
				coleccion.add(aulaActual);
			}
		}*/
		return coleccion;
	}

}
