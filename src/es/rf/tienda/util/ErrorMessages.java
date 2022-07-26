package es.rf.tienda.util;


/* *****************************************************
 * NOMBRE: ErrorMessages.java
 * 
 * DESCRIPCION:  
 * 			Clase con los String que contienen los mensajes de error 
 * 			especificados por las reglas de negocio.
 * 
 *  @version	Enero 2016
 *  
 *  @author 	Miguel Garcia
 *  
 *  *****************************************************/
public class ErrorMessages {
	
	
		
	/**
	 * Codigo de producto
	 */
	public final static String PROERR_001 = "Formato codigo erroneo";
	public final static String PROERR_002 = "Longitud de codigo erroneo";
	
	/**
	 * Campo con longitud erronea
	 */
	public final static String PROERR_003 = "La longitud de ? ha de estar entre ? y ?";
	
	/**
	 * Campo precio con rango erroneo
	 */
	public final static String PROERR_004 = "El rango de ? ha de estar entre ? y ?";

	/**
	 * Campo Fecha debe ser <=hoy
	 */
	public final static String PROERR_005 = "La fecha ingresada debe ser mayor o igual a hoy";

	/**
	 * Campo Fecha Desactivación debe ser <=hoy
	 */
	public final static String PROERR_006 = "La fecha ingresada debe ser mayor o igual a la Fecha de Activación";
	/**
	 * Campo Pais inexistente
	 */
	public final static String PROERR_007 = "El pais ingresado no existe";

	/**
	 * Campo Categoría inexistente
	 */
	public final static String PROERR_008 = "La categoría ingresada no existe";

	/**
	 * Campo Correo electrónico ya existen
	 */
	public final static String PROERR_009 = "El correo electrónico ingresado ya existe";
	/**
	 * Campo Contraseña con formato erróneo2
	 */
	public final static String PROERR_010 = "La contraseña debe contener como mínimo, una letra mayúscula, una letra minúscula,  un carácter especial, y un número";
	/**
	 * Campo Contraseña con formato erróneo3
	 */
	public final static String PROERR_011 = "El nombre de usuario no puede formar parte de la contraseña";
		
	/**
	 * Campo Tipo de usuario inválido
	 */
	public final static String PROERR_012 = "El Tipo de usuario ingresado no es válido";

	/**
	 * Campo DNI inválido
	 */
	public final static String PROERR_013 = "El DNI ngresado no es válido";

	/**
	 * Campo Fecha inválida
	 */
	public final static String PROERR_014 = "La fecha de Alta/Confirmación debe ser igual a hoy";
		
	/**
	 * Campo ID Usuario inválido (Existir en Usuarios, 
con rol cliente
	 */
	public final static String PROERR_015 = "El ID de Usuario ingresado es erróneo";

	/**
	 * Campo ID Producto inexistente o no disponible (Existir en productos
 y con disponible > 0
	 */
	public final static String PROERR_016 = "El ID de Producto ? no existe"; 

	/**
	 * Campo ID Producto no disponible (Existir en productos
 y con disponible > 0
	 */
	public final static String PROERR_017 = "No hay mas Stock del producto seleccionado";

	/**
	 * Campo car_Cantidad Mayor que 0 y =< disponible
	 */
	public final static String PROERR_018 = "La cantidad ingresada debe ser > 0";

	/**
	 * Campo car_Cantidad  =< disponible
	 */
	public final static String PROERR_019 = "La cantidad ingresada supera el Disponible para ese Producto";

	/**
	 * Campo Estado no es válido
	 */
	public final static String PROERR_020 = "El Estado no es válido";

	
	/**
	 * Error en update
	 */
	public final static String PROERR_027 = "Error en Update, por favor chequee los campo e intente nuevamente";	

	
	
	public static String mensajes(String mensaje, String[] datos) {
		String salida="";
		int contador=0;
		for (int a=0;a <mensaje.length();a++) {
			if (mensaje.charAt(a)=='?') {
				if (contador<=datos.length)
					salida +=datos[contador++];
			}
			else
				salida +=mensaje.charAt(a);
		}
		return salida;
	}
	
}
