package es.seresco.cursojee.FreddyEjercicioEspecie.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.EspecieDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewEspecieDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;
import es.seresco.cursojee.FreddyEjercicioEspecie.services.EspecieService;

@Service
public class EspecieServiceImpl implements EspecieService{

	@Override
	public EspecieDto getEspecie(Long idEspecie) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public EspecieDto create(NewEspecieDto newEspecie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EspecieDto> findEspeciees() throws MiValidationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EspecieDto updateEspecie(Long idEspecie, NewEspecieDto updatedEspecie) throws MiValidationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EspecieDto updateEspecie(EspecieDto updatedEspecie) throws MiValidationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEspecie(Long idEspecie) {
		// TODO Auto-generated method stub
		
	}

}
