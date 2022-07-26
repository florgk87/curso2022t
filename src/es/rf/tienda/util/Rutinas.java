package es.rf.tienda.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Rutinas {

	private static final String DATE_PATTERN = "dd/MM/yyyy";
	
	
	public static Calendar convierteACalendar(String fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(fecha));
		} catch (ParseException e) {
			return null;
		}
		return calendar;
	}
	
	public static String convierteAString(Calendar fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(fecha.getTime());
	}
	
	public static String addCampo(String salida, String nombreCampo, double valor, String separador) {
		if (valor>0 ) {
			salida = Rutinas.addSalidaSencilla(salida,nombreCampo,"'" + (int)valor,separador);
		}
		return salida;
	}
	
	public static String addCampo(String salida, String nombreCampo, String valor, String separador) {
		if (valor!=null && valor.compareTo("")!=0) {
			salida = Rutinas.addSalidaSencilla(salida,nombreCampo,"'" + valor + "'",separador);
		}
		return salida;
	}
	
	public static String addSalida(String salida, String nombreCampo, int valor, String separador) {
		return addSalidaSencilla(salida,nombreCampo,""+valor,separador);
	}	
	public static String addSalida(String salida, String nombreCampo, double valor, String separador) {
		return addSalidaSencilla(salida,nombreCampo,""+valor,separador);
	}	
	public static String addSalida(String salida, String nombreCampo, long valor, String separador) {
		return addSalidaSencilla(salida,nombreCampo,""+valor,separador);
	}	
	public static String addSalida(String salida, String nombreCampo, String valor, String separador) {
		return addSalidaSencilla(salida,nombreCampo,"'"+valor+"'",separador);
	}	
	
	
	public static String addSalidaSencilla(String salida, String nombreCampo, String valor, String separador) {
		if (salida.length()>0) 
			salida+= " " + separador + " ";
			if (nombreCampo !=null && nombreCampo.compareTo("")>0)
					salida +=nombreCampo + " = "; 			
			salida += valor;
			return salida;
	}


}
