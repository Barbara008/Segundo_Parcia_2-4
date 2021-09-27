package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="libro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Builder
@Audited
public class Libro extends Base{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;*/
	
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
