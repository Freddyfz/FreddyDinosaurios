package es.seresco.cursojee.FreddyEjercicioEspecie.services;

import java.util.List;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewTipoAlimentacionDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.TipoAlimentacionDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;

public interface TipoAlimentacionService {
	
	public static final String BEAN_NAME = "TipoAlimentacionServiceImpl";

	TipoAlimentacionDto getTipoAlimentacion(Long idTipoAlimentacion);
	
	TipoAlimentacionDto create(NewTipoAlimentacionDto newTipoAlimentacion);	
	
	List<TipoAlimentacionDto> findTipoAlimentaciones () throws MiValidationException;
	
	TipoAlimentacionDto updateTipoAlimentacion(Long idTipoAlimentacion, NewTipoAlimentacionDto newTipoAlimentacionDto) throws MiValidationException;

	TipoAlimentacionDto updateTipoAlimentacion(TipoAlimentacionDto updatedTipoAlimentacion) throws MiValidationException;

	void deleteTipoAlimentacion(Long idTipoAlimentacion);

}
