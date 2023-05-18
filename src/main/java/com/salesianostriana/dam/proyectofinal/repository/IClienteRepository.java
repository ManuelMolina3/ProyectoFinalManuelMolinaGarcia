package com.salesianostriana.dam.proyectofinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyectofinal.model.Cliente;


public interface IClienteRepository extends JpaRepository<Cliente, Long>{

	@Query("SELECT c FROM Cliente c WHERE"
			+ " CONCAT(c.id_cliente, c.nombre, c.apellido, c.dni, c.email)"
			+ " LIKE %?1%")
	public List<Cliente> findByAllContainingIgnoreCase(String busqueda);
}
