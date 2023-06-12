package com.salesianostriana.dam.proyectofinal.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
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
public class LineaDeMateriales {
	
	@Id
	@GeneratedValue
	private Long id_lineaDeMateriales;
	
	private int cantidad;

	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_lineaDeMateriales_material"))
	private Materiales material;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_lineaDeMateriales_venta"))
	private Venta venta;
	
}
