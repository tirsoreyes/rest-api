package itssmt.taller.apirest.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import itssmt.taller.apirest.model.Alumno;
import itssmt.taller.apirest.model.Respuesta;
import itssmt.taller.apirest.service.IAlumnoService;

@Service
public class AlumnoBusiness implements IAlumnoService {

	@Override
	public ResponseEntity<Respuesta<List<Alumno>>> obtenAlumnos() {
		List<Alumno> lista = new ArrayList<>();
		
		for(int i=0; i<10; i++){
			Alumno n = new Alumno();
			n.setControl(i+2947927);
			n.setEdad(i*2);
			n.setGrupo(1+1);
			n.setNombre("Nombre"+i);
			
			
			lista.add(n);
			
		}
		Respuesta r = new Respuesta<>();
		r.setCode(200);
		r.setMessage("todos ok");
		r.setResponse(lista);
		
		return new ResponseEntity<Respuesta<List<Alumno>>>(r,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Respuesta<Alumno>> obtenAlumno(int control) {
		Respuesta<Alumno> r = new Respuesta<>();
		    Alumno a = new Alumno();
		    
		    if(control==1000){
		    	r.setCode(204);
		    	r.setMessage("No existe este alumno ");
		    	return new ResponseEntity<Respuesta<Alumno>>(r,HttpStatus.NO_CONTENT);
		    }
		    
		    a.setControl(control);
		    a.setEdad(25);
		    a.setGrupo(101);
		    a.setNombre("Nombre de don juan");
		    r.setResponse(a);
		    
		return new ResponseEntity<Respuesta<Alumno>>(r,HttpStatus.OK);
	}

}
