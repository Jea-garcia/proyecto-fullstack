package cl.examen.parkingbnb.mapper;

import cl.examen.parkingbnb.dto.ComunaDTO;
import cl.examen.parkingbnb.model.ComunaModel;

public class ComunaMapper {

    public static ComunaDTO toDTO(ComunaModel model) {
        ComunaDTO dto = new ComunaDTO();
        dto.setId(model.getId());
        dto.setNombre(model.getNombre());
        // dto.setRegion(...) si tienes esa relación implementada
        return dto;
    }

    public static ComunaModel toEntity(ComunaDTO dto) {
        ComunaModel model = new ComunaModel();
        model.setId(dto.getId());
        model.setNombre(dto.getNombre());
        // model.setRegion(...) si tienes esa relación implementada
        return model;
    }
}
