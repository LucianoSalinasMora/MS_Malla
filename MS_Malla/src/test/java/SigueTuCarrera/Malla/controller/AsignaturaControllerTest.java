package SigueTuCarrera.Malla.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import SigueTuCarrera.Malla.model.Asignaturas;
import SigueTuCarrera.Malla.service.AsignaturasService;

@WebMvcTest(AsignaturaController.class)
class AsignaturaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AsignaturasService asignaturasService;

    @Autowired
    private ObjectMapper objectMapper;

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
    void testGuardar_RetornaAsignaturaCreada() throws Exception {
        when(asignaturasService.guardarAsignatura(any(Asignaturas.class))).thenReturn(asignaturaPrueba);

        mockMvc.perform(post("/api/v0/asignaturas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(asignaturaPrueba)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.codigoAsignatura").value("INF-324"))
                .andExpect(jsonPath("$.nombre").value("Estructuras de Datos"))
                .andExpect(jsonPath("$.creditos").value(6));
    }

    @Test
    void testListar_RetornaListaDeAsignaturas() throws Exception {
        when(asignaturasService.listarAsignaturas()).thenReturn(Arrays.asList(asignaturaPrueba));

        mockMvc.perform(get("/api/v0/asignaturas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].codigoAsignatura").value("INF-324"))
                .andExpect(jsonPath("$[0].nombre").value("Estructuras de Datos"));
    }

    @Test
    void testBuscar_RetornaAsignatura() throws Exception {
        when(asignaturasService.buscarPorCodigo("INF-324")).thenReturn(asignaturaPrueba);

        mockMvc.perform(get("/api/v0/asignaturas/INF-324"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.codigoAsignatura").value("INF-324"))
                .andExpect(jsonPath("$.nombre").value("Estructuras de Datos"));
    }

    @Test
    void testEliminar_RetornaStatusOk() throws Exception {
        doNothing().when(asignaturasService).eliminarAsignatura("INF-324");

        mockMvc.perform(delete("/api/v0/asignaturas/INF-324"))
                .andExpect(status().isOk());

        verify(asignaturasService, times(1)).eliminarAsignatura("INF-324");
    }
}