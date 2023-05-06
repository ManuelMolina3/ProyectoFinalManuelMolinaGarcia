package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

<<<<<<< HEAD:src/main/java/com/salesianostriana/dam/principioproyectofinal/controller/ClienteController.java
import com.salesianostriana.dam.principioproyectofinal.model.Cliente;
import com.salesianostriana.dam.principioproyectofinal.service.ClienteService;
=======
import com.salesianostriana.dam.proyectofinal.model.Cliente;
>>>>>>> 9d45bf5b10560d88c16016a1916c1320749f5891:src/main/java/com/salesianostriana/dam/proyectofinal/controller/ClienteController.java

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteServicio;
	
	@GetMapping("/listaCliente")
	public String listadoClientes(Model model) {
		model.addAttribute("listaClientes", clienteServicio.findAll());
		return "listaClientes";
	}
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
