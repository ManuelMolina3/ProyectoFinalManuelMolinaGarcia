package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {

		
		@GetMapping("/")
		public String index() {
			return "/admin/listaMateriales";
		}

}
