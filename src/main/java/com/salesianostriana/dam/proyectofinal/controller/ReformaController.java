package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.salesianostriana.dam.proyectofinal.model.Reforma;
import com.salesianostriana.dam.proyectofinal.service.ReformaService;

@Controller
public class ReformaController {

	@Autowired
	private ReformaService reformaServicio;

	public ReformaController(ReformaService reformaServicio) {
		this.reformaServicio = reformaServicio;
	}

	@GetMapping("/listaReformas")
	public String listaReformas(Model model) {
		model.addAttribute("listaReformas", reformaServicio.findAll());
		return "listaReformas";
	}

	@GetMapping("/addReforma")
	public String mostrarFormReforma(Model model) {
		model.addAttribute("reforma", new Reforma());
		return "ReformaForm";
	}

	@PostMapping("/addReforma/submit")
	public String procesarFormReforma(@ModelAttribute("reforma") Reforma reforma) {
		reformaServicio.add(reforma);
		return "redirect:/listaReformas";
	}

	@GetMapping("/editarReforma/{id}")
	public String mostrarFormEdicionReforma(@PathVariable("id") long id, Model model) {
		Reforma reformaEditar = reformaServicio.findById(id);
		if (reformaEditar != null) {
			model.addAttribute("reforma", reformaEditar);
			return "editFormReforma";
		} else {
			return "redirect:/listaReformas";
		}
	}

	@PostMapping("/editarReforma/submit")
	public String procesarFormEditReforma(@ModelAttribute("reforma") Reforma reforma) {
		reformaServicio.edit(reforma);
		return "redirect:/listaReformas";
	}

	@GetMapping("/borrarReforma/{id}")
	public String deleteReformas(@PathVariable("id") long id, Model model) {
		reformaServicio.deleteById(id);
		return "redirect:/listaReformas";
	}

}
