package com.salesianostriana.dam.proyectofinal.service;

import java.util.List;
import java.util.Optional;



public interface IBaseService<T, ID> {

	T add(T t);

	Optional <T> findById(ID id);

	List<T> findAll();

	T edit(T t);
	
	void delete(T t);

	void deleteById(ID id);
}
