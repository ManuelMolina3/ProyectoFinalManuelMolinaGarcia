package com.salesianostriana.dam.proyectofinal.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepositorio 
extends JpaRepository<Usuario, Long>{

Optional<Usuario> findFirstByUsername(String username);

}
