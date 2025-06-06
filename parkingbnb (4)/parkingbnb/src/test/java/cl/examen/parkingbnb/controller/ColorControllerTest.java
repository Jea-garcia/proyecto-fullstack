package cl.examen.parkingbnb.controller;

import cl.examen.parkingbnb.dto.ColorDTO;
import cl.examen.parkingbnb.service.IColorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(ColorController.class)
public class ColorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IColorService colorService;

    @Autowired
    private ObjectMapper objectMapper;

    private ColorDTO getColorMock() {
        ColorDTO color = new ColorDTO();
        color.setNombre("Rojo");
        return color;
    }

    @Test // Test para insertar un color
    public void testInsertColor() throws Exception {
        ColorDTO color = getColorMock();
        Mockito.when(colorService.insert(any(ColorDTO.class))).thenReturn(color);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/crud/color")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(color)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Rojo"));
    }

    @Test // Test para insertar un color con nombre vacío  
    public void testInsertColor_NombreVacio_DeberiaRetornarBadRequest() throws Exception {
        ColorDTO color = new ColorDTO();
        color.setNombre(""); // Campo vacío

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/crud/color")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(color)))
                .andExpect(status().isBadRequest());
    }
}