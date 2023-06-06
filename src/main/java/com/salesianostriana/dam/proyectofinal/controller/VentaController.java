package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.proyectofinal.excepcion.ExcepcionCarritoVacio;
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
	public String mostrarCarrito(Model model) throws ExcepcionCarritoVacio{
		if(servicioDeVenta.getMaterialesInCart().isEmpty()) {
			throw new ExcepcionCarritoVacio ("Sin materiales en la reforma");
		}else {
			model.addAttribute("productos", servicioDeVenta.getMaterialesInCart());
			return "carrito";
		}
		
	}
	@GetMapping ("/productoACarrito/{id}")
	public String addProductoACarrito (@PathVariable("id") Long id, Model model) {
		servicioDeVenta.addMateriales(servicioMateriales.findById(id));	 		 	
		return "redirect:/carrito";
	}
	@GetMapping("/borrarProducto/{id}")
	public String removeProducto (@PathVariable("id") Long id, Model model) {
		servicioDeVenta.removeMateriales(servicioMateriales.findById(id));
		return "redirect:/carrito";
	}
	
	
}
