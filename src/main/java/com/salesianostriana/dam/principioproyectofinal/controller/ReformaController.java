package com.salesianostriana.dam.principioproyectofinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.principioproyectofinal.model.Reforma;

@Controller
public class ReformaController {

	@GetMapping("/reforma")
	public String showReformaForm (Model model) {
		Reforma reforma= new Reforma ();
		model.addAttribute("reformaForm", reforma);
		
		return "reformaForm";
	}
	
	@PostMapping("/addReforma")
	public String subitReforma (@ModelAttribute("reformaForm") Reforma reforma, Model model) {
		model.addAttribute("reforma", reforma);
		return "tablaReformas";
	}
}
