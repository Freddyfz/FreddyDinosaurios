package es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EspecieTipoAlimentacionDto {

	@NotNull
	private Long id;
	
	@EmbeddedId
	private EspecieTipoAlimentacionPKDto  especieTipoAlimentacionPKDto; 
}
@Embeddable
class EspecieTipoAlimentacionPKDto implements Serializable{
	
	private static final long serialVersionUID = 4076883394582048812L;

	@Column(name="id_Especie")
	private Long idEspecie;
	
	@Column(name="id_Tipo_Alimentacion")
	private Long idTipoAlimentacion;
}
