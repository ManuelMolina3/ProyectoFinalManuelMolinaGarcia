package com.salesianostriana.dam.proyectofinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyectofinal.model.Cliente;


public interface IClienteRepository extends JpaRepository<Cliente, Long>{

	@Query("""
			select c from Cliente c where c.id_cliente LIKE %?1%
			or c.nombre LIKE %?1%
			or c.apellido LIKE %?1%
			or c.dni LIKE %?1%
			or c.email LIKE %?1%
					""")
	public List<Cliente> findByAllContainingIgnoreCase(String busqueda);
}
