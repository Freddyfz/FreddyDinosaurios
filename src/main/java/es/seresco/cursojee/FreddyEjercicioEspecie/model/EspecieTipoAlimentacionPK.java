package es.seresco.cursojee.FreddyEjercicioEspecie.model;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EspecieTipoAlimentacionPK implements Serializable{
	
	private static final long serialVersionUID = 4076883394582048812L;

	@Column(name="ID_ESPECIE")
	private Long idEspecie;
	
	@Column(name="ID_TIPO_ALIMENTACION")
	private Long idTipoAlimentacion;
}
