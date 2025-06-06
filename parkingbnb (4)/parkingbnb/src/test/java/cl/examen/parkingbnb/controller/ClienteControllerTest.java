package cl.examen.parkingbnb.controller;

import cl.examen.parkingbnb.dto.ClienteDTO;
import cl.examen.parkingbnb.service.IClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IClienteService clienteService;

    @Autowired
    private ObjectMapper objectMapper;

    private ClienteDTO getClienteMock() {
        ClienteDTO cliente = new ClienteDTO();
        cliente.setRut("12345678-9");
        cliente.setNombre("Juan Pérez");
        cliente.setEmail("juan@email.com");
        return cliente;
    }

    @Test // Insertar cliente
    public void testInsertCliente() throws Exception {
        ClienteDTO cliente = getClienteMock();
        Mockito.when(clienteService.insert(any(ClienteDTO.class))).thenReturn(cliente);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/crud/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rut").value(cliente.getRut()))
                .andExpect(jsonPath("$.nombre").value(cliente.getNombre()))
                .andExpect(jsonPath("$.email").value(cliente.getEmail()));
    }

    @Test // Actualizar cliente por RUT
    public void testUpdateCliente() throws Exception {
        ClienteDTO cliente = getClienteMock();
        Mockito.when(clienteService.update(eq(cliente.getRut()), any(ClienteDTO.class))).thenReturn(cliente);

        mockMvc.perform(MockMvcRequestBuilders
                .put("/api/crud/cliente/{rut}", cliente.getRut())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rut").value(cliente.getRut()))
                .andExpect(jsonPath("$.nombre").value(cliente.getNombre()))
                .andExpect(jsonPath("$.email").value(cliente.getEmail()));
    }

    @Test // Eliminar cliente por RUT
    public void testDeleteCliente() throws Exception {
        ClienteDTO cliente = getClienteMock();
        Mockito.when(clienteService.delete(cliente.getRut())).thenReturn(cliente);

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/crud/cliente/{rut}", cliente.getRut()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rut").value(cliente.getRut()))
                .andExpect(jsonPath("$.nombre").value(cliente.getNombre()))
                .andExpect(jsonPath("$.email").value(cliente.getEmail()));
    }

    @Test // Obtener cliente por RUT
    public void testGetByRut() throws Exception {
        ClienteDTO cliente = getClienteMock();
        Mockito.when(clienteService.getByRut(cliente.getRut())).thenReturn(cliente);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/crud/cliente/{rut}", cliente.getRut()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rut").value(cliente.getRut()))
                .andExpect(jsonPath("$.nombre").value(cliente.getNombre()))
                .andExpect(jsonPath("$.email").value(cliente.getEmail()));
    }

    @Test // Obtener todos los clientes
    public void testGetAllClientes() throws Exception {
        ClienteDTO cliente1 = getClienteMock();

        ClienteDTO cliente2 = new ClienteDTO();
        cliente2.setRut("98765432-1");
        cliente2.setNombre("María López");
        cliente2.setEmail("maria@email.com");

        List<ClienteDTO> clientes = Arrays.asList(cliente1, cliente2);
        Mockito.when(clienteService.getAll()).thenReturn(clientes);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/crud/cliente"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(clientes.size()))
                .andExpect(jsonPath("$[0].rut").value(cliente1.getRut()))
                .andExpect(jsonPath("$[1].rut").value(cliente2.getRut()));
    }
    @Test  //crear cliente con dato vacio
public void testInsertCliente_NombreVacio_DeberiaRetornarBadRequest() throws Exception {
    ClienteDTO cliente = new ClienteDTO();
    cliente.setRut("12345678-9");
    cliente.setNombre(""); // Nombre vacío
    cliente.setEmail("juan@email.com");

    mockMvc.perform(MockMvcRequestBuilders
            .post("/api/crud/cliente")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(cliente)))
            .andExpect(status().isBadRequest());
}
@Test // validar que el rut no sea vacio
public void testInsertCliente_RutVacio_DeberiaRetornarBadRequest() throws Exception {
    ClienteDTO cliente = new ClienteDTO();
    cliente.setRut(""); // RUT vacío
    cliente.setNombre("Juan Pérez");
    cliente.setEmail("juan@email.com");

    mockMvc.perform(MockMvcRequestBuilders
            .post("/api/crud/cliente")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(cliente)))
            .andExpect(status().isBadRequest());
}
}
