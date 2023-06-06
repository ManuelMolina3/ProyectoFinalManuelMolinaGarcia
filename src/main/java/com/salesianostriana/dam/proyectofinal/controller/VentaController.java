package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.proyectofinal.service.MaterialesService;
import com.salesianostriana.dam.proyectofinal.service.VentaService;

@Controller
public class VentaController {

	@Autowired
	private VentaService servicioDeVenta;
	
	@Autowired
	private MaterialesService servicioMateriales;

	public VentaController(VentaService servicioDeVenta, MaterialesService servicioMateriales) {
		this.servicioDeVenta = servicioDeVenta;
		this.servicioMateriales = servicioMateriales;
	}
	@GetMapping ("/carrito")
	public String mostrarCarrito(Model model){
			model.addAttribute("productos", servicioDeVenta.getMaterialesInCart());
			return "carrito";
		
	}
	@GetMapping ("/productoACarrito/{id}")
	public String productoACarrito (@PathVariable("id") Long id, Model model) {
		servicioDeVenta.addMateriales(servicioMateriales.findById(id));	 		 	
		return "redirect:/carrito";
	}
	
	
}
