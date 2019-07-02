package com.sopra.java.patterns.model.entities;

public class LineaDeLog {
	private Nivel nivel;
	private String mensaje;
	private String nombre;
	
	public LineaDeLog(Nivel nivel, String mensaje, String nombre) {
		super();
		this.nivel = nivel;
		this.mensaje = mensaje;
		this.nombre = nombre;
	}
	
	public LineaDeLog() {
		super();		
	}

	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	
	
}
