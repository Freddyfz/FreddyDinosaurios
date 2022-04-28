package es.seresco.cursojee.FreddyEjercicioEspecie.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.EspecieDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewEspecieDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;
import es.seresco.cursojee.FreddyEjercicioEspecie.mapper.EspecieMapper;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.Especie;
import es.seresco.cursojee.FreddyEjercicioEspecie.repository.EspecieRepository;
import es.seresco.cursojee.FreddyEjercicioEspecie.services.EspecieService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EspecieServiceImpl implements EspecieService{
	
	@Autowired
	private EspecieRepository especieRepository;
	
	@Autowired
	private EspecieMapper especieMapper;
	
	@Override
	public EspecieDto getEspecie(Long idEspecie) {
		log.info("Usando bean {}, para obtener especie {}", BEAN_NAME, idEspecie);
		return especieMapper.especieToEspecieDto(especieRepository.getById(idEspecie));
	}
	
	@Override
	public Especie getEspecieObj(Long idEspecie) {
		log.info("Usando bean {}, para obtener especie {}", BEAN_NAME, idEspecie);
		return especieRepository.getById(idEspecie);
	}

	@Override
	public EspecieDto create(NewEspecieDto newEspecie) {
		log.info("Usando bean {}, para crear especie", BEAN_NAME);
		Especie especie=especieMapper.newEspecieDtoToEspecie(newEspecie);
		especieRepository.save(especie);
		return especieMapper.especieToEspecieDto(especie);
	}

	@Override
	public List<EspecieDto> findEspecies() throws MiValidationException {
		log.info("Usando bean {}, para buscar especiees", BEAN_NAME);
		return especieMapper.especieTomapEspecieDtoList(especieRepository.findAll());
	}

	@Override
	public EspecieDto updateEspecie(Long idEspecie, NewEspecieDto updatedEspecie) throws MiValidationException {
		log.info("Usando bean {}, para actualizar especie {}", BEAN_NAME,idEspecie);
		Especie especie=especieRepository.getById(idEspecie);
		especie=especieMapper.newEspecieDtoToEspecie(updatedEspecie);
		especieRepository.save(especie);
		return especieMapper.especieToEspecieDto(especie);
	}

	@Override
	public EspecieDto updateEspecie(EspecieDto updatedEspecie) throws MiValidationException {
		Especie especie=especieMapper.especieDtoToEspecie(updatedEspecie);
		especieRepository.save(especie);
		return especieMapper.especieToEspecieDto(especie);
	}

	@Override
	public Especie updateEspecieObj(Long idEspecie, NewEspecieDto updatedEspecie) throws MiValidationException {
		log.info("Usando bean {}, para actualizar especie {}", BEAN_NAME,idEspecie);
		Especie especie=especieRepository.getById(idEspecie);
		especie=especieMapper.newEspecieDtoToEspecie(updatedEspecie);
		especieRepository.save(especie);
		return especie;
	}

	@Override
	public Especie updateEspecieObj(EspecieDto updatedEspecie) throws MiValidationException {
		Especie especie=especieMapper.especieDtoToEspecie(updatedEspecie);
		especieRepository.save(especie);
		return especie;
	}
	
	@Override
	public void deleteEspecie(Long idEspecie) {
		Especie especie=especieRepository.getById(idEspecie);
		especieRepository.delete(especie);
		
	}

}
