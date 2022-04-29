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
@Table(name = "RECINTO")
public class Recinto implements Serializable{
	
	private static final long serialVersionUID = -6320392355168028530L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "CODIGO",length = 50)
	private String codigo;
	
	@Column(name = "DESCRIPCION",length = 50)
	private String descripcion;
	
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_ALIMENTACION")
	private TipoAlimentacion tipoAlimentacion;
}
