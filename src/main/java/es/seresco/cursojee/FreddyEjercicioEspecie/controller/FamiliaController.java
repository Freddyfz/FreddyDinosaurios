package es.seresco.cursojee.FreddyEjercicioEspecie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.FamiliaDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewFamiliaDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;
import es.seresco.cursojee.FreddyEjercicioEspecie.services.FamiliaService;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping(path = "/api/familias")
@Slf4j
public class FamiliaController {

	@Autowired
	private FamiliaService familiaService;
	
	@GetMapping(path = "/{idFamilia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FamiliaDto> getFamilia(@PathVariable Long idFamilia) throws MiValidationException {
		log.info("Obtiene la familia por Id");
		FamiliaDto familia = familiaService.getFamilia(idFamilia);

		if (familia != null) {
			return ResponseEntity.status(HttpStatus.OK).body(familia);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FamiliaDto> createFamilia(@Validated @RequestBody NewFamiliaDto newFamilia) {
		log.info("Crea un familia");
		FamiliaDto familia = familiaService.create(newFamilia);

		if (familia != null) {
			return ResponseEntity.status(HttpStatus.OK).body(familia);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FamiliaDto>> getFamilias() throws MiValidationException {

		List<FamiliaDto> familiasEncontradas = familiaService.findFamilias();

		if(familiasEncontradas.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(familiasEncontradas);
		}
	}
	
	@PutMapping(path = "/{idFamilia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FamiliaDto> actualizaFamiliaIdParam(@PathVariable Long idFamilia, @Validated @RequestBody NewFamiliaDto updatedFamilia) throws MiValidationException {
		
		familiaService.updateFamilia(idFamilia,updatedFamilia);
		FamiliaDto dto=familiaService.getFamilia(idFamilia);
		log.info("Familia actualizado");

		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	@DeleteMapping(path = "/{idFamilia}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void deleteFamilia(@PathVariable Long idFamilia) throws MiValidationException {
		familiaService.deleteFamilia(idFamilia);
	}
	
	@PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FamiliaDto> actualizaFamilia(@Validated @RequestBody FamiliaDto updatedFamilia) throws MiValidationException {
		
		familiaService.updateFamilia(updatedFamilia);
		return ResponseEntity.status(HttpStatus.OK).body(familiaService.getFamilia(updatedFamilia.getId()));
	}
}
