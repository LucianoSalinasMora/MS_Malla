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

import SigueTuCarrera.Malla.model.Carrera;
import SigueTuCarrera.Malla.repository.CarreraRepository;

@ExtendWith(MockitoExtension.class)
class CarreraServiceTest {

    @Mock
    private CarreraRepository carreraRepository;

    @InjectMocks
    private CarreraService carreraService;

    private Carrera carreraPrueba;

    @BeforeEach
    void setUp() {
        carreraPrueba = new Carrera();
        carreraPrueba.setCarreraId(1L);
        carreraPrueba.setNombreCarrera("Medicina");
        carreraPrueba.setDuracionSemestres(10);
    }

    @Test
    void testGuardarCarrera() {
        when(carreraRepository.save(any(Carrera.class))).thenReturn(carreraPrueba);

        Carrera resultado = carreraService.guardarCarrera(carreraPrueba);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getCarreraId());
        assertEquals("Medicina", resultado.getNombreCarrera());
        verify(carreraRepository, times(1)).save(carreraPrueba);
    }

    @Test
    void testListarCarreras() {
        when(carreraRepository.findAll()).thenReturn(Arrays.asList(carreraPrueba));

        List<Carrera> resultado = carreraService.listarCarreras();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Medicina", resultado.get(0).getNombreCarrera());
        verify(carreraRepository, times(1)).findAll();
    }

    @Test
    void testBuscarPorId_Existe() {
        when(carreraRepository.findById(1L)).thenReturn(Optional.of(carreraPrueba));

        Carrera resultado = carreraService.buscarPorId(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getCarreraId());
        verify(carreraRepository, times(1)).findById(1L);
    }

    @Test
    void testBuscarPorId_NoExiste_RetornaNull() {
        when(carreraRepository.findById(99L)).thenReturn(Optional.empty());

        Carrera resultado = carreraService.buscarPorId(99L);

        assertNull(resultado);
        verify(carreraRepository, times(1)).findById(99L);
    }

    @Test
    void testEliminarCarrera() {
        doNothing().when(carreraRepository).deleteById(1L);

        carreraService.eliminarCarrera(1L);

        verify(carreraRepository, times(1)).deleteById(1L);
    }
}