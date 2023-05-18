package com.salesianostriana.dam.proyectofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.Trabajador;
import com.salesianostriana.dam.proyectofinal.repository.ITrabajadorRepository;

@Service
public class TrabajadorService extends BaseService<Trabajador, Long, ITrabajadorRepository>{


	public List<Trabajador> findByTrabajador(String busqueda){
		return this.repositorio.findByNombreContainsIgnoreCaseOrApellidoContainsIgnoreCaseOrEmailContainsIgnoreCaseOrderByNombreDesc(busqueda, busqueda, busqueda);
	}
	
}
