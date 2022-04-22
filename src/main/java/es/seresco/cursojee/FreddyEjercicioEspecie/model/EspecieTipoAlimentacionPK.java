package es.seresco.cursojee.FreddyEjercicioEspecie.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EspecieTipoAlimentacionPK implements Serializable{
	
	private static final long serialVersionUID = 4076883394582048812L;

	@Column(name="id_Especie")
	private Long idEspecie;
	
	@Column(name="id_Tipo_Alimentacion")
	private Long idTipoAlimentacion;
}
