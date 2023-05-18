package com.salesianostriana.dam.proyectofinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinal.model.Materiales;

public interface IMaterialesRepository extends JpaRepository<Materiales, Long>{

	List<Materiales> findByNombreContainsIgnoreCaseOrderByNombreAsc(String nombre);
}
