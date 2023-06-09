package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {

		
		@GetMapping("/admin")
		public String accederComoAdmin() {
			return "redirect:/admin/listaClientes";
		}
		@GetMapping("/user")
		public String accederComoUser() {
			return "redirect:/user/listaParteTrabajador";
		}
		@GetMapping("/")
		public String accederPaginaPrincipal(){
			return "paginaPrincipal";
		}
		@GetMapping("/login")
		public String accederLogueo() {
			return "login";
		}
		
}
