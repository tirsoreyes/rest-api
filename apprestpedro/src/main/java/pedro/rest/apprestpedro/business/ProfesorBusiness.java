package pedro.rest.apprestpedro.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pedro.rest.apprestpedro.entity.TProfesor;
import pedro.rest.apprestpedro.modelo.Profesor;
import pedro.rest.apprestpedro.modelo.RespuestaGenerica;
import pedro.rest.apprestpedro.repository.IProfesorRepo;
import pedro.rest.apprestpedro.service.IProfesorService;


@Service
public class ProfesorBusiness implements IProfesorService{
	private final static Logger logger = LoggerFactory.getLogger(ProfesorBusiness.class);
	@Autowired IProfesorRepo profesorRepo;

	@Override
	public ResponseEntity<RespuestaGenerica<Profesor>> obtenProfesorPorId(int id) {
		RespuestaGenerica<Profesor> respuesta = new RespuestaGenerica<>();
		
		try {
			Optional<TProfesor> p = profesorRepo.findById(id);
			if(!p.isPresent())
				return new ResponseEntity<RespuestaGenerica<Profesor>>(HttpStatus.NO_CONTENT);
			
			respuesta.setCodigo(200);
			respuesta.setMensaje("");
			Profesor cuerpo = new Profesor();
			cuerpo.setApellidos(p.get().getApellidos());
			cuerpo.setEdad(p.get().getEdad());
			cuerpo.setNombre(p.get().getNombre());
			cuerpo.setSexo(p.get().getSexo());
			respuesta.setCuerpo(cuerpo);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			respuesta.setCodigo(500);
			respuesta.setMensaje("Servicio temporalmente Inactivo, Intente más tarde.");
			return new ResponseEntity<RespuestaGenerica<Profesor>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return new ResponseEntity<RespuestaGenerica<Profesor>>(respuesta,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<RespuestaGenerica<List<Profesor>>> obtenProfesoresPorEdad(int edad) {
		RespuestaGenerica<List<Profesor>> respuesta = new RespuestaGenerica<>();
		try {
			List<TProfesor> lista = profesorRepo.findByEdad(edad);
			if(lista==null || lista.isEmpty())
				return new ResponseEntity<RespuestaGenerica<List<Profesor>>>(HttpStatus.NO_CONTENT);
			
			List<Profesor> cuerpo = new ArrayList<>();
			for(TProfesor p : lista){
				Profesor profesor = new Profesor();
				profesor.setApellidos(p.getApellidos());
				profesor.setEdad(p.getEdad());
				profesor.setNombre(p.getNombre());
				profesor.setSexo(p.getSexo());
				
				cuerpo.add(profesor);
			}
			respuesta.setCodigo(200);
			respuesta.setMensaje("");
			respuesta.setCuerpo(cuerpo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			respuesta.setCodigo(500);
			respuesta.setMensaje("Servicio temporalmente Inactivo, Intente más tarde.");
			return new ResponseEntity<RespuestaGenerica<List<Profesor>>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<RespuestaGenerica<List<Profesor>>>(respuesta,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<RespuestaGenerica<List<Profesor>>> obtenProfesoresPorSexo(String sexo) {
		RespuestaGenerica<List<Profesor>> respuesta = new RespuestaGenerica<>();
		try{
			List<TProfesor> lista = profesorRepo.findBySexo(sexo);
			if(lista==null || lista.isEmpty())
				return new ResponseEntity<RespuestaGenerica<List<Profesor>>>(HttpStatus.NO_CONTENT);
			List<Profesor> cuerpo = new ArrayList<>();
			for(TProfesor p : lista){
				Profesor profesor = new Profesor();
				profesor.setApellidos(p.getApellidos());
				profesor.setEdad(p.getEdad());
				profesor.setNombre(p.getNombre());
				profesor.setSexo(p.getSexo());
				
				cuerpo.add(profesor);
			}
			respuesta.setCodigo(200);
			respuesta.setMensaje("");
			respuesta.setCuerpo(cuerpo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			respuesta.setCodigo(500);
			respuesta.setMensaje("Servicio temporalmente Inactivo, Intente más tarde.");
			return new ResponseEntity<RespuestaGenerica<List<Profesor>>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<RespuestaGenerica<List<Profesor>>>(respuesta,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<RespuestaGenerica<?>> agregaProfesor(Profesor p) {
		RespuestaGenerica<String> respuesta = new RespuestaGenerica<>();
		try {
			TProfesor profe = new TProfesor();
			profe.setApellidos(p.getApellidos());
			profe.setEdad(p.getEdad());
			profe.setNombre(p.getNombre());
			profe.setSexo(p.getSexo());
			
			profesorRepo.save(profe);
			respuesta.setCodigo(200);
			respuesta.setMensaje("Alta correcta con id "+profe.getId());
			respuesta.setCuerpo("Todo perfecto!!");
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			respuesta.setCodigo(500);
			respuesta.setMensaje("Servicio temporalmente Inactivo, Intente más tarde.");
			return new ResponseEntity<RespuestaGenerica<?>>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		  
		return new ResponseEntity<RespuestaGenerica<?>>(respuesta,HttpStatus.OK);
	}

}
