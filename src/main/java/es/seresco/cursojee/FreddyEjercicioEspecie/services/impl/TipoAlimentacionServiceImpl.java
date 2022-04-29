package es.seresco.cursojee.FreddyEjercicioEspecie.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewTipoAlimentacionDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.TipoAlimentacionDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.mapper.TipoAlimentacionMapper;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.TipoAlimentacion;
import es.seresco.cursojee.FreddyEjercicioEspecie.repository.TipoAlimentacionRepository;
import es.seresco.cursojee.FreddyEjercicioEspecie.services.TipoAlimentacionService;
import lombok.extern.slf4j.Slf4j;

@Service(TipoAlimentacionService.BEAN_NAME)
@Slf4j
public class TipoAlimentacionServiceImpl implements TipoAlimentacionService{
	
	@Autowired
	private TipoAlimentacionRepository tipoAlimentacionRepository;
	
	@Autowired
	private TipoAlimentacionMapper tipoAlimentacionMapper;
	
	@Override
	public TipoAlimentacionDto getTipoAlimentacion(Long idTipoAlimentacion) {
		log.info("Usando bean {}, para obtener tipoAlimentacion {}", BEAN_NAME, idTipoAlimentacion);
		return tipoAlimentacionMapper.tipoAlimentacionToTipoAlimentacionDto(tipoAlimentacionRepository.getById(idTipoAlimentacion));
	}

	@Override
	public TipoAlimentacion getTipoAlimentacionObj(Long idTipoAlimentacion) {
		log.info("Usando bean {}, para obtener tipoAlimentacion {}", BEAN_NAME, idTipoAlimentacion);
		return tipoAlimentacionRepository.getById(idTipoAlimentacion);
	}
	@Override
	public TipoAlimentacionDto create(NewTipoAlimentacionDto newTipoAlimentacion) {
		log.info("Usando bean {}, para crear tipoAlimentacion", BEAN_NAME);
		TipoAlimentacion tipoAlimentacion=tipoAlimentacionMapper.newTipoAlimentacionDtoToTipoAlimentacion(newTipoAlimentacion);
		tipoAlimentacionRepository.save(tipoAlimentacion);
		return tipoAlimentacionMapper.tipoAlimentacionToTipoAlimentacionDto(tipoAlimentacion);
	}
	
	@Override
	public TipoAlimentacion createObj(NewTipoAlimentacionDto newTipoAlimentacion) {
		log.info("Usando bean {}, para crear tipoAlimentacion", BEAN_NAME);
		TipoAlimentacion tipoAlimentacion=tipoAlimentacionMapper.newTipoAlimentacionDtoToTipoAlimentacion(newTipoAlimentacion);
		tipoAlimentacionRepository.save(tipoAlimentacion);
		return tipoAlimentacion;
	}

	@Override
	public List<TipoAlimentacionDto> findTipoAlimentaciones() {
		log.info("Usando bean {}, para buscar tipoAlimentaciones", BEAN_NAME);
		return tipoAlimentacionMapper.tipoAlimentacionTomapTipoAlimentacionDtoList(tipoAlimentacionRepository.findAll());
	}

	@Override
	public TipoAlimentacionDto updateTipoAlimentacion(Long idTipoAlimentacion, NewTipoAlimentacionDto updatedTipoAlimentacion) {
		log.info("Usando bean {}, para actualizar tipoAlimentacion {}", BEAN_NAME,idTipoAlimentacion);
		TipoAlimentacion tipoAlimentacion=tipoAlimentacionRepository.getById(idTipoAlimentacion);
		tipoAlimentacion=tipoAlimentacionMapper.newTipoAlimentacionDtoToTipoAlimentacion(updatedTipoAlimentacion);
		tipoAlimentacionRepository.save(tipoAlimentacion);
		return tipoAlimentacionMapper.tipoAlimentacionToTipoAlimentacionDto(tipoAlimentacion);
	}
	
	@Override
	public TipoAlimentacion updateTipoAlimentacionObj(Long idTipoAlimentacion, NewTipoAlimentacionDto updatedTipoAlimentacion) {
		log.info("Usando bean {}, para actualizar tipoAlimentacion {}", BEAN_NAME,idTipoAlimentacion);
		TipoAlimentacion tipoAlimentacion=tipoAlimentacionRepository.getById(idTipoAlimentacion);
		tipoAlimentacion=tipoAlimentacionMapper.newTipoAlimentacionDtoToTipoAlimentacion(updatedTipoAlimentacion);
		tipoAlimentacionRepository.save(tipoAlimentacion);
		return tipoAlimentacion;
	}

	@Override
	public TipoAlimentacionDto updateTipoAlimentacion(TipoAlimentacionDto updatedTipoAlimentacion) {
		TipoAlimentacion tipoAlimentacion=tipoAlimentacionMapper.tipoAlimentacionDtoToTipoAlimentacion(updatedTipoAlimentacion);
		tipoAlimentacionRepository.save(tipoAlimentacion);
		return tipoAlimentacionMapper.tipoAlimentacionToTipoAlimentacionDto(tipoAlimentacion);
	}
	
	@Override
	public TipoAlimentacion updateTipoAlimentacionObj(TipoAlimentacionDto updatedTipoAlimentacion) {
		TipoAlimentacion tipoAlimentacion=tipoAlimentacionMapper.tipoAlimentacionDtoToTipoAlimentacion(updatedTipoAlimentacion);
		tipoAlimentacionRepository.save(tipoAlimentacion);
		return tipoAlimentacion;
	}

	@Override
	public void deleteTipoAlimentacion(Long idTipoAlimentacion){
		TipoAlimentacion tipoAlimentacion=tipoAlimentacionRepository.getById(idTipoAlimentacion);
		tipoAlimentacionRepository.delete(tipoAlimentacion);
		
	}
}
