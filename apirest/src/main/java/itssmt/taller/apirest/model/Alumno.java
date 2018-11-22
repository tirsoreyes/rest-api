package itssmt.taller.apirest.model;

import java.util.List;

public class Alumno {
	private int control;
	private String nombre;
	private int edad;
	private int grupo;
	private List<String> materias;
	
	
	public int getControl() {
		return control;
	}
	public void setControl(int control) {
		this.control = control;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getGrupo() {
		return grupo;
	}
	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}
	public List<String> getMaterias() {
		return materias;
	}
	public void setMaterias(List<String> materias) {
		this.materias = materias;
	}

	
}
