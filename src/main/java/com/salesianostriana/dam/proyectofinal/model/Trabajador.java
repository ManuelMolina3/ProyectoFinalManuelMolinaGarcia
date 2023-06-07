package com.salesianostriana.dam.proyectofinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper= true)
@ToString(callSuper= true)
@SuperBuilder
public class Trabajador extends Usuario{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*@Id
	@GeneratedValue
	private Long id_trabajador;*/
	
	private String nombre;
	private String apellido;
	private String email;
	private double sueldoBase;
	private double precioHoraExtra;


	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy= "jefeDeObra", fetch= FetchType.EAGER)
	@Builder.Default
	private List <Reforma> reformas = new ArrayList<> ();
	
	@ManyToMany
	@Builder.Default
	@JoinTable(
			name= "trabaja",
			joinColumns= @JoinColumn(name= "id_trabajador"),
			inverseJoinColumns= @JoinColumn(name="id_reforma")
			)
	
	private List<Reforma> trabajaEnReforma = new ArrayList <>();
	
	@OneToMany(mappedBy="trabajador", fetch= FetchType.EAGER)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@Builder.Default
	private List<ParteTrabajador> parteTrabajador= new ArrayList<>();
	

}
