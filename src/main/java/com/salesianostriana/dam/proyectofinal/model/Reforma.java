package com.salesianostriana.dam.proyectofinal.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

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
public class Reforma {

	@Id
	@GeneratedValue
	private Long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaInicio;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaFinal;
	private double presupuesto;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_reforma_trabajador"))
	private Trabajador jefeDeObra;

	public void addToReforma(Trabajador jefeDeObra) {

		this.jefeDeObra = jefeDeObra;
		jefeDeObra.getReformas().add(this);
	}

	public void removeFromReforma(Trabajador jefeDeObra) {
		jefeDeObra.getReformas().remove(this);
		this.jefeDeObra = null;
	}

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_reforma_cliente"))
	private Cliente propietario;

	public void addToReforma(Cliente propietario) {
		this.propietario = propietario;
		propietario.getReformas().add(this);
	}

	public void removeFromReforma(Cliente propietario) {
		propietario.getReformas().remove(this);
		this.propietario = null;
	}

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@ManyToMany(mappedBy = "trabajaEnReforma", fetch = FetchType.EAGER)
	private Set<Trabajador> ReformaTrabajadapor = new HashSet<>();

	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(mappedBy= "reforma", fetch= FetchType.EAGER)
	private Set <LineaDeMateriales> materiales = new HashSet <>();
}
