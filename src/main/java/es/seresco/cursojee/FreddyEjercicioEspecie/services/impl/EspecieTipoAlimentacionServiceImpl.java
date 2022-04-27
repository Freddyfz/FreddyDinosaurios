package es.seresco.cursojee.FreddyEjercicioEspecie.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.EspecieTipoAlimentacionDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;
import es.seresco.cursojee.FreddyEjercicioEspecie.mapper.EspecieTipoAlimentacionMapper;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.EspecieTipoAlimentacion;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.EspecieTipoAlimentacionPK;
import es.seresco.cursojee.FreddyEjercicioEspecie.repository.EspecieTipoAlimentacionRepository;
import es.seresco.cursojee.FreddyEjercicioEspecie.services.EspecieTipoAlimentacionService;
import lombok.extern.slf4j.Slf4j;

@Service(EspecieTipoAlimentacionService.BEAN_NAME)
@Slf4j
public class EspecieTipoAlimentacionServiceImpl implements EspecieTipoAlimentacionService{
	
	@Autowired
	private EspecieTipoAlimentacionRepository especieTipoAlimentacionRepository;
	
	@Autowired
	private EspecieTipoAlimentacionMapper especieTipoAlimentacionMapper;

	@Override
	public EspecieTipoAlimentacionDto getEspecieTipoAlimentacion(EspecieTipoAlimentacionPK especieTipoAlimentacionPK) {
		log.info("Usando bean {}, para obtener familia {}", BEAN_NAME, especieTipoAlimentacionPK);
		return especieTipoAlimentacionMapper.especieTipoAlimentacionToEspecieTipoAlimentacionDto(especieTipoAlimentacionRepository.getById(especieTipoAlimentacionPK));
	}

	@Override
	public EspecieTipoAlimentacionDto create(EspecieTipoAlimentacion especieTipoAlimentacion) {
		return especieTipoAlimentacionMapper.especieTipoAlimentacionToEspecieTipoAlimentacionDto(especieTipoAlimentacionRepository.save(especieTipoAlimentacion));
	}

	@Override
	public List<EspecieTipoAlimentacionDto> findEspecieTipoAlimentaciones() throws MiValidationException {
		return especieTipoAlimentacionMapper.especieTipoAlimentacionTomapEspecieDtoList(especieTipoAlimentacionRepository.findAll());
	}

	@Override
	public void deleteEspecieTipoAlimentacion(EspecieTipoAlimentacionPK especieTipoAlimentacionPK) {
		especieTipoAlimentacionRepository.delete(especieTipoAlimentacionRepository.getById(especieTipoAlimentacionPK));
	}
	
	@Override
	public EspecieTipoAlimentacion getByIdEspecie(Long idEspecie) {
		return especieTipoAlimentacionRepository.getByIdEspecie(idEspecie);
	}

}
