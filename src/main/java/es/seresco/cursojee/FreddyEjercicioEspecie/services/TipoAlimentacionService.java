package es.seresco.cursojee.FreddyEjercicioEspecie.services;

import java.util.List;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.EspecieTipoAlimentacionDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewTipoAlimentacionDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.TipoAlimentacionDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;

public interface TipoAlimentacionService {

	TipoAlimentacionDto getTipoAlimentacion(Long idTipoAlimentacion);
	
	TipoAlimentacionDto create(EspecieTipoAlimentacionDto newTipoAlimentacion);
	
	List<TipoAlimentacionDto> findTipoAlimentaciones () throws MiValidationException;
	
	TipoAlimentacionDto updateTipoAlimentacion(Long idTipoAlimentacion, NewTipoAlimentacionDto newTipoAlimentacionDto) throws MiValidationException;

	TipoAlimentacionDto updateTipoAlimentacion(TipoAlimentacionDto updatedTipoAlimentacion) throws MiValidationException;

	void deleteTipoAlimentacion(Long idTipoAlimentacion);	
}
