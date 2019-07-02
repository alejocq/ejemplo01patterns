package com.sopra.java.patterns.business;

import com.sopra.java.patterns.Factory;
import com.sopra.java.patterns.model.dao.IDao;
import com.sopra.java.patterns.model.dao.IDaoPersonas;
import com.sopra.java.patterns.model.entities.LineaDeLog;
import com.sopra.java.patterns.model.entities.Nivel;
import com.sopra.java.patterns.model.entities.Persona;

public class GestionPersonas {
	private IDaoPersonas miDaoDePersonas = Factory.getDaoDePersonas();
	private IDao<LineaDeLog>miDaoDeLogs = Factory.getDaoDeLog();
	
	public Persona crearAlumno(String dni, String nombre, Boolean profesor) {
		Persona alumno = new Persona();
		alumno.setDni(dni);
		alumno.setNombre(nombre);
		alumno.setEsProfesor(profesor);
		miDaoDePersonas.insert(alumno);
		if(profesor) {
			miDaoDeLogs.insert(new LineaDeLog(Nivel.INFO, "Profesor agregado", "log de profesores"));
			return alumno;
		}		
		miDaoDeLogs.insert(new LineaDeLog(Nivel.INFO, "Alumno agregado", "log de alumnos"));
		return alumno;
		
	}
	
	
}
