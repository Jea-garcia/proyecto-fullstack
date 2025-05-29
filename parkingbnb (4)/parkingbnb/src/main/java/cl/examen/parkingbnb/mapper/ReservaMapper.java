package cl.examen.parkingbnb.mapper;

import org.springframework.stereotype.Component;

import cl.examen.parkingbnb.dto.ClienteDTO;
import cl.examen.parkingbnb.dto.EstacionamientoDTO;
import cl.examen.parkingbnb.dto.ReservaDTO;
import cl.examen.parkingbnb.model.ClienteModel;
import cl.examen.parkingbnb.model.EstacionamientoModel;
import cl.examen.parkingbnb.model.ReservaModel;

@Component
public class ReservaMapper {

    public ReservaModel toEntity(ReservaDTO dto) {
        if (dto == null) return null;
        ReservaModel model = new ReservaModel();
        model.setId(dto.getId());
        model.setCliente(new ClienteModel(dto.getCliente().getRut(), null, null, null, null, null, null, null, null, null, null)); 
        model.setEstacionamiento(new EstacionamientoModel(dto.getEstacionamiento().getId())); // Similar
        model.setFechaHoraInicio(dto.getFechaHoraInicio());
        model.setFechaHoraFin(dto.getFechaHoraFin());
        model.setEstado(dto.getEstado());
        model.setTotal(dto.getTotal());
        return model;
    }

    public ReservaDTO toDTO(ReservaModel model) {
        if (model == null) return null;
        ReservaDTO dto = new ReservaDTO();
        dto.setId(model.getId());
        dto.setCliente(new ClienteDTO(model.getCliente().getRut(), null, null, null, null, null, null, null, null, null, null)); // Similar
        dto.setEstacionamiento(new EstacionamientoDTO(0, null, null, null, model.getEstacionamiento().getId())); 
        dto.setFechaHoraInicio(model.getFechaHoraInicio());
        dto.setFechaHoraFin(model.getFechaHoraFin());
        dto.setEstado(model.getEstado());
        dto.setTotal(model.getTotal());
        return dto;
    }
}
