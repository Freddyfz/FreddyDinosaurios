package es.seresco.cursojee.FreddyEjercicioEspecie.services;

import java.util.List;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.EspecieDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewEspecieDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.Especie;

public interface EspecieService {

	public static final String BEAN_NAME = "especieService";

	EspecieDto getEspecie(Long idEspecie);
	
	EspecieDto create(NewEspecieDto newEspecie);
	
	List<EspecieDto> findEspecies () throws MiValidationException;
	
	EspecieDto updateEspecie(Long idEspecie, NewEspecieDto updatedEspecie) throws MiValidationException;

	EspecieDto updateEspecie(EspecieDto updatedEspecie) throws MiValidationException;

	void deleteEspecie(Long idEspecie);

	Especie getEspecieObj(Long idEspecie);

	Especie updateEspecieObj(Long idEspecie, NewEspecieDto updatedEspecie) throws MiValidationException;

	Especie updateEspecieObj(EspecieDto updatedEspecie) throws MiValidationException;
}
