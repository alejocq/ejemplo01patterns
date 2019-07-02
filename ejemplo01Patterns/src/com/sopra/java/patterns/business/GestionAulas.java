package com.sopra.java.patterns.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import com.sopra.java.patterns.Factory;
import com.sopra.java.patterns.model.dao.IDao;
import com.sopra.java.patterns.model.entities.Clasroom;
import com.sopra.java.patterns.model.entities.LineaDeLog;
import com.sopra.java.patterns.model.entities.Nivel;
import com.sopra.java.patterns.model.entities.Puesto;

public class GestionAulas {
	private IDao<Clasroom> miDaoDeAulas = Factory.getDaoDeAula();
	private IDao<LineaDeLog>miDaoDeLogs = Factory.getDaoDeLog(); //Factory.
	/*
	public GestionAulas(IDao<Clasroom> miDaoDeAulas, IDao<LineaDeLog> miDaoDeLogs) {
		super();
		this.miDaoDeAulas = miDaoDeAulas;
		this.miDaoDeLogs = miDaoDeLogs;
	}*/
	public Clasroom crearAula(String nombre, Boolean proyector, Boolean pizarra, Integer alumnos) {
		Clasroom aula = new Clasroom();
		aula.setNombre(nombre);
		aula.setPizarra(pizarra);
		aula.setProyector(proyector);
		Collection<Puesto> puestosDeAlumnos = new HashSet<>();
		
		for(int i = 0; i < alumnos; i++) {
			puestosDeAlumnos.add(new Puesto());
		}
		aula.setPuestoDeProfesor(new Puesto());
		aula.setPuestosDeAlumnos(puestosDeAlumnos);
		miDaoDeAulas.insert(aula);
		miDaoDeLogs.insert(new LineaDeLog(Nivel.INFO, "Aula agregada", "log de aulas"));
		return aula;
	}
	public Collection<Clasroom> dameAulas(List<String> nombresDeAulas){
		List<Clasroom> listaDeAulas = new ArrayList<>();
		for(int i = 0; i<nombresDeAulas.size(); i++) {
			Clasroom aulaABuscar = new Clasroom();
			aulaABuscar.setNombre(nombresDeAulas.get(i));
			Collection<Clasroom> aula = miDaoDeAulas.search(aulaABuscar);
			return aula;
		}
		return null;		
	}
}
