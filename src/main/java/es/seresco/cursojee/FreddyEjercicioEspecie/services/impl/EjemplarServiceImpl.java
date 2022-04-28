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
import es.seresco.cursojee.FreddyEjercicioEspecie.services.EspecieService;
import es.seresco.cursojee.FreddyEjercicioEspecie.services.EspecieTipoAlimentacionService;
import es.seresco.cursojee.FreddyEjercicioEspecie.services.RecintoService;
import lombok.extern.slf4j.Slf4j;

@Service(EjemplarService.BEAN_NAME)
@Slf4j
public class EjemplarServiceImpl implements EjemplarService{

	@Autowired
	private EjemplarRepository ejemplarRepository;

	@Autowired
	private EjemplarMapper ejemplarMapper;

	@Autowired
	private EspecieTipoAlimentacionService especieTipoAlimentacionService;

	@Autowired
	private EspecieService especieService;

	@Autowired
	private RecintoService recintoService;

	@Override
	public EjemplarDto getEjemplar(Long idEjemplar) {
		log.info("Usando bean {}, para obtener ejemplar {}", BEAN_NAME, idEjemplar);
		return ejemplarMapper.ejemplarToEjemplarDto(ejemplarRepository.getById(idEjemplar));
	}


	@Override
	public EjemplarDto create(NewEjemplarDto newEjemplar) {
		log.info("Usando bean {}, para crear ejemplar", BEAN_NAME);
		//Comprobamos que newEjemplar tenga los atributos de las ids
		if(newEjemplar.getIdRecinto()!=null&&newEjemplar.getIdEspecie()!=null) {
			Ejemplar ejemplar=ejemplarMapper.newEjemplarDtoToEjemplar(newEjemplar);
			ejemplar.setRecinto(recintoService.getRecintoObj(newEjemplar.getIdRecinto()));
			ejemplar.setEspecie(especieService.getEspecieObj(newEjemplar.getIdEspecie()));
			//Comprobamos que coinciden el tipo alimentacion de la especie y del recinto
			if(especieTipoAlimentacionService.getByIdEspecie(ejemplar.getEspecie().getId())!=null&&especieTipoAlimentacionService.getByIdTipoAlimentacion(ejemplarRepository.getTipoAlimentacion(ejemplar.getRecinto().getId()).getId())!=null) {
				//Comprobamos que hay sitio disponible en el recinto
				if(ejemplarRepository.getByRecintoId(ejemplar.getRecinto().getId()).size()<4 && ejemplarRepository.getByRecintoId(ejemplar.getRecinto().getId()).size()>=0) {
					ejemplar.getRecinto().setAnimales(ejemplar.getRecinto().getAnimales()+1);
					ejemplarRepository.save(ejemplar);
					return ejemplarMapper.ejemplarToEjemplarDto(ejemplar);
				}
			}
		}
		return null;
	}

	@Override
	public Ejemplar createObj(NewEjemplarDto newEjemplar) {
		log.info("Usando bean {}, para crear ejemplar", BEAN_NAME);
		//Comprobamos que newEjemplar tenga los atributos de las ids
		if(newEjemplar.getIdRecinto()!=null&&newEjemplar.getIdEspecie()!=null) {
			Ejemplar ejemplar=ejemplarMapper.newEjemplarDtoToEjemplar(newEjemplar);
			ejemplar.setRecinto(recintoService.getRecintoObj(newEjemplar.getIdRecinto()));
			ejemplar.setEspecie(especieService.getEspecieObj(newEjemplar.getIdEspecie()));
			//Comprobamos que hay sitio disponible en el recinto
			if(ejemplarRepository.getByRecintoId(ejemplar.getRecinto().getId()).size()<4 && ejemplarRepository.getByRecintoId(ejemplar.getRecinto().getId()).size()>=0) {
				//Comprobamos que coinciden el tipo alimentacion de la especie y del recinto
				if(ejemplarRepository.comprobarTipoAlimentacionEspecie(newEjemplar.getIdEspecie())==ejemplarRepository.comprobarTipoAlimentacionRecinto(newEjemplar.getIdRecinto())) {
					ejemplarRepository.save(ejemplar);
					return ejemplar;

				}
			}
		}
		return null;
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
		if(especieTipoAlimentacionService.getByIdEspecie(ejemplar.getEspecie().getId())!=null&&especieTipoAlimentacionService.getByIdTipoAlimentacion(ejemplarRepository.getTipoAlimentacion(ejemplar.getRecinto().getId()).getId())!=null) {
			if(ejemplarRepository.getByRecintoId(ejemplar.getRecinto().getId()).size()<4 && ejemplarRepository.getByRecintoId(ejemplar.getRecinto().getId()).size()>=0) {
				ejemplarRepository.save(ejemplar);
				return ejemplarMapper.ejemplarToEjemplarDto(ejemplar);
			}
		}
		return null;
	}

	@Override
	public EjemplarDto updateEjemplar(EjemplarDto updatedEjemplar) throws MiValidationException {
		Ejemplar ejemplar=ejemplarMapper.ejemplarDtoToEjemplar(updatedEjemplar);
		if(especieTipoAlimentacionService.getByIdEspecie(ejemplar.getEspecie().getId())!=null&&especieTipoAlimentacionService.getByIdTipoAlimentacion(ejemplarRepository.getTipoAlimentacion(ejemplar.getRecinto().getId()).getId())!=null) {
			if(ejemplarRepository.getByRecintoId(ejemplar.getRecinto().getId()).size()<4 && ejemplarRepository.getByRecintoId(ejemplar.getRecinto().getId()).size()>=0) {
				ejemplarRepository.save(ejemplar);
				return ejemplarMapper.ejemplarToEjemplarDto(ejemplar);
			}
		}
		return null;
	}

	@Override
	public void deleteEjemplar(Long idEjemplar) {
		Ejemplar ejemplar=ejemplarRepository.getById(idEjemplar);
		ejemplarRepository.delete(ejemplar);

	}

	@Override
	public List<Ejemplar> getByIdRecinto(Long idRecinto){
		if(ejemplarRepository.getByRecintoId(idRecinto)==null) {
			return null;
		}
		return ejemplarRepository.getByRecintoId(idRecinto);
	}
}
