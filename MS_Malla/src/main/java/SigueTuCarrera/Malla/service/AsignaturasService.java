package SigueTuCarrera.Malla.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SigueTuCarrera.Malla.model.Asignaturas;
import SigueTuCarrera.Malla.repository.AsignaturasRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AsignaturasService {

    @Autowired
    private AsignaturasRepository asignaturasRepository;

    public Asignaturas guardarAsignatura(Asignaturas asignatura){
        return asignaturasRepository.save(asignatura);
    }

    public List<Asignaturas> listarAsignaturas(){
        return asignaturasRepository.findAll();
    }

    public Asignaturas buscarPorCodigo(String codigo){
        return asignaturasRepository.findById(codigo).orElse(null);
    }

    public void eliminarAsignatura(String codigo){
        asignaturasRepository.deleteById(codigo);
    }
}