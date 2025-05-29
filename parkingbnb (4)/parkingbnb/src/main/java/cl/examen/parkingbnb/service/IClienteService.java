package cl.examen.parkingbnb.service;

import java.util.List;
import cl.examen.parkingbnb.dto.ClienteDTO;

public interface IClienteService {
    ClienteDTO insert(ClienteDTO cliente);
    ClienteDTO update(String rut, ClienteDTO cliente);
    ClienteDTO delete(String rut);
    ClienteDTO getByRut(String rut);
    List<ClienteDTO> getAll();
}
