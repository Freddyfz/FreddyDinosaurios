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

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.EjemplarDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewEjemplarDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;
import es.seresco.cursojee.FreddyEjercicioEspecie.services.EjemplarService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/api/ejemplares")
@Slf4j
public class EjemplarController {

	@Autowired
	private EjemplarService ejemplarService;
	
	@GetMapping(path = "/{idEjemplar}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EjemplarDto> getEjemplar(@PathVariable Long idEjemplar) throws MiValidationException {
		log.info("Obtiene la ejemplar por Id");
		EjemplarDto ejemplar = ejemplarService.getEjemplar(idEjemplar); 

		if (ejemplar != null) {
			return ResponseEntity.status(HttpStatus.OK).body(ejemplar);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EjemplarDto> createEjemplar(@Validated @RequestBody NewEjemplarDto newEjemplar) {
		log.info("Crea un ejemplar");
		EjemplarDto ejemplar = ejemplarService.create(newEjemplar);

		if (ejemplar != null) {
			return ResponseEntity.status(HttpStatus.OK).body(ejemplar);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EjemplarDto>> getEjemplars() throws MiValidationException {

		List<EjemplarDto> ejemplarsEncontradas = ejemplarService.findEjemplares();

		if(ejemplarsEncontradas.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(ejemplarsEncontradas);
		}
	}
	
	@PutMapping(path = "/{idEjemplar}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EjemplarDto> actualizaEjemplarIdParam(@PathVariable Long idEjemplar, @Validated @RequestBody NewEjemplarDto updatedEjemplar) throws MiValidationException {
		
		ejemplarService.updateEjemplar(idEjemplar,updatedEjemplar);
		EjemplarDto dto=ejemplarService.getEjemplar(idEjemplar);
		log.info("Ejemplar actualizado");

		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	@DeleteMapping(path = "/{idEjemplar}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void deleteEjemplar(@PathVariable Long idEjemplar) throws MiValidationException {
		ejemplarService.deleteEjemplar(idEjemplar);
	}
	
	@PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EjemplarDto> actualizaEjemplar(@Validated @RequestBody EjemplarDto updatedEjemplar) throws MiValidationException {
		
		ejemplarService.updateEjemplar(updatedEjemplar);
		return ResponseEntity.status(HttpStatus.OK).body(ejemplarService.getEjemplar(updatedEjemplar.getId()));
	}
}
