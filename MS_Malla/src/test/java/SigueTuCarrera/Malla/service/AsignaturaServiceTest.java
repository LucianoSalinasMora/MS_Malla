package SigueTuCarrera.Malla.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import SigueTuCarrera.Malla.model.Asignaturas;
import SigueTuCarrera.Malla.repository.AsignaturasRepository;

@ExtendWith(MockitoExtension.class)
class AsignaturasServiceTest {

    @Mock
    private AsignaturasRepository asignaturasRepository;

    @InjectMocks
    private AsignaturasService asignaturasService;

    private Asignaturas asignaturaPrueba;

    @BeforeEach
    void setUp() {
        asignaturaPrueba = new Asignaturas();
        asignaturaPrueba.setCodigoAsignatura("INF-324");
        asignaturaPrueba.setNombre("Estructuras de Datos");
        asignaturaPrueba.setCreditos(6);
        asignaturaPrueba.setSemestreSugerido(3);
        asignaturaPrueba.setPrerrequisitos(Arrays.asList("INF-112"));
    }

    @Test
    void testGuardarAsignatura() {
        when(asignaturasRepository.save(any(Asignaturas.class))).thenReturn(asignaturaPrueba);

        Asignaturas resultado = asignaturasService.guardarAsignatura(asignaturaPrueba);

        assertNotNull(resultado);
        assertEquals("INF-324", resultado.getCodigoAsignatura());
        verify(asignaturasRepository, times(1)).save(asignaturaPrueba);
    }

    @Test
    void testListarAsignaturas() {
        when(asignaturasRepository.findAll()).thenReturn(Arrays.asList(asignaturaPrueba));

        List<Asignaturas> resultado = asignaturasService.listarAsignaturas();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Estructuras de Datos", resultado.get(0).getNombre());
        verify(asignaturasRepository, times(1)).findAll();
    }

    @Test
    void testBuscarPorCodigo_Existe() {
        when(asignaturasRepository.findById("INF-324")).thenReturn(Optional.of(asignaturaPrueba));

        Asignaturas resultado = asignaturasService.buscarPorCodigo("INF-324");

        assertNotNull(resultado);
        assertEquals("INF-324", resultado.getCodigoAsignatura());
        verify(asignaturasRepository, times(1)).findById("INF-324");
    }

    @Test
    void testBuscarPorCodigo_NoExiste_RetornaNull() {
        when(asignaturasRepository.findById("XYZ-999")).thenReturn(Optional.empty());

        Asignaturas resultado = asignaturasService.buscarPorCodigo("XYZ-999");

        assertNull(resultado);
        verify(asignaturasRepository, times(1)).findById("XYZ-999");
    }

    @Test
    void testEliminarAsignatura() {
        doNothing().when(asignaturasRepository).deleteById("INF-324");

        asignaturasService.eliminarAsignatura("INF-324");

        verify(asignaturasRepository, times(1)).deleteById("INF-324");
    }
}