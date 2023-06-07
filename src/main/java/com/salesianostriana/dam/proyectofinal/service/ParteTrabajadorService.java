package com.salesianostriana.dam.proyectofinal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.ParteTrabajador;
import com.salesianostriana.dam.proyectofinal.model.ParteTrabajadorPK;
import com.salesianostriana.dam.proyectofinal.model.Reforma;
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
		Optional<Reforma> parteReforma= reformaService.findById(parteTrabajador.getParteTrabajadorPK().getReforma_id());
		Optional<Trabajador> parteTraba= trabajadorService.findById(parteTrabajador.getParteTrabajadorPK().getTrabajador_id());
		if (parteTraba.isPresent()){
			parteTrabajador.setTrabajador(parteTraba.get());
		}
		if(parteReforma.isPresent()) {
			parteTrabajador.setReforma(parteReforma.get());
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
