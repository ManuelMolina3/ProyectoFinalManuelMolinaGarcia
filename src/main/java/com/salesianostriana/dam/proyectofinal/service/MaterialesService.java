package com.salesianostriana.dam.proyectofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.salesianostriana.dam.proyectofinal.model.Materiales;
import com.salesianostriana.dam.proyectofinal.repository.IMaterialesRepository;

@Service
public class MaterialesService extends BaseService<Materiales, Long, IMaterialesRepository>{

	public List<Materiales> findByMateriales(String busqueda){

		return this.repositorio.findByNombreContainsIgnoreCaseOrderByNombreAsc(busqueda);

	}
}
