package com.acing.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.acing.eventos.Evento;
import com.acing.serial.SerializadorCSV;
import com.acing.serial.SerializadorDate;
import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.OutputType;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	System.out.println("Comenzando la practica de Datos Deportivos");
	
	// Creamos una coleccion de Eventos, leemos el CSV y lo convertimos a 
	// Eventos.
	Collection<Evento> eventos;
	String rutaArchivoCSV = "datos/SP1.csv";
	eventos = SerializadorCSV.getEventos(rutaArchivoCSV);
	for (Evento evento : eventos) {
		System.out.println(evento);
	}
	
	
	// Convertir los Eventos a un fichero JSON.
	String rutaArchivoJson = "datos/eventos.json";

	// Opcion 1 - Almacenar en eventos.json linea a linea la coleccion de eventos.
//	guardarColeccionAJsonPorLineas(eventos, rutaArchivoJson);

	// Opcion 2 - Almacenar en eventos.json un string completo con la 
	// coleccion de eventos, en vez de linea a linea. MEJOR OPCION que 1.
	
		// Los Eventos creados los vamos a convertir a JSON.
		// y descompactamos su formato mediante prettyPrint.
	Json json = new Json(OutputType.json);
	String eventosJson = json.prettyPrint(eventos);
//	System.out.println("EventosJson" + eventosJson);	
	guardarColeccionAJsonStringCompleto(eventosJson, rutaArchivoJson);
	
	
	// Vamos a convertir el fichero JSON a Objetos

//	Collection<Evento> listaEventosJson = new ArrayList<>();
//	listaEventosJson = getEventosFromJson(rutaArchivoJson);
	
//	for (Evento evento : listaEventosJson) {
//		System.out.println("Evento :" + evento);
//	}

	
	}

	private static Collection<Evento> getEventosFromJson(String rutaArchivoJson) {
		Collection<Evento> eventosTraidos = new ArrayList<>();
		Json json = new Json();
		json.setSerializer(Date.class, new SerializadorDate());
		try {
			BufferedReader reader = new BufferedReader(
									new InputStreamReader(
									new FileInputStream(rutaArchivoJson), "UTF-8"));
			String linea;
			
			while ((linea = reader.readLine()) != null) {
			
				eventosTraidos.add(json.fromJson(Evento.class, linea));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventosTraidos;
	}

	private static void guardarColeccionAJsonStringCompleto(String cadena, String rutaArchivoJson) {
		Json json = new Json(OutputType.json);
		json.setSerializer(Date.class, new SerializadorDate());
		try {
			BufferedWriter writer = new BufferedWriter(
									new OutputStreamWriter(
									new FileOutputStream(rutaArchivoJson), "UTF-8"));
			writer.write(cadena);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void guardarColeccionAJsonPorLineas(Collection<Evento> eventos,
													String rutaArchivoJson) {
		Json json = new Json();
		json.setSerializer(Date.class, new SerializadorDate());
		// Vamos a guardar eventos en el fichero eventos.json
		try {
			BufferedWriter writer = new BufferedWriter(
									new OutputStreamWriter(
									new FileOutputStream(rutaArchivoJson),"UTF-8"));
			
			for (Evento evento : eventos) {
				writer.write(json.toJson(evento));
				writer.newLine();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
