package com.salesianostriana.dam.proyectofinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinal.model.Cliente;


public interface IClienteRepository extends JpaRepository<Cliente, Long>{

	List<Cliente> findByNombreContainsIgnoreCaseOrApellidoContainsIgnoreCaseOrDniContainsIgnoreCaseOrderByNombreDesc(String apellidos, String nombre, String dni);
}
