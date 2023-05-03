package com.salesianostriana.dam.principioproyectofinal.model;

import java.util.ArrayList;
import java.util.List;

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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
	
	@Id
	@GeneratedValue
	private Long id_cliente;
	
	private String nombre;
	private String apellido;
	private String dni;
	private String ciudad;
	private String contraseña;
	private int telefono;
	private String email;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(mappedBy= "propietario", fetch= FetchType.EAGER)
	private List <Reforma> reformas = new ArrayList <>();

}
