package cl.examen.parkingbnb.service;

import java.util.List;

import cl.examen.parkingbnb.dto.UsuarioDTO;

public interface IUsuarioService {

    UsuarioDTO save(UsuarioDTO usuario);

    UsuarioDTO update(Integer id, UsuarioDTO usuario);

    UsuarioDTO delete(Integer id);

    UsuarioDTO getById(Integer id);

    List<UsuarioDTO> getAll();

    Object insert(UsuarioDTO any);

    UsuarioDTO login(String username, String password);


}
