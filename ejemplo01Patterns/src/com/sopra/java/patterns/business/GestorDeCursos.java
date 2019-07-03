package com.sopra.java.patterns.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sopra.java.patterns.model.entities.Alumno;
import com.sopra.java.patterns.model.entities.Clasroom;
import com.sopra.java.patterns.model.entities.Profesor;
import com.sopra.java.patterns.model.entities.Puesto;

import jdk.nashorn.internal.runtime.ListAdapter;


public class GestorDeCursos {
	private GestionAulas gestorDeAulas;
	private GestionLogs gestorDeLogs;
	private GestionPersonas gestorDePersonas;
	
	public GestorDeCursos() {
		gestorDeAulas = new GestionAulas();
		gestorDeLogs = new GestionLogs();
		gestorDePersonas = new GestionPersonas();		
	}
	public void crearCurso(
			String nombre, Boolean proyector,
			Boolean pizarra, Map<String, String> alumnos, 
			String nombreProfesor, String dniProfesor) throws Exception {
		
		gestorDeAulas.crearAula(nombre, proyector, pizarra, alumnos.size());
		gestorDePersonas.crearProfesor(dniProfesor, nombreProfesor);
		
		Collection<Alumno> alumnosGuardados = almacenarAlumnosDesdeElGestorDeAlumnos(alumnos);
		List<Clasroom> aulas = new ArrayList<>(gestorDeAulas.dameAulas(Arrays.asList(nombre)));
		
		if(aulas.size() == 1) {
			Clasroom aula = aulas.get(0);
			Iterator<Alumno> recorreAlumnos = alumnosGuardados.iterator();
			Iterator<Puesto> recorrePuestos = aula.getPuestosDeAlumnos().iterator();
			while(recorreAlumnos.hasNext() && recorrePuestos.hasNext()) {
				Puesto puesto = recorrePuestos.next();
				puesto.setPersona(recorreAlumnos.next());
			}
			Set<Profesor> listaProfesores = gestorDePersonas.listaProfesores();
			Profesor profesorQueBusco = new Profesor(null, dniProfesor);
			for(Profesor profe : listaProfesores) {
				if(profe.equals(profesorQueBusco)) {
					aula.getPuestoDeProfesor().setPersona(profe);
				}
			}			
		}else {
			throw new Exception("No existe el aula");
		}
	}
//	private Collection<Alumno> almacenarAlumnos(Map<String, String> alumnos) {
//		//TODO: Almacenar los alumnos del map que me llega y los devuelve creados
//		Set<String> dnis = alumnos.keySet();
//		Set<Alumno> alumnosEncontrados = new HashSet<Alumno>();
//		Set<Alumno> alumnosClavesDeBusqueda = new HashSet<Alumno>();
//		for(String dni : dnis) {
//			
//			gestorDePersonas.crearAlumno(dni, alumnos.get(dni));
//			alumnosClavesDeBusqueda.add(new Alumno(null, dni));
//		}	
//		Set<Alumno> alumnosGuardados = gestorDePersonas.listaAlumnos();
//		//alumnosGuardados.stream().filter(arg0)
//		for(Alumno alumno : alumnosGuardados) {
//			
//		}
//		return null;
//	}
	private Collection<Alumno> almacenarAlumnosDesdeElGestorDeAlumnos(Map<String, String> alumnos){
		Set<Alumno> listaAlumnos = gestorDePersonas.listaAlumnos();
		Collection<Alumno> misAlumnos = new HashSet<Alumno>();
		for(String dni : alumnos.keySet()) {
			gestorDePersonas.crearAlumno(dni, alumnos.get(dni));
		}
		for(Alumno alumno : listaAlumnos) {
			if(alumnos.containsKey(alumno.getDni())) {
				misAlumnos.add(alumno);
			}
		}
		return misAlumnos;
	}
}
