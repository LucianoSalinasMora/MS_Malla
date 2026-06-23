package SigueTuCarrera.Malla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SigueTuCarrera.Malla.model.Asignaturas;

@Repository
public interface AsignaturasRepository extends JpaRepository<Asignaturas, String>{

}
