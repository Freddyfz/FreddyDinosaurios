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
public class EjemplarDto {

	@NotNull
	private Long id;
	
	@NotNull
	private Long idEspecie;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private String sexo;
	
	@NotNull
	private String idRecinto;
}
