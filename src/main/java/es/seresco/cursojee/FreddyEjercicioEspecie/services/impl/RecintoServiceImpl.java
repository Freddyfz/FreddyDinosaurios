package es.seresco.cursojee.FreddyEjercicioEspecie.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewRecintoDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.RecintoDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;
import es.seresco.cursojee.FreddyEjercicioEspecie.mapper.RecintoMapper;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.Recinto;
import es.seresco.cursojee.FreddyEjercicioEspecie.repository.RecintoRepository;
import es.seresco.cursojee.FreddyEjercicioEspecie.services.RecintoService;
import lombok.extern.slf4j.Slf4j;

@Service(RecintoService.BEAN_NAME)
@Slf4j
public class RecintoServiceImpl implements RecintoService{
	
	@Autowired
	private RecintoRepository recintoRepository;
	
	@Autowired
	private RecintoMapper recintoMapper;
	
	@Override
	public RecintoDto getRecinto(Long idRecinto) {
		log.info("Usando bean {}, para obtener recinto {}", BEAN_NAME, idRecinto);
		return recintoMapper.recintoToRecintoDto(recintoRepository.getById(idRecinto));
	}
	

	@Override
	public RecintoDto create(NewRecintoDto newRecinto) {
		log.info("Usando bean {}, para crear recinto", BEAN_NAME);
		Recinto recinto=recintoMapper.newRecintoDtoToRecinto(newRecinto);
		recintoRepository.save(recinto);
		return recintoMapper.recintoToRecintoDto(recinto);
	}

	@Override
	public List<RecintoDto> findRecintos() throws MiValidationException {
		log.info("Usando bean {}, para buscar recintoes", BEAN_NAME);
		return recintoMapper.recintoTomapRecintoDtoList(recintoRepository.findAll());
	}

	@Override
	public RecintoDto updateRecinto(Long idRecinto, NewRecintoDto updatedRecinto) throws MiValidationException {
		log.info("Usando bean {}, para actualizar recinto {}", BEAN_NAME,idRecinto);
		Recinto recinto=recintoRepository.getById(idRecinto);
		recinto=recintoMapper.newRecintoDtoToRecinto(updatedRecinto);
		recintoRepository.save(recinto);
		return recintoMapper.recintoToRecintoDto(recinto);
	}

	@Override
	public RecintoDto updateRecinto(RecintoDto updatedRecinto) throws MiValidationException {
		Recinto recinto=recintoMapper.recintoDtoToRecinto(updatedRecinto);
		recintoRepository.save(recinto);
		return recintoMapper.recintoToRecintoDto(recinto);
	}

	@Override
	public void deleteRecinto(Long idRecinto) {
		Recinto recinto=recintoRepository.getById(idRecinto);
		recintoRepository.delete(recinto);
		
	}
}
