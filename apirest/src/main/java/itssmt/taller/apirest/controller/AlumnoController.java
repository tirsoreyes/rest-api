package itssmt.taller.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import itssmt.taller.apirest.model.Alumno;
import itssmt.taller.apirest.model.Respuesta;
import itssmt.taller.apirest.service.IAlumnoService;

@RestController
@RequestMapping("/rest/")
public class AlumnoController {
	@Autowired IAlumnoService alumnoService;
	
	@GetMapping(value="alumnos")
	public ResponseEntity<Respuesta<List<Alumno>>> obtenAlumnos(){
		return alumnoService.obtenAlumnos();
	}
	
	@GetMapping(value="alumnos/{control}")
	public ResponseEntity<Respuesta<Alumno>> obtenAlumno(@PathVariable (value="control", required=true) int control){
				return alumnoService.obtenAlumno(control);
	}
	
	
	

}
