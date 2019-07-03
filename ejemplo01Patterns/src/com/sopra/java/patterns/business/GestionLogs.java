package com.sopra.java.patterns.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sopra.java.patterns.Factory;
import com.sopra.java.patterns.model.dao.IGenericDao;
import com.sopra.java.patterns.model.dao.IMultipleDao;
import com.sopra.java.patterns.model.entities.LineaDeLog;

public class GestionLogs {
	//private IGenericDao<LineaDeLog> miDaoDeLogs = Factory.getDaoDeLog();
	private IMultipleDao<LineaDeLog, Integer> logDao;
	public GestionLogs() {
		logDao = Factory.getDaoDeLog();
	}
	
	public List<LineaDeLog> getLog(){		
		return new ArrayList<LineaDeLog>(logDao.list());
	}
	/*
	public Collection<LineaDeLog> getLogs(){
		return miDaoDeLogs.list();
	}*/
}
