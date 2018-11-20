package pedro.rest.apprestpedro.controller;

import java.util.List;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pedro.rest.apprestpedro.modelo.Profesor;
import pedro.rest.apprestpedro.modelo.RespuestaGenerica;
import pedro.rest.apprestpedro.service.IProfesorService;

@RestController
public class ProfesorController {
	@Autowired IProfesorService profesorService;

	
	@GetMapping(value="profesores/{id}")
	public ResponseEntity<RespuestaGenerica<Profesor>> obtenProfesorPorId(@PathVariable(value="id",required=true) int id){
		  return profesorService.obtenProfesorPorId(id);
	}
	
	
	@GetMapping(value="profesores/edad/{edad}")
	public ResponseEntity<RespuestaGenerica<List<Profesor>>> obtenProfesoresPorEdad(@PathVariable(value="edad", required=true) int edad){
		return profesorService.obtenProfesoresPorEdad(edad);
	}
	
	@GetMapping(value="profesores/sexo")
	public ResponseEntity<RespuestaGenerica<List<Profesor>>> obtenProfesoresPorSexo(@RequestParam(value="sexo", required=true) String sexo){
		return profesorService.obtenProfesoresPorSexo(sexo);
	}
	
}
