package entidades;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "persona")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
public class Persona extends Base{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@Column(name="nombre")
	String nombre;
	
	@Column(name="apellido")
	String apellido;
	
	@Column(name="dni", unique = true)
	int dni;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_domi")
	private Domicilio domicilio;
	
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(
			name="persona_libro",
			joinColumns = @JoinColumn(name="persona_id"),
			inverseJoinColumns = @JoinColumn(name="libro_id")
			)
	@Builder.Default
	private List<Libro> libros = new ArrayList<Libro>();
	
	
	
	
}
