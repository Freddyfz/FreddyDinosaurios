package es.seresco.cursojee.FreddyEjercicioEspecie.services;

import java.util.List;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.EspecieTipoAlimentacionDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;

public interface EspecieTipoAlimentacionService {

	EspecieTipoAlimentacionDto getEspecieTipoAlimentacion(Long idEspecieTipoAlimentacion);
	
	EspecieTipoAlimentacionDto create(Long idESpecie,Long idTipoAlimentacion);
	
	List<EspecieTipoAlimentacionDto> findEspecieTipoAlimentaciones () throws MiValidationException;
	
	EspecieTipoAlimentacionDto updateEspecieTipoAlimentacion(Long idEspecieTipoAlimentacion, Long idEspecie, Long idTipoAlimentacion) throws MiValidationException;

	EspecieTipoAlimentacionDto updateEspecieTipoAlimentacion(EspecieTipoAlimentacionDto updatedEspecieTipoAlimentacion) throws MiValidationException;

	void deleteEspecieTipoAlimentacion(Long idEspecieTipoAlimentacion);
}
