package entidades;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="libro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
public class Libro extends Base{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@Column(name="titulo")
	String titulo;
	
	@Column(name="fecha")
	private int fecha;
	
	@Column(name="genero")
	private String genero;
	
	@Column(name="paginas")
	private int paginas;
	
	@Column(name="autor")
	private String autor;

	
	@ManyToMany(cascade = {CascadeType.ALL, CascadeType.REFRESH})
	@JoinTable(
			name="libro_autores",
			joinColumns = @JoinColumn(name="libro_id"),
			inverseJoinColumns = @JoinColumn(name="autores_id")
			)
	@Builder.Default
	private List<Autor> autores = new ArrayList<Autor>();
	
	
	
	
	
}
