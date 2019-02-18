package com.acing.serial;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.acing.eventos.Evento;
import com.acing.eventos.Participante;

public class SerializadorCSV {

	public static Collection<Evento> getEventos(String rutaArchivo){
		Collection<Evento> eventosLeidos = new ArrayList<>();

		// Almacenare en buffer la entrada del archivo especificado.
		try {
			BufferedReader reader = new BufferedReader(
									new InputStreamReader(
									new FileInputStream(rutaArchivo),
									"UTF-8"));
			// Vamos a leer la primera linea del fichero .CSV (Las cabeceras)
			String linea = reader.readLine(); 
			
			// Mientras que no lleguemos a final de fichero (implica null)
			while ((linea = reader.readLine()) != null) {

				// añadimos a los eventos leidos un Evento mediante el metodo
				// deserializarEvento al cual le pasamos una linea.
				eventosLeidos.add(deserializarEvento(linea));
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return eventosLeidos;
	}

	private static Evento deserializarEvento(String linea) throws ParseException {
		
		// En un array de String metemos en cada 
		String[] campos = linea.split(",");
		String fechaString = campos[1];
		String localString = campos[2];
		String visitanteString = campos[3];
		String golesLocal = campos[4];
		String golesVisitante = campos[5];
		
		// Paso la fecha de tipo String a tipo Date con un parse.
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaEvento = sdf.parse(fechaString);
		
		// Creo objetos de cada atributo de la Clase Evento y les paso al
		// constructor su variable correspondiente.
		
		Participante local = new Participante(localString);
		Participante visitante = new Participante(visitanteString);
		
		// Pasar de String a Integer
		int golesLoc = Integer.parseInt(golesLocal);
		int golesVis = Integer.parseInt(golesVisitante);
		
		String resultado = golesLoc + " - " + golesVis;
		
		Evento miEvento = new Evento(local, visitante, fechaEvento);
		
		miEvento.setResultado(resultado);
		
		
		return miEvento;
	}
	
}
