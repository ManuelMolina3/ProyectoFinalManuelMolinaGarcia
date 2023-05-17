package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinal.model.Cliente;
import com.salesianostriana.dam.proyectofinal.search.SearchCliente;
import com.salesianostriana.dam.proyectofinal.service.ClienteService;

@Controller
@RequestMapping("/admin")
public class ClienteController {

	@Autowired
	private ClienteService clienteServicio;

	public ClienteController(ClienteService clienteServicio) {

		this.clienteServicio = clienteServicio;
	}

	@GetMapping("/listaClientes")
	public String listaClientes(Model model) {
		model.addAttribute("listaClientes", clienteServicio.findAll());
		model.addAttribute("SearchCliente", new SearchCliente());
		return "/admin/listaClientes";
	}

	@GetMapping("/addCliente")
	public String mostrarFormClientes(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "/admin/clienteForm";
	}

	@PostMapping("/addCliente/submit")
	public String procesarFormClientes(@ModelAttribute("cliente") Cliente cliente) {
		clienteServicio.add(cliente);
		return "redirect:/admin/listaClientes";
	}

	@GetMapping("/editarCliente/{id}")
	public String mostrarFormEdicionCliente(@PathVariable("id") long id, Model model) {
		Cliente clienteEditar = clienteServicio.findById(id);
		if (clienteEditar != null) {
			model.addAttribute("cliente", clienteEditar);
			return "/admin/editFormClientes";
		} else {
			return "redirect:/admin/listaClientes";
		}
	}

	@PostMapping("/editarCliente/submit")
	public String procesarFormEditCliente(@ModelAttribute("cliente") Cliente cliente) {
		clienteServicio.edit(cliente);
		return "redirect:/admin/listaClientes";
	}

	@GetMapping("/borrarCliente/{id}")
	public String deleteCliente(@PathVariable("id") long id) {
		clienteServicio.deleteById(id);
		return "redirect:/admin/listaClientes";
	}

	@PostMapping("/buscarCliente")
	public String searchProducto(@ModelAttribute("searchForm") SearchCliente searchCliente, Model model) {
		model.addAttribute("clientes", clienteServicio.findByCliente(searchCliente.getSearchCliente()));

		return "/admin/listaClientes";
	}

}
