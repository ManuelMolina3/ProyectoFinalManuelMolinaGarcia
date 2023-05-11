package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectofinal.model.Materiales;
import com.salesianostriana.dam.proyectofinal.service.MaterialesService;

@Controller
public class MaterialesController {

	@Autowired
	private MaterialesService materialesServicio;
	
	@GetMapping("/listaMateriales")
	public String listaMateriales (Model model) {
		model.addAttribute("listaMateriales", materialesServicio.findAll());
		return "/admin/listaMateriales";
	}
	@GetMapping("/addMateriales")
	public String mostrarFormMateriales(Model model) {
		model.addAttribute("materiales", new Materiales());
		return "/admin/materialesForm";
	}
	@PostMapping("/addMateriales/submit")
	public String procesarFormMateriales(@ModelAttribute("materiales") Materiales materiales) {
		materialesServicio.add(materiales);
		return "redirect:/admin/listaMateriales";
	}
	@GetMapping("/editarMateriales/{id}")
	public String mostrarFormEdicionMateriales(@PathVariable("id") long id, Model model) {
		Materiales materialesEditar= materialesServicio.findById(id);
		if(materialesEditar != null) {
			model.addAttribute("materiales", materialesEditar);
			return "/admin/editFormMateriales";
		}else {
			return "redirect:/admin/listaMateriales";
		}
	}
	@PostMapping("/editarMateriales/submit")
	public String procesarFormEditMateriales(@ModelAttribute("materiales") Materiales materiales) {
		materialesServicio.edit(materiales);
		return "redirect:/admin/listaMateriales";
	}
	@GetMapping("/deleteMateriales")
	public String deleteMateriales(@PathVariable("id") long id, Model model){
		materialesServicio.deleteById(id);
		return "redirect:/admin/listaMateriales";
	}
	
}
