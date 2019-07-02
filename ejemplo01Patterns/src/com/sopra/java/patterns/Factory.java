package com.sopra.java.patterns;

import java.util.ArrayList;
import java.util.HashMap;

import com.sopra.java.patterns.model.dao.IDao;
import com.sopra.java.patterns.model.dao.MemoryListLogDAO;
import com.sopra.java.patterns.model.dao.MemoryMapDAO;
import com.sopra.java.patterns.model.entities.Clasroom;
import com.sopra.java.patterns.model.entities.LineaDeLog;

public class Factory {
	public static IDao<Clasroom> getDaoDeAula(){		
		return new MemoryMapDAO(new HashMap<String, Clasroom>());
	}
	
	public static IDao<LineaDeLog> getDaoDeLog(){
		return new MemoryListLogDAO(new ArrayList<>());
	}
}
