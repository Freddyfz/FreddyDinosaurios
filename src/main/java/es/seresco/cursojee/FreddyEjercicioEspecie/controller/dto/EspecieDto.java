package es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EspecieDto {

	@JsonProperty("Id")
	@NotNull
	private Long id;
	
	@JsonProperty("Id_familia")
	@NotNull
	private Long id_familia;
	
	@JsonProperty("Nombre")
	@NotNull
	private String nombre;
	
	@JsonProperty("Codigo tipo peligrosidad")
	@NotNull
	private String codigoTipoPeligrosidad;
	
	@JsonProperty("Longitud")
	@NotNull
	private int longitud;
	
	@JsonProperty("Anio desde")
	@NotNull
	private int anioDesde;
	
	@JsonProperty("Anio hasta")
	@NotNull
	private int anioHasta;
}
