package es.seresco.cursojee.FreddyEjercicioEspecie.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.EjemplarDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewEjemplarDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;
import es.seresco.cursojee.FreddyEjercicioEspecie.mapper.EjemplarMapper;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.Ejemplar;
import es.seresco.cursojee.FreddyEjercicioEspecie.repository.EjemplarRepository;
import es.seresco.cursojee.FreddyEjercicioEspecie.services.EjemplarService;
import lombok.extern.slf4j.Slf4j;

@Service(EjemplarService.BEAN_NAME)
@Slf4j
public class EjemplarServiceImpl implements EjemplarService{
	
	@Autowired
	private EjemplarRepository ejemplarRepository;
	
	@Autowired
	private EjemplarMapper ejemplarMapper;
	
	@Override
	public EjemplarDto getEjemplar(Long idEjemplar) {
		log.info("Usando bean {}, para obtener ejemplar {}", BEAN_NAME, idEjemplar);
		return ejemplarMapper.ejemplarToEjemplarDto(ejemplarRepository.getById(idEjemplar));
	}
	

	@Override
	public EjemplarDto create(NewEjemplarDto newEjemplar) {
		log.info("Usando bean {}, para crear ejemplar", BEAN_NAME);
		Ejemplar ejemplar=ejemplarMapper.newEjemplarDtoToEjemplar(newEjemplar);
		ejemplarRepository.save(ejemplar);
		return ejemplarMapper.ejemplarToEjemplarDto(ejemplar);
	}

	@Override
	public List<EjemplarDto> findEjemplares() throws MiValidationException {
		log.info("Usando bean {}, para buscar ejemplares", BEAN_NAME);
		return ejemplarMapper.ejemplarTomapEjemplarDtoList(ejemplarRepository.findAll());
	}

	@Override
	public EjemplarDto updateEjemplar(Long idEjemplar, NewEjemplarDto updatedEjemplar) throws MiValidationException {
		log.info("Usando bean {}, para actualizar ejemplar {}", BEAN_NAME,idEjemplar);
		Ejemplar ejemplar=ejemplarRepository.getById(idEjemplar);
		ejemplar=ejemplarMapper.newEjemplarDtoToEjemplar(updatedEjemplar);
		ejemplarRepository.save(ejemplar);
		return ejemplarMapper.ejemplarToEjemplarDto(ejemplar);
	}

	@Override
	public EjemplarDto updateEjemplar(EjemplarDto updatedEjemplar) throws MiValidationException {
		Ejemplar ejemplar=ejemplarMapper.ejemplarDtoToEjemplar(updatedEjemplar);
		ejemplarRepository.save(ejemplar);
		return ejemplarMapper.ejemplarToEjemplarDto(ejemplar);
	}

	@Override
	public void deleteEjemplar(Long idEjemplar) {
		Ejemplar ejemplar=ejemplarRepository.getById(idEjemplar);
		ejemplarRepository.delete(ejemplar);
		
	}
}
