package SigueTuCarrera.Malla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SigueTuCarrera.Malla.model.Carrera;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long>{

}
