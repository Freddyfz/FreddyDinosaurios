package es.seresco.cursojee.FreddyEjercicioEspecie.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Especie_Tipo_Alimentacion")
public class EspecieTipoAlimentacion implements Serializable{
	
	private static final long serialVersionUID = -1399472818674786358L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@EmbeddedId
	private EspecieTipoAlimentacionPK  especieTipoAlimentacionPK; 
}

@Embeddable
class EspecieTipoAlimentacionPK implements Serializable{
	
	private static final long serialVersionUID = 4076883394582048812L;

	@Column(name="id_Especie")
	private Long idEspecie;
	
	@Column(name="id_Tipo_Alimentacion")
	private Long idTipoAlimentacion;
}
