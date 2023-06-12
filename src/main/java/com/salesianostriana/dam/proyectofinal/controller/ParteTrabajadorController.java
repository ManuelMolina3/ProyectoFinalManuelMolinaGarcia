package com.salesianostriana.dam.proyectofinal.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinal.model.ParteTrabajador;
import com.salesianostriana.dam.proyectofinal.model.Reforma;
import com.salesianostriana.dam.proyectofinal.model.Trabajador;
import com.salesianostriana.dam.proyectofinal.service.ParteTrabajadorService;
import com.salesianostriana.dam.proyectofinal.service.ReformaService;
import com.salesianostriana.dam.proyectofinal.service.TrabajadorService;

@Controller
@RequestMapping("/user")
public class ParteTrabajadorController {

	@Autowired
	private ParteTrabajadorService parteTrabajadorServicio;

	@Autowired
	private TrabajadorService trabajadorServicio;

	@Autowired
	private ReformaService reformaServicio;

	public ParteTrabajadorController(ParteTrabajadorService parteTrabajadorServicio) {

		this.parteTrabajadorServicio = parteTrabajadorServicio;
	}

	@GetMapping("/listaParteTrabajador")
	public String listaParteTrabajador(Model model, @AuthenticationPrincipal Trabajador t) {
		model.addAttribute("listaPartes", parteTrabajadorServicio.findByTrabajador(t));
		return "/user/listaParteTrabajador";
	}

	@GetMapping("/addParte")
	public String mostrarFormPartes(Model model) {
		model.addAttribute("parteTrabajador", new ParteTrabajador());
		model.addAttribute("trabajadores", trabajadorServicio.findAll());
		model.addAttribute("reformas", reformaServicio.findAll());
		return "/user/parteTrabajadorForm";
	}

	@PostMapping("/addParte/submit")
	public String procesarFormPartes(@ModelAttribute("parteTrabajador") ParteTrabajador parteTrabajador, @AuthenticationPrincipal Trabajador t) {
		parteTrabajador.setTrabajador(t);
		parteTrabajadorServicio.add(parteTrabajador);
		return "redirect:/user/listaParteTrabajador";
	}

	@GetMapping("/editParte/{id_t}/{id_r}/{fe}")
	public String mostrarFormEdicionPartes(@PathVariable("id_t") Long trabajador_id,
			@PathVariable("id_r") Long reforma_id,
			@PathVariable("fe") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fecha, Model model) {
		ParteTrabajador parteTrabajadorEditar = parteTrabajadorServicio.findByParte(trabajador_id, reforma_id, fecha);
		if (parteTrabajadorEditar != null) {
			model.addAttribute("parteTrabajador", parteTrabajadorEditar);
			model.addAttribute("trabajadores", trabajadorServicio.findAll());
			model.addAttribute("reformas", reformaServicio.findAll());
			return "/user/editFormParteTrabajador";

		} else {
			return "redirect:/user/listaParteTrabajador";
		}
	}

	@PostMapping("/editarParte/submit")
	public String procesarFormEditPartes(@ModelAttribute("parteTrabajador") ParteTrabajador parteTrabajador, @AuthenticationPrincipal Trabajador t, Reforma r, LocalDate f) {
		parteTrabajador.setReforma(r);
		parteTrabajador.setTrabajador(t);
		parteTrabajador.getParteTrabajadorPK().setFecha(f);
		parteTrabajadorServicio.edit(parteTrabajador);
		return "redirect:/user/listaParteTrabajador";
	}

	@GetMapping("/borrarParte/{id_t}/{id_r}/{fe}")
	public String deleteCliente(@PathVariable("id_t") Long trabajador_id, @PathVariable("id_r") Long reforma_id,
			@PathVariable("fe") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fecha) {
		parteTrabajadorServicio.delete(parteTrabajadorServicio.findByParte(trabajador_id, reforma_id, fecha));
		return "redirect:/user/listaParteTrabajador";
	}

}
