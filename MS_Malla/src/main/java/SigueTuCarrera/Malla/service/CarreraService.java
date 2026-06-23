package SigueTuCarrera.Malla.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SigueTuCarrera.Malla.model.Carrera;
import SigueTuCarrera.Malla.repository.CarreraRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    public Carrera guardarCarrera(Carrera carrera){
        return carreraRepository.save(carrera);
    }

    public List<Carrera> listarCarreras(){
        return carreraRepository.findAll();
    }

    public Carrera buscarPorId(Long id){
        return carreraRepository.findById(id).orElse(null);
    }

    public void eliminarCarrera(Long id){
        carreraRepository.deleteById(id);
    }
}
