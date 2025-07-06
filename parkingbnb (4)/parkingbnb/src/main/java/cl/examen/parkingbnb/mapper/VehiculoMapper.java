package cl.examen.parkingbnb.mapper;

import org.springframework.stereotype.Component;

import cl.examen.parkingbnb.dto.VehiculoDTO;
import cl.examen.parkingbnb.model.ClienteModel;
import cl.examen.parkingbnb.model.VehiculoModel;

@Component
public class VehiculoMapper {

    public VehiculoModel toEntity(VehiculoDTO dto) {
        if (dto == null) return null;
        VehiculoModel model = new VehiculoModel();
        model.setId(dto.getId());
        model.setPatente(dto.getPatente());
        model.setMarca(dto.getMarca());
        model.setModelo(dto.getModelo());
        model.setAnio(dto.getAnio());

        if (dto.getClienteRut() != null) {
            ClienteModel cliente = new ClienteModel();
            cliente.setRut(dto.getClienteRut());
            model.setCliente(cliente);
        }
        return model;
    }

    public VehiculoDTO toDTO(VehiculoModel model) {
        if (model == null) return null;
        VehiculoDTO dto = new VehiculoDTO();
        dto.setId(model.getId());
        dto.setPatente(model.getPatente());
        dto.setMarca(model.getMarca());
        dto.setModelo(model.getModelo());
        dto.setAnio(model.getAnio());

        if (model.getCliente() != null) {
            dto.setClienteRut(model.getCliente().getRut());
        }
        return dto;
    }
}
