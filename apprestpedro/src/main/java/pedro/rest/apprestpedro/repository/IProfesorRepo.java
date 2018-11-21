package pedro.rest.apprestpedro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pedro.rest.apprestpedro.entity.TProfesor;

@Repository
public interface IProfesorRepo extends JpaRepository<TProfesor, Integer>{
	public List<TProfesor> findByEdad(int edad);
	public List<TProfesor> findBySexo(String sexo);

}
