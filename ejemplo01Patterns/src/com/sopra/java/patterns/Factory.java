package com.sopra.java.patterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.sopra.java.patterns.model.dao.IDao;
import com.sopra.java.patterns.model.dao.IMultipleDao;
import com.sopra.java.patterns.model.dao.MemoryListLogDAO;
import com.sopra.java.patterns.model.dao.MemoryMapDAO;
import com.sopra.java.patterns.model.dao.MemoryPersonaDAO;
import com.sopra.java.patterns.model.entities.Clasroom;
import com.sopra.java.patterns.model.entities.LineaDeLog;
import com.sopra.java.patterns.model.entities.Persona;

public class Factory {
	
	private static IDao<Clasroom> miAulaDao;
	private static IMultipleDao<LineaDeLog, Integer> miLogDao;
	private static IMultipleDao<Persona, String> miPersonaDao;
	private static IMultipleDao<Persona, String> miAlumnoDao;
	
	public static IDao<Clasroom> getDaoDeAula(){
		if(miAulaDao == null) {
			miAulaDao = new MemoryMapDAO(new HashMap<String, Clasroom>());
		}
		return miAulaDao;
	}
	
	public static IMultipleDao<LineaDeLog, Integer> getDaoDeLog(){
		if(miLogDao == null) {
			miLogDao = new MemoryListLogDAO(new ArrayList<>());
		}
		return miLogDao;
	}
	public static IMultipleDao<Persona, String> getPersonaDao(){
		if(miPersonaDao == null) {
			miPersonaDao = new MemoryPersonaDAO(new LinkedHashMap<String, Persona>());
		}
		return miPersonaDao;
	}
	
	/*
	public static IDaoPersonas getDaoDePersonas() {
		return new MemoryPersonaDAO(new HashMap<String, Persona>());
	}*/
}
