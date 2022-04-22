package es.seresco.cursojee.FreddyEjercicioEspecie.services;

import java.util.List;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.EspecieTipoAlimentacionDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.EspecieTipoAlimentacion;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.EspecieTipoAlimentacionPK;

public interface EspecieTipoAlimentacionService {

	EspecieTipoAlimentacionDto getEspecieTipoAlimentacion(EspecieTipoAlimentacionPK especieTipoAlimentacionPK);
	
	EspecieTipoAlimentacionDto create(EspecieTipoAlimentacion especieTipoAlimentacion);
	
	List<EspecieTipoAlimentacionDto> findEspecieTipoAlimentaciones () throws MiValidationException;

	void deleteEspecieTipoAlimentacion(EspecieTipoAlimentacionPK especieTipoAlimentacionPK);
}
