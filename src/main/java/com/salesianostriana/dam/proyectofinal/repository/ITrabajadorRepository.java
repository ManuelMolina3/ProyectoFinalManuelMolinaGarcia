package com.salesianostriana.dam.proyectofinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.salesianostriana.dam.proyectofinal.model.Trabajador;

public interface ITrabajadorRepository extends JpaRepository<Trabajador, Long>{

	List<Trabajador> findByNombreContainsIgnoreCaseOrApellidoContainsIgnoreCaseOrEmailContainsIgnoreCaseOrderByNombreDesc(String apellidos, String nombre, String email);
}
