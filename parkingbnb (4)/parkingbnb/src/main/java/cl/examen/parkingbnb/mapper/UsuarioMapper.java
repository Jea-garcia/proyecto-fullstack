package cl.examen.parkingbnb.mapper;

import cl.examen.parkingbnb.dto.UsuarioDTO;
import cl.examen.parkingbnb.model.UsuarioModel;

public class UsuarioMapper {

    public static UsuarioModel toModel(UsuarioDTO dto) {
        UsuarioModel model = new UsuarioModel();
        model.setId(dto.getId());
        model.setRut(dto.getRut());
        model.setUsername(dto.getUsername());
        model.setPassword(dto.getPassword());
        model.setRol(dto.getRol());
        model.setEmail(dto.getEmail());
        return model;
    }

    public static UsuarioDTO toDTO(UsuarioModel model) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(model.getId());
        dto.setRut(model.getRut());
        dto.setUsername(model.getUsername());
        dto.setPassword(model.getPassword());
        dto.setRol(model.getRol());
        dto.setEmail(model.getEmail());
        return dto;
    }
}