package es.seresco.cursojee.FreddyEjercicioEspecie.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.FamiliaDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewFamiliaDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.mapper.FamiliaMapper;
import es.seresco.cursojee.FreddyEjercicioEspecie.model.Familia;
import es.seresco.cursojee.FreddyEjercicioEspecie.repository.FamiliaRepository;
import es.seresco.cursojee.FreddyEjercicioEspecie.services.FamiliaService;
import lombok.extern.slf4j.Slf4j;

@Service(FamiliaService.BEAN_NAME)
@Slf4j
public class FamiliaServiceImpl implements FamiliaService{
	
	@Autowired
	private FamiliaRepository familiaRepository;
	
	@Autowired
	private FamiliaMapper familiaMapper;
	
	@Override
	public FamiliaDto getFamilia(Long idFamilia) {
		log.info("Usando bean {}, para obtener familia {}", BEAN_NAME, idFamilia);
		return familiaMapper.familiaToFamiliaDto(familiaRepository.getById(idFamilia));
	}
	
	@Override
	public Familia getFamiliaObj(Long idFamilia) {
		log.info("Usando bean {}, para obtener familia {}", BEAN_NAME, idFamilia);
		return familiaRepository.getById(idFamilia);
	}

	@Override
	public FamiliaDto create(NewFamiliaDto newFamilia) {
		log.info("Usando bean {}, para crear familia", BEAN_NAME);
		Familia familia=familiaMapper.newFamiliaDtoToFamilia(newFamilia);
		familiaRepository.save(familia);
		return familiaMapper.familiaToFamiliaDto(familia);
	}

	@Override
	public List<FamiliaDto> findFamilias() {
		log.info("Usando bean {}, para buscar familiaes", BEAN_NAME);
		return familiaMapper.familiaTomapFamiliaDtoList(familiaRepository.findAll());
	}

	@Override
	public FamiliaDto updateFamilia(Long idFamilia, NewFamiliaDto updatedFamilia) {
		log.info("Usando bean {}, para actualizar familia {}", BEAN_NAME,idFamilia);
		Familia familia=familiaRepository.getById(idFamilia);
		familia=familiaMapper.newFamiliaDtoToFamilia(updatedFamilia);
		familiaRepository.save(familia);
		return familiaMapper.familiaToFamiliaDto(familia);
	}
	
	@Override
	public Familia updateFamiliaObj(Long idFamilia, NewFamiliaDto updatedFamilia) {
		log.info("Usando bean {}, para actualizar familia {}", BEAN_NAME,idFamilia);
		Familia familia=familiaRepository.getById(idFamilia);
		familia=familiaMapper.newFamiliaDtoToFamilia(updatedFamilia);
		familiaRepository.save(familia);
		return familia;
	}

	@Override
	public FamiliaDto updateFamilia(FamiliaDto updatedFamilia) {
		Familia familia=familiaMapper.familiaDtoToFamilia(updatedFamilia);
		familiaRepository.save(familia);
		return familiaMapper.familiaToFamiliaDto(familia);
	}
	
	@Override
	public Familia updateFamiliaObj(FamiliaDto updatedFamilia) {
		Familia familia=familiaMapper.familiaDtoToFamilia(updatedFamilia);
		familiaRepository.save(familia);
		return familia;
	}

	@Override
	public void deleteFamilia(Long idFamilia){
		Familia familia=familiaRepository.getById(idFamilia);
		familiaRepository.delete(familia);
	}
}
