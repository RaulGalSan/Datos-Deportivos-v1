package com.acing.eventos;

import java.util.HashMap;
import java.util.Map;

public class Participante {

	private static int identificador = 1;
	private int idParticipante;
	private String nombre;

	// La clase Map nos ayudara a no tener valores duplicados.
	// Map(K,V): <K> Tipo de Dato usado en el Mapa, <V> Tipo de Valores del Mapa.
	public static Map<String, Participante> mapaParticipantes = new HashMap<>();
	
	public static int getIdentificador() {
		return identificador;
	}
	public static void setIdentificador(int identificador) {
		Participante.identificador = identificador;
	}
	public int getIdParticipante() {
		return idParticipante;
	}
	public void setIdParticipante(int idParticipante) {
		this.idParticipante = idParticipante;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Participante() {
		
	}
	
	public Participante(String nombre) {
		this.idParticipante = identificador++;
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return nombre;
	}

	
	
}
