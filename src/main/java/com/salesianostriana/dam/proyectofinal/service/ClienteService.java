package com.salesianostriana.dam.proyectofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.Cliente;
import com.salesianostriana.dam.proyectofinal.repository.IClienteRepository;

@Service
public class ClienteService extends BaseService<Cliente, Long, IClienteRepository>{

	private IClienteRepository repositorioCliente;
	
	public List<Cliente> findByNombre(String nombre){
		return repositorioCliente.findByNombreContainingIgnoreCase(nombre);
	}

}
