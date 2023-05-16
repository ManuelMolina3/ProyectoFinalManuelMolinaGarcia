package com.salesianostriana.dam.proyectofinal.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class ParteTrabajadorPK implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long trabajador_id;
	private long reforma_id;
	private LocalDate fecha;

}
