package es.seresco.cursojee.FreddyEjercicioEspecie.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "Especie")
public class Especie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3630477143572696762L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "id_Familia", referencedColumnName = "id")
	private Familia familia;
	
	@Column(name = "nombre",length = 50)
	private String nombre;
	
	@Column(name = "codigo_tipo_peligrosidad",length = 20)
	private String codigoTipoPeligrosidad;
	
	@Column(name = "longitud",length = 3)
	private int longitud;
	
	@Column(name = "anio_desde",length = 3)
	private int anio_desde;
	
	@Column(name = "anio_hasta",length = 3)
	private int anio_hasta;
}
