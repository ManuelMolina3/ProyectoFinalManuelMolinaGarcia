package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectofinal.model.Cliente;

@Controller
public class ClienteController {

	@GetMapping("/cliente")
	public String showClienteForm (Model model) {
		Cliente cliente= new Cliente();
		model.addAttribute("clienteForm", cliente);
		
		return "clienteForm";
	}
	@PostMapping("/addCliente")
	public String submitCliente(@ModelAttribute("clienteForm") Cliente cliente, Model model) {
		model.addAttribute("cliente", cliente);
		
		return "tablaClientes";
	}
}
