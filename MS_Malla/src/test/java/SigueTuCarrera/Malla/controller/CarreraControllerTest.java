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

import SigueTuCarrera.Malla.model.Carrera;
import SigueTuCarrera.Malla.service.CarreraService;

@WebMvcTest(CarreraController.class)
class CarreraControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarreraService carreraService;

    @Autowired
    private ObjectMapper objectMapper;

    private Carrera carreraPrueba;

    @BeforeEach
    void setUp() {
        carreraPrueba = new Carrera();
        carreraPrueba.setCarreraId(1L);
        carreraPrueba.setNombreCarrera("Medicina");
        carreraPrueba.setDuracionSemestres(10);
    }

    @Test
    void testGuardar_RetornaCarreraCreada() throws Exception {
        when(carreraService.guardarCarrera(any(Carrera.class))).thenReturn(carreraPrueba);

        mockMvc.perform(post("/api/v0/carreras")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(carreraPrueba)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.carreraId").value(1))
                .andExpect(jsonPath("$.nombreCarrera").value("Medicina"))
                .andExpect(jsonPath("$.duracionSemestres").value(10));
    }

    @Test
    void testListar_RetornaListaDeCarreras() throws Exception {
        when(carreraService.listarCarreras()).thenReturn(Arrays.asList(carreraPrueba));

        mockMvc.perform(get("/api/v0/carreras"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].carreraId").value(1))
                .andExpect(jsonPath("$[0].nombreCarrera").value("Medicina"));
    }

    @Test
    void testBuscar_RetornaCarrera() throws Exception {
        when(carreraService.buscarPorId(1L)).thenReturn(carreraPrueba);

        mockMvc.perform(get("/api/v0/carreras/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.carreraId").value(1))
                .andExpect(jsonPath("$.nombreCarrera").value("Medicina"));
    }

    @Test
    void testEliminar_RetornaStatusOk() throws Exception {
        doNothing().when(carreraService).eliminarCarrera(1L);

        mockMvc.perform(delete("/api/v0/carreras/1"))
                .andExpect(status().isOk());

        verify(carreraService, times(1)).eliminarCarrera(1L);
    }
}