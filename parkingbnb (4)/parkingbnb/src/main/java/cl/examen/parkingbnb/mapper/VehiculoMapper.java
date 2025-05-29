package cl.examen.parkingbnb.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.examen.parkingbnb.dto.VehiculoDTO;
import cl.examen.parkingbnb.model.ClienteModel;
import cl.examen.parkingbnb.model.VehiculoModel;
import cl.examen.parkingbnb.repository.ClienteRepository;

@Component
public class VehiculoMapper {

    @Autowired
    private ClienteRepository clienteRepository;

    public VehiculoModel toModel(VehiculoDTO dto) {
        VehiculoModel model = new VehiculoModel();
        model.setPatente(dto.getPatente());

        // Buscar ClienteModel a partir del rut
        ClienteModel cliente = clienteRepository.findById(dto.getClienteRut())
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado con RUT: " + dto.getClienteRut()));
        model.setCliente(cliente);

        model.setMarca(dto.getMarca());
        model.setModelo(dto.getModelo());
        model.setColor(dto.getColor());
        model.setTipo(dto.getTipo());

        return model;
    }

    public VehiculoDTO toDTO(VehiculoModel model) {
        VehiculoDTO dto = new VehiculoDTO();
        dto.setPatente(model.getPatente());
        dto.setClienteRut(model.getCliente().getRut()); // solo el RUT
        dto.setMarca(model.getMarca());
        dto.setModelo(model.getModelo());
        dto.setColor(model.getColor());
        dto.setTipo(model.getTipo());

        return dto;
    }
}
