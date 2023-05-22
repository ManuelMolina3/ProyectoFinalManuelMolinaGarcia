package com.salesianostriana.dam.proyectofinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(mappedBy= "lineaVenta", 
				fetch = FetchType.EAGER, 
				cascade= CascadeType.ALL,
				orphanRemoval= true)
	private List<Materiales> materiales = new ArrayList<>();
	
	
}
