package itssmt.taller.apirest.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import itssmt.taller.apirest.model.Alumno;
import itssmt.taller.apirest.model.Respuesta;

@Component
public interface IAlumnoService {

	public ResponseEntity<Respuesta<List<Alumno>>> obtenAlumnos();

	public ResponseEntity<Respuesta<Alumno>> obtenAlumno(int control);

}
