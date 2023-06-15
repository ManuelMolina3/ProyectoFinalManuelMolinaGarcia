package com.salesianostriana.dam.proyectofinal.excepcion;

public class ExcepcionCarritoVacio extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionCarritoVacio(String message) {
		
		super("No ha añadido ningun material a esta reforma");

	}
	
	

}
