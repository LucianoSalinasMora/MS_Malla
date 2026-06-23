package SigueTuCarrera.Malla.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import SigueTuCarrera.Malla.model.Carrera;
import SigueTuCarrera.Malla.service.CarreraService;

@RestController
@RequestMapping("/api/v0/carreras")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @PostMapping
    public Carrera guardar(@RequestBody Carrera carrera){
        return carreraService.guardarCarrera(carrera);
    }

    @GetMapping
    public List<Carrera> listar(){
        return carreraService.listarCarreras();
    }

    @GetMapping("/{id}")
    public Carrera buscar(@PathVariable Long id){
        return carreraService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        carreraService.eliminarCarrera(id);
    }
}