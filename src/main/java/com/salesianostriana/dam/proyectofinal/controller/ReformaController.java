package com.salesianostriana.dam.proyectofinal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinal.model.Reforma;
import com.salesianostriana.dam.proyectofinal.service.ClienteService;
import com.salesianostriana.dam.proyectofinal.service.ReformaService;
import com.salesianostriana.dam.proyectofinal.service.TrabajadorService;


@Controller
@RequestMapping("/admin")
public class ReformaController {

	@Autowired
	private ReformaService reformaServicio;
	
	@Autowired
	private TrabajadorService trabajadorServicio;
	
	@Autowired
	private ClienteService clienteServicio;

	public ReformaController(ReformaService reformaServicio) {
		this.reformaServicio = reformaServicio;
	}

	@GetMapping("/listaReformas")
	public String listaReformas(Model model) {
		model.addAttribute("listaReformas", reformaServicio.findAll());
		return "/admin/listaReformas";
	}

	@GetMapping("/addReforma")
	public String mostrarFormReforma(Model model) {
		model.addAttribute("reforma", new Reforma());
		model.addAttribute("jefesDeObra", trabajadorServicio.findAll());
		model.addAttribute("propietarios", clienteServicio.findAll());
		return "/admin/reformaForm";
	}

	@PostMapping("/addReforma/submit")
	public String procesarFormReforma(@ModelAttribute("reforma") Reforma reforma, Model model) {
		model.addAttribute("jefesDeObra", trabajadorServicio.findAll());
		model.addAttribute("propietarios", clienteServicio.findAll());
		reformaServicio.add(reforma);
		return "redirect:/admin/listaReformas";
	}

	@GetMapping("/editarReforma/{id}")
	public String mostrarFormEdicionReforma(@PathVariable("id") long id, Model model) {
		Optional <Reforma> reformaEditar = reformaServicio.findById(id);
		if (reformaEditar.isPresent()) {
			model.addAttribute("reforma", reformaEditar.get());
			model.addAttribute("jefesDeObra", trabajadorServicio.findAll());
			model.addAttribute("propietarios", clienteServicio.findAll());
			return "/admin/editFormReforma";
		} else {
			return "redirect:/admin/listaReformas";
		}
	}
	@PostMapping("/editarReforma/submit")
	public String procesarFormEditReforma(@ModelAttribute("reforma") Reforma reforma) {
		reformaServicio.edit(reforma);
		return "redirect:/admin/listaReformas";
	}

	@GetMapping("/borrarReforma/{id}")
	public String deleteReformas(@PathVariable("id") long id, Model model) {
		reformaServicio.deleteById(id);
		return "redirect:/admin/listaReformas";
	}
	

}
