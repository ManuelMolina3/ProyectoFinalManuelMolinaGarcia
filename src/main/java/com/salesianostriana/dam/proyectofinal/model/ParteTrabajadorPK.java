package com.salesianostriana.dam.proyectofinal.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ParteTrabajadorPK implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long trabajador_id;
	private long reforma_id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;

	
}
