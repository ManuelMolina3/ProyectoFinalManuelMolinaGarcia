package com.salesianostriana.dam.proyectofinal.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ParteTrabajador {
	
	@EmbeddedId
	private ParteTrabajadorPK parteTrabajadorPK = new ParteTrabajadorPK();
	
	public ParteTrabajador(Trabajador t, Reforma r) {
		this.trabajador= t;
		this.reforma= r;
	}
	@ManyToOne
	@MapsId("trabajador_id")
	@JoinColumn(name= "trabajador_id")
	private Trabajador trabajador;
	
	@ManyToOne
	@MapsId("reforma_id")
	@JoinColumn(name= "reforma_id")
	private Reforma reforma;
	
	private double numHoras;
	private double numHorasExtra;
	
	public void addToTrabajador(Trabajador t) {
		t.getParteTrabajador().add(this);
		this.trabajador = t;
	}

	public void removeFromTrabajador(Trabajador t) {
		t.getParteTrabajador().remove(this);
		this.trabajador = null;
	}
}
