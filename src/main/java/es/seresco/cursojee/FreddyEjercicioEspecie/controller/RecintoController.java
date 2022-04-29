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

import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.NewRecintoDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.controller.dto.RecintoDto;
import es.seresco.cursojee.FreddyEjercicioEspecie.exceptions.MiValidationException;
import es.seresco.cursojee.FreddyEjercicioEspecie.services.RecintoService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/api/recintos")
@Slf4j
public class RecintoController {

	@Autowired
	private RecintoService recintoService;
	
	@GetMapping(path = "/{idRecinto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RecintoDto> getRecinto(@PathVariable Long idRecinto) throws MiValidationException {
		log.info("Obtiene la recinto por Id");
		RecintoDto recinto = recintoService.getRecinto(idRecinto);

		if (recinto != null) {
			return ResponseEntity.status(HttpStatus.OK).body(recinto);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RecintoDto> createRecinto(@Validated @RequestBody NewRecintoDto newRecinto) {
		log.info("Crea un recinto");
		RecintoDto recinto = recintoService.create(newRecinto);

		if (recinto != null) {
			return ResponseEntity.status(HttpStatus.OK).body(recinto);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RecintoDto>> getRecintos() throws MiValidationException {

		List<RecintoDto> recintosEncontradas = recintoService.findRecintos();

		if(recintosEncontradas.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(recintosEncontradas);
		}
	}
	
	@PutMapping(path = "/{idRecinto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RecintoDto> actualizaRecintoIdParam(@PathVariable Long idRecinto, @Validated @RequestBody NewRecintoDto updatedRecinto) throws MiValidationException {
		
		recintoService.updateRecinto(idRecinto,updatedRecinto);
		RecintoDto dto=recintoService.getRecinto(idRecinto);
		log.info("Recinto actualizado");

		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	@DeleteMapping(path = "/{idRecinto}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void deleteRecinto(@PathVariable Long idRecinto) throws MiValidationException {
		recintoService.deleteRecinto(idRecinto);
	}
	
	@PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RecintoDto> actualizaRecinto(@Validated @RequestBody RecintoDto updatedRecinto) throws MiValidationException {
		
		recintoService.updateRecinto(updatedRecinto);
		return ResponseEntity.status(HttpStatus.OK).body(recintoService.getRecinto(updatedRecinto.getId()));
	}
}
