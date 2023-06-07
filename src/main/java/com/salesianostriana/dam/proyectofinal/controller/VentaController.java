package com.salesianostriana.dam.proyectofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinal.excepcion.ExcepcionCarritoVacio;
import com.salesianostriana.dam.proyectofinal.model.Reforma;
import com.salesianostriana.dam.proyectofinal.model.Venta;
import com.salesianostriana.dam.proyectofinal.service.MaterialesService;
import com.salesianostriana.dam.proyectofinal.service.VentaService;

@Controller
@RequestMapping("/admin")
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
	@ModelAttribute("totalCarrito")
	public Double mostrartotalCarrito () {   	
		return servicioDeVenta.totalCarrito();
	}
	@PostMapping("/carrito/finalizarCompra")
	public String finalizarCompra(@AuthenticationPrincipal Reforma reforma) {
		servicioDeVenta.crearReformaMate(reforma);
		return "reformaFinalizada";
	}
	
	@ModelAttribute("totalReformas")
	private double calcularTotalRefomas (List<Venta> ventas) {
	    double total = 0.0;
	    for (Venta venta : ventas) {
	        total += venta.getTotal();
	    }
	    return total;
	}
	@GetMapping("/venta")
	public String listVenta(Model model) {
		model.addAttribute("listaVentas", servicioDeVenta.findAll());
		return "admin/listVenta";
	}
}
