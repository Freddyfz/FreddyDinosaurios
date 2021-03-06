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
public class NewEspecieDto {

	@NotNull
	private Long idFamilia;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private String codigoTipoPeligrosidad;
	
	@NotNull
	private int longitud;
	
	@NotNull
	private int anioDesde;
	
	@NotNull
	private int anioHasta;
}
