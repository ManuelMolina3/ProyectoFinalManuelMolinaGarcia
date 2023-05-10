package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.salesianostriana.dam.proyectofinal.model.Trabajador;
import com.salesianostriana.dam.proyectofinal.service.TrabajadorService;

@Controller
public class TrabajadorController {

	@Autowired
	private TrabajadorService trabajadorServicio;

	public TrabajadorController(TrabajadorService trabajadorServicio) {
		
		this.trabajadorServicio = trabajadorServicio;
	}

	@GetMapping("/listaTrabajadores")
	public String listaTrabajadores(Model model) {
		model.addAttribute("listaTrabajadores", trabajadorServicio.findAll());
		return "listaTrabajadores";
	}

	@GetMapping("/addTrabajador")
	public String mostrarFormTrabajadores(Model model) {
		model.addAttribute("trabajador", new Trabajador());
		return "trabajadorForm";
	}

	@PostMapping("/addTrabajador/submit")
	public String procesarFormTrabajador(@ModelAttribute("trabajador") Trabajador trabajador) {
		trabajadorServicio.add(trabajador);
		return "redirect:/listaTrabajadores";
	}

	@GetMapping("/editarTrabajador/{id}")
	public String mostrarFormEdicionTrabajador(@PathVariable("id") long id, Model model) {
		Trabajador trabajadorEditar = trabajadorServicio.findById(id);
		if (trabajadorEditar != null) {
			model.addAttribute("trabajador", trabajadorEditar);
			return "editFormTrabajador";
		} else {
			return "redirect:/listaTrabajadores";
		}
	}

	@PostMapping("/editarTrabajador/submit")
	public String procesarFormEditTrabajador(@ModelAttribute("trabajador") Trabajador trabajador) {
		trabajadorServicio.edit(trabajador);
		return "redirect:/listaTrabajadores";
	}

	@GetMapping("/borrarTrabajadores/{id}")
	public String deleteTrabajadores(@PathVariable("id") long id, Model model) {
		trabajadorServicio.deleteById(id);
		return "redirect:/listaTrabajadores";
	}
}
