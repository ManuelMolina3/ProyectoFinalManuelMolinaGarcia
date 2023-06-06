package com.salesianostriana.dam.proyectofinal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Venta {

	@Id
	@GeneratedValue
	private long id_venta;
	
	private double total;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(
				mappedBy = "venta",
				fetch = FetchType.EAGER,
				cascade = CascadeType.ALL,
				orphanRemoval = true
		)
	private List <LineaDeMateriales> listaLineaMateriaes;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_venta_reforma"))
	private Reforma reforma;
}
