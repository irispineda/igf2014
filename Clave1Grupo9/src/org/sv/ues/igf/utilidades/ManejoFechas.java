package org.sv.ues.igf.utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ManejoFechas {
	
	// Metodos de la clase

	// Clase que se encarga de convertir la fecha de string a Date
	public static Date ParseFecha(String fecha) {
		// Formato de fecha a�o/mes/dia
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd"); 
		Date date = null;
		try {
			date = formatoFecha.parse(fecha);
		} catch (Exception e) {
			// Manejo de excepcion
		}
		return date;
	}
	
}
