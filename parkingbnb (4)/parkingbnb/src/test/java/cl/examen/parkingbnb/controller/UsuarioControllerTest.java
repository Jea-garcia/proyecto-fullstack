package cl.examen.parkingbnb.controller;

import cl.examen.parkingbnb.dto.UsuarioDTO;
import cl.examen.parkingbnb.service.IUsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IUsuarioService usuarioService;

    @Autowired
    private ObjectMapper objectMapper;

    private UsuarioDTO getUsuarioMock() {
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setId(1);
        usuario.setRut("12345678-9");
        usuario.setUsername("admin");
        usuario.setPassword("1234");
        usuario.setRol("ADMIN");
        usuario.setEmail("admin@correo.com");
        return usuario;
    }

    @Test // Test para insertar un usuario
    public void testInsertUsuario_OK() throws Exception {
        UsuarioDTO usuario = getUsuarioMock();
        Mockito.when(usuarioService.insert(any(UsuarioDTO.class))).thenReturn(usuario);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/crud/usuario")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("admin"));
    }

    @Test // Test para insertar un usuario con RUT vacío
    public void testInsertUsuario_RutVacio_BadRequest() throws Exception {
        UsuarioDTO usuario = getUsuarioMock();
        usuario.setRut("");

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/crud/usuario")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isBadRequest());
    }

    @Test // Test para insertar un usuario con username vacío
    public void testInsertUsuario_UsernameVacio_BadRequest() throws Exception {
        UsuarioDTO usuario = getUsuarioMock();
        usuario.setUsername("");

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/crud/usuario")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isBadRequest());
    }

    @Test // Test para insertar un usuario con contraseña vacía
    public void testInsertUsuario_EmailInvalido_BadRequest() throws Exception {
        UsuarioDTO usuario = getUsuarioMock();
        usuario.setEmail("correoSinArroba.com");

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/crud/usuario")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isBadRequest());
    }

    @Test // Test para actualizar un usuario
    public void testGetAllUsuarios() throws Exception {
        UsuarioDTO u1 = getUsuarioMock();
        UsuarioDTO u2 = new UsuarioDTO(2, "11111111-1", "cliente", "123", "CLIENTE", "cliente@correo.com");

        List<UsuarioDTO> usuarios = Arrays.asList(u1, u2);
        Mockito.when(usuarioService.getAll()).thenReturn(usuarios);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/crud/usuario"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[1].username").value("cliente"));
    }
}
