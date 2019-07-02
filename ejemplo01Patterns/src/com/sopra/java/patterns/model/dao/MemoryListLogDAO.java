package com.sopra.java.patterns.model.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sopra.java.patterns.model.entities.LineaDeLog;

public class MemoryListLogDAO implements IDao<LineaDeLog> {
	
	private List<LineaDeLog> almacenDeLogs;
	
	public MemoryListLogDAO(List<LineaDeLog> almacenDeLogs) {
		super();
		this.almacenDeLogs = almacenDeLogs;
	}

	@Override
	public void insert(LineaDeLog elemento) {
		if(almacenDeLogs.contains(elemento)) {
			almacenDeLogs.add(elemento);
		}
		
	}

	@Override
	public LineaDeLog update(LineaDeLog elemento) {
		if(almacenDeLogs.remove(elemento)) {
			almacenDeLogs.add(elemento);
			return elemento;
		}
		return null;
	}

	@Override
	public void delete(LineaDeLog elemento) {
		almacenDeLogs.remove(elemento);		
	}

	@Override
	public Collection<LineaDeLog> list() {
		return almacenDeLogs;
	}

	@Override
	public Collection<LineaDeLog> search(LineaDeLog elemento) {
		Collection<LineaDeLog> coleccion = new ArrayList<>();
		almacenDeLogs.contains(elemento);
		int indexof = almacenDeLogs.indexOf(elemento);
		LineaDeLog logEncontrado = almacenDeLogs.get(indexof);
		coleccion.add(logEncontrado);
		
		return coleccion;
	}

}
