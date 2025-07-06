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

        ClienteDTO clienteDto = dto.getCliente();
        if (clienteDto != null && clienteDto.getRut() != null) {
            ClienteModel cliente = new ClienteModel();
            cliente.setRut(clienteDto.getRut());
            model.setCliente(cliente);
        }

        EstacionamientoDTO estDto = dto.getEstacionamiento();
        if (estDto != null && estDto.getId() > 0) {
            EstacionamientoModel est = new EstacionamientoModel();
            est.setId((long) estDto.getId()); // Conversión a Long si tu modelo usa Long
            model.setEstacionamiento(est);
        }

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

        ClienteModel clienteModel = model.getCliente();
        if (clienteModel != null && clienteModel.getRut() != null) {
            ClienteDTO clienteDto = new ClienteDTO();
            clienteDto.setRut(clienteModel.getRut());
            dto.setCliente(clienteDto);
        }

        EstacionamientoModel estModel = model.getEstacionamiento();
        if (estModel != null && estModel.getId() != null && estModel.getId() > 0) {
            EstacionamientoDTO estDto = new EstacionamientoDTO();
            estDto.setId(estModel.getId().intValue()); // Conversión de Long a int si es necesario
            dto.setEstacionamiento(estDto);
        }

        dto.setFechaHoraInicio(model.getFechaHoraInicio());
        dto.setFechaHoraFin(model.getFechaHoraFin());
        dto.setEstado(model.getEstado());
        dto.setTotal(model.getTotal());

        return dto;
    }
}
