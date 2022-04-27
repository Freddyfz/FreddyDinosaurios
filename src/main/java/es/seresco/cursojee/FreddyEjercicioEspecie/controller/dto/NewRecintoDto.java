package es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewRecintoDto {

	@NotNull
	private String codigo;
	
	@NotNull
	private String descripcion;
	
	@NotNull
	private Long idTipoAlimentacion;
	
	@NotNull
	private int animales;
}
