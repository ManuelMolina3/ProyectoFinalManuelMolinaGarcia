package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectofinal.model.Trabajador;

@Controller
public class TrabajadorController {

	@GetMapping("/trabajador")
	public String showTrabajadorForm (Model model) {
		Trabajador trabajador= new Trabajador ();
		model.addAttribute("trabajadorForm", trabajador);
		
		return "trabajadorForm";
	}
	
	@PostMapping("/addTrabajador")
	public String submitTrabajador(@ModelAttribute("trabajadorForm") Trabajador trabajador,  Model model) {
		model.addAttribute("trabajador", trabajador);
		return "tablaTrabajadores";
	}
}
