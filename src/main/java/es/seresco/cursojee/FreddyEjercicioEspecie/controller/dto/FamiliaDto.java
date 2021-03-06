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
public class FamiliaDto {

	@NotNull
	private Long id;
	
	@NotNull
	private String nombre;
}
