package com.sopra.java.patterns;

import java.util.Arrays;
import java.util.Collection;

import com.sopra.java.patterns.business.GestionAulas;
import com.sopra.java.patterns.model.entities.Clasroom;

public class Lanzador {
	public static void main(String[] args) {
		GestionAulas gestionAulas = new GestionAulas();
		gestionAulas.crearAula("Kepler", true, true, 16);
		Collection<Clasroom> aulas = gestionAulas.dameAulas(Arrays.asList("Kepler", "real"));
		System.out.println(aulas);
		
	}
}
