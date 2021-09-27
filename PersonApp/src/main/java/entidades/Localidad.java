package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="localidad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Builder
@Audited
public class Localidad extends Base{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;*/
	
	@Column(name="denominacion")
	private String denominacion;

	
	
	
}
