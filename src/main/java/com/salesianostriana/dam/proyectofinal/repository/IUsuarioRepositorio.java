package com.salesianostriana.dam.proyectofinal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinal.model.Usuario;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, Long>{

Optional<Usuario> findFirstByUsername(String username);

}
