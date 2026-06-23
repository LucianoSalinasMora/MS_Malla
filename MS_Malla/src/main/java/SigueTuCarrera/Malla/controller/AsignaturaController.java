package SigueTuCarrera.Malla.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import SigueTuCarrera.Malla.model.Asignaturas;
import SigueTuCarrera.Malla.service.AsignaturasService;

@RestController
@RequestMapping("/api/v0/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturasService asignaturasService;


    @PostMapping
    public Asignaturas guardar(@RequestBody Asignaturas asignatura){
        return asignaturasService.guardarAsignatura(asignatura);
    }

    @GetMapping
    public List<Asignaturas> listar(){
        return asignaturasService.listarAsignaturas();
    }

    @GetMapping("/{codigo}")
    public Asignaturas buscar(@PathVariable String codigo){
        return asignaturasService.buscarPorCodigo(codigo);
    }

    @DeleteMapping("/{codigo}")
    public void eliminar(@PathVariable String codigo){
        asignaturasService.eliminarAsignatura(codigo);
    }
}
