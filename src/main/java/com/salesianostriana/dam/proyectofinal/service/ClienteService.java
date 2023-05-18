package com.salesianostriana.dam.proyectofinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.Cliente;
import com.salesianostriana.dam.proyectofinal.repository.IClienteRepository;

@Service
public class ClienteService extends BaseService<Cliente, Long, IClienteRepository>{

	@Autowired
	IClienteRepository repo;

	
	public List<Cliente> findByClientes(String busqueda){

		return repo.findByAllContainingIgnoreCase(busqueda);

	}
	
	

}
