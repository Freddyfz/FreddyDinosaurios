package es.seresco.cursojee.FreddyEjercicioEspecie.services;

import java.util.List;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.EspecieDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewEspecieDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;

public interface EspecieService {

	EspecieDto getEspecie(Long idEspecie);
	
	EspecieDto create(NewEspecieDto newEspecie);
	
	List<EspecieDto> findEspeciees () throws MiValidationException;
	
	EspecieDto updateEspecie(Long idEspecie, NewEspecieDto updatedEspecie) throws MiValidationException;

	EspecieDto updateEspecie(EspecieDto updatedEspecie) throws MiValidationException;

	void deleteEspecie(Long idEspecie);
}