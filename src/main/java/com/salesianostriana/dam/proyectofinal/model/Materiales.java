package com.salesianostriana.dam.proyectofinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Materiales {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private double coste;
	private double pvpMaterial;
	
	@ManyToOne
	@JoinColumn
	private LineaDeMateriales lineaVenta;
	
}
