package com.salesianostriana.dam.proyectofinal.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.ParteTrabajador;
import com.salesianostriana.dam.proyectofinal.model.ParteTrabajadorPK;
import com.salesianostriana.dam.proyectofinal.model.Trabajador;
import com.salesianostriana.dam.proyectofinal.repository.IParteTrabajadorRepository;

@Service
public class ParteTrabajadorService extends BaseService<ParteTrabajador, ParteTrabajadorPK, IParteTrabajadorRepository>{

	
	@Autowired
	private TrabajadorService trabajadorService;
	
	@Autowired
	private ReformaService reformaService;
	
	@Override
	public ParteTrabajador add(ParteTrabajador parteTrabajador) {
		if (parteTrabajador.getTrabajador() == null) {
			parteTrabajador.setTrabajador((trabajadorService.findById(parteTrabajador.getParteTrabajadorPK().getTrabajador_id())));
		}
		if(parteTrabajador.getReforma() == null) {
			parteTrabajador.setReforma(reformaService.findById(parteTrabajador.getParteTrabajadorPK().getReforma_id()));
		}
		return super.add(parteTrabajador);
	}

	public ParteTrabajador findByParte (Long trabajador_id, Long reforma_id, LocalDate fecha) {
		return this.repositorio.findById(new ParteTrabajadorPK(trabajador_id, reforma_id, fecha)).orElse(null);
	}
	public List<ParteTrabajador> findByTrabajador (Trabajador t){
		return this.repositorio.findParteTrabajadorByTrabajadorId(t);
	}
	
}
