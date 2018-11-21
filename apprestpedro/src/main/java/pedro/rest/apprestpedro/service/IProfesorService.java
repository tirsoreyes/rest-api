package pedro.rest.apprestpedro.service;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import pedro.rest.apprestpedro.modelo.Profesor;
import pedro.rest.apprestpedro.modelo.RespuestaGenerica;

@Component
public interface IProfesorService {

	public ResponseEntity<RespuestaGenerica<Profesor>> obtenProfesorPorId(int id);

	public ResponseEntity<RespuestaGenerica<List<Profesor>>> obtenProfesoresPorEdad(int edad);

	public ResponseEntity<RespuestaGenerica<List<Profesor>>> obtenProfesoresPorSexo(String sexo);

	public ResponseEntity<RespuestaGenerica<?>> agregaProfesor(Profesor p);

}
