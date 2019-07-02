package com.sopra.java.patterns.business;

import java.util.Collection;

import com.sopra.java.patterns.Factory;
import com.sopra.java.patterns.model.dao.IDao;
import com.sopra.java.patterns.model.entities.LineaDeLog;

public class GestionLogs {
	private IDao<LineaDeLog>miDaoDeLogs = Factory.getDaoDeLog();
	
	public Collection<LineaDeLog> getLogs(){
		return miDaoDeLogs.list();
	}
}
