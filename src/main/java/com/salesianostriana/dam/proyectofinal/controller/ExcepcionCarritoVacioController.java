package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.salesianostriana.dam.proyectofinal.excepcion.ExcepcionCarritoVacio;

@ControllerAdvice
public class ExcepcionCarritoVacioController {
	
	@ExceptionHandler (ExcepcionCarritoVacio.class)
	public String excepcionDeCarrito (Model model, ExcepcionCarritoVacio ecv) {
		
		model.addAttribute("excepcion", ecv);
		return "errorEnCarrito";
	}
	

}
