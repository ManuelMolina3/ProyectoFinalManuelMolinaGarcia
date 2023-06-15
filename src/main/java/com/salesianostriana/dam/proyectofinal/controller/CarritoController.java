package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinal.excepcion.ExcepcionCarritoVacio;
import com.salesianostriana.dam.proyectofinal.model.Reforma;
import com.salesianostriana.dam.proyectofinal.service.MaterialesService;
import com.salesianostriana.dam.proyectofinal.service.VentaService;

@Controller
@RequestMapping("/admin")
public class CarritoController {
	
	@Autowired
	private MaterialesService materialesServicio;
	
	@Autowired
	private VentaService servicioDeVenta;
	
	@GetMapping("/materialesRefo")
	public String mostrarMateriales(Model model) {
		model.addAttribute("listaMaterialesRe", materialesServicio.findAll());
		return "/admin/listaParaAniadir";
	}
	@GetMapping ("/carrito")
	public String mostrarCarrito(Model model) throws ExcepcionCarritoVacio{
		if(servicioDeVenta.getMaterialesInCart().isEmpty()) {
			throw new ExcepcionCarritoVacio ("Sin materiales en la reforma");
		}else {
			model.addAttribute("materiales", servicioDeVenta.getMaterialesInCart());
			return "/admin/carrito";
		}
		
	}
	@GetMapping ("/materialACarrito/{id}")
	public String addMaterialACarrito (@PathVariable("id") Long id, Model model) {
		servicioDeVenta.addMateriales(materialesServicio.findById(id));	 		 	
		return "redirect:/admin/carrito";
	}
	@GetMapping("/borrarMaterialRe/{id}")
	public String removeMateriales (@PathVariable("id") Long id, Model model) {
		servicioDeVenta.removeMateriales(materialesServicio.findById(id));
		return "redirect:/admin/carrito";
	}
	@ModelAttribute("totalCarrito")
	public Double mostrartotalCarrito () {   	
		return servicioDeVenta.totalCarrito();
	}
	@GetMapping("/carrito/finalizarCompra")
	public String finalizarCompra(@AuthenticationPrincipal Reforma reforma) {
		servicioDeVenta.crearReformaMate(reforma);
		return "/admin/reformaFinalizada";
	}
	@GetMapping("/venta")
	public String listVenta(Model model) {
		model.addAttribute("listaVentas", servicioDeVenta.findAll());
		return "admin/listVenta";
	}


}
