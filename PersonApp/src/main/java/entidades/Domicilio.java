package entidades;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="domicilio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
public class Domicilio extends Base{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@Column(name="calle")
	String calle;
	
	@Column(name="numero")
	int numero;

	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="fk_local")
	private Localidad localidad;
	
	
	
}
