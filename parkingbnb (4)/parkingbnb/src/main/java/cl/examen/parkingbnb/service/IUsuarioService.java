package cl.examen.parkingbnb.service;

import cl.examen.parkingbnb.dto.UsuarioDTO;
import java.util.List;

public interface IUsuarioService {

    UsuarioDTO insert(UsuarioDTO dto);

    UsuarioDTO update(Integer id, UsuarioDTO dto);

    UsuarioDTO getById(Integer id);

    List<UsuarioDTO> getAll();

    UsuarioDTO delete(Integer id);

    // Nuevo método para buscar usuario por username
    UsuarioDTO findByUsername(String username);

    // Puedes mantener login o eliminarlo si no usas
    UsuarioDTO login(String username, String password);
}
