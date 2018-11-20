package pedro.rest.apprestpedro.business;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pedro.rest.apprestpedro.modelo.Profesor;
import pedro.rest.apprestpedro.modelo.RespuestaGenerica;
import pedro.rest.apprestpedro.service.IProfesorService;

@Service
public class ProfesorBusiness implements IProfesorService{

	@Override
	public ResponseEntity<RespuestaGenerica<Profesor>> obtenProfesorPorId(int id) {
		RespuestaGenerica<Profesor> respuesta = new RespuestaGenerica<>();
		
		return new ResponseEntity<RespuestaGenerica<Profesor>>(respuesta,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<RespuestaGenerica<List<Profesor>>> obtenProfesoresPorEdad(int edad) {
		RespuestaGenerica<List<Profesor>> respuesta = new RespuestaGenerica<>();
		
		return new ResponseEntity<RespuestaGenerica<List<Profesor>>>(respuesta,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<RespuestaGenerica<List<Profesor>>> obtenProfesoresPorSexo(String sexo) {
		RespuestaGenerica<List<Profesor>> respuesta = new RespuestaGenerica<>();
		
		return new ResponseEntity<RespuestaGenerica<List<Profesor>>>(respuesta,HttpStatus.OK);
	}

}
