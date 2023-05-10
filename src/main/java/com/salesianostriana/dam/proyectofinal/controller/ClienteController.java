package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.salesianostriana.dam.proyectofinal.model.Cliente;
import com.salesianostriana.dam.proyectofinal.service.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteServicio;

	public ClienteController(ClienteService clienteServicio) {

		this.clienteServicio = clienteServicio;
	}

	@GetMapping("/listaClientes")
	public String listaClientes(Model model) {
		model.addAttribute("listaClientes", clienteServicio.findAll());
		return "listaClientes";
	}

	@GetMapping("/addCliente")
	public String mostrarFormClientes(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "clienteForm";
	}

	@PostMapping("/addCliente/submit")
	public String procesarFormClientes(@ModelAttribute("cliente") Cliente cliente) {
		clienteServicio.add(cliente);
		return "redirect:/listaClientes";
	}

	@GetMapping("/editarCliente/{id}")
	public String mostrarFormEdicionCliente(@PathVariable("id") long id, Model model) {
		Cliente clienteEditar = clienteServicio.findById(id);
		if (clienteEditar != null) {
			model.addAttribute("cliente", clienteEditar);
			return "editFormClientes";
		} else {
			return "redirect:/listaClientes";
		}
	}

	@PostMapping("/editarCliente/submit")
	public String procesarFormEditCliente(@ModelAttribute("cliente") Cliente cliente) {
		clienteServicio.edit(cliente);
		return "redirect:/listaClientes";
	}

	@GetMapping("/borrarCliente/{id}")
	public String deleteCliente(@PathVariable("id") long id) {
		clienteServicio.deleteById(id);
		return "redirect:/listaClientes";
	}

}
