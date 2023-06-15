package com.salesianostriana.dam.proyectofinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyectofinal.model.ParteTrabajador;
import com.salesianostriana.dam.proyectofinal.model.ParteTrabajadorPK;
import com.salesianostriana.dam.proyectofinal.model.Trabajador;

public interface IParteTrabajadorRepository extends JpaRepository<ParteTrabajador, ParteTrabajadorPK>{

    @Query("select p from ParteTrabajador p where p.trabajador = ?1")
    List <ParteTrabajador> findPartesByTrabajador(Trabajador t);

}
