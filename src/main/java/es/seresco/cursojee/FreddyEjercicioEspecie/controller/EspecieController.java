package es.seresco.cursojee.FreddyEjercicioEspecie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.EspecieDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewEspecieDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;
import es.seresco.cursojee.FreddyEjercicioEspecie.services.EspecieService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/api/especies")
@Slf4j
public class EspecieController {

	@Autowired
	private EspecieService especieService;
	
	@GetMapping(path = "/{idEspecie}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EspecieDto> getEspecie(@PathVariable Long idEspecie) throws MiValidationException {
		log.info("Obtiene la especie por Id");
		EspecieDto especie = especieService.getEspecie(idEspecie);

		if (especie != null) {
			return ResponseEntity.status(HttpStatus.OK).body(especie);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EspecieDto> createEspecie(@Validated @RequestBody NewEspecieDto newEspecie) {
		log.info("Crea un especie");
		EspecieDto especie = especieService.create(newEspecie);

		if (especie != null) {
			return ResponseEntity.status(HttpStatus.OK).body(especie);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EspecieDto>> getEspecies() throws MiValidationException {

		List<EspecieDto> especiesEncontradas = especieService.findEspecies();

		if(especiesEncontradas.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(especiesEncontradas);
		}
	}
}

