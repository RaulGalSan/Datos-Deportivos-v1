package com.acing.eventos;

import java.util.Collection;
import java.util.Date;

public class Evento {

	private Participante local;
	private Participante visitante;
	private Date fechaEvento;
	private String resultado;
	
	private Collection<Suceso> sucesos;

	public Participante getLocal() {
		return local;
	}

	public void setLocal(Participante local) {
		this.local = local;
	}

	public Participante getVisitante() {
		return visitante;
	}

	public void setVisitante(Participante visitante) {
		this.visitante = visitante;
	}

	public Date getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Collection<Suceso> getSucesos() {
		return sucesos;
	}

	public void setSucesos(Collection<Suceso> sucesos) {
		this.sucesos = sucesos;
	}

	public Evento(Participante local, Participante visitante, Date fechaEvento) {
		super();
		this.local = local;
		this.visitante = visitante;
		this.fechaEvento = fechaEvento;
	}
	
	public Evento() {
		
	}

	@Override
	public String toString() {
		return "El " + getFechaEvento() + " jugaron : "+ getLocal() + " - " + visitante + 
				" --> " + resultado + "\n";
	}
	
	
}
