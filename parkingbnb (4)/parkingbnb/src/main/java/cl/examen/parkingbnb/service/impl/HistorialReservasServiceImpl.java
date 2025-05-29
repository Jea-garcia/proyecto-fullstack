package cl.examen.parkingbnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.examen.parkingbnb.dto.HistorialReservasDTO;
import cl.examen.parkingbnb.model.HistorialReservasModel;
import cl.examen.parkingbnb.repository.HistorialReservasRepository;
import cl.examen.parkingbnb.service.IHistorialReservasService;

@Service
public class HistorialReservasServiceImpl implements IHistorialReservasService {

    @Autowired
    private HistorialReservasRepository repository;

    private HistorialReservasDTO toDTO(HistorialReservasModel model) {
        HistorialReservasDTO dto = new HistorialReservasDTO();
        dto.setId(model.getId());
        dto.setClienteId(model.getCliente().getId());
        dto.setReservaId(model.getReserva().getId());
        dto.setFechaHora(model.getFechaHora());
        dto.setEstado(model.getEstado());
        return dto;
    }

    private HistorialReservasModel toEntity(HistorialReservasDTO dto) {
        HistorialReservasModel model = new HistorialReservasModel();
        model.setId(dto.getId());
        model.setFechaHora(dto.getFechaHora());
        model.setEstado(dto.getEstado());
        return model;
    }

    @Override
    public HistorialReservasDTO save(HistorialReservasDTO dto) {
        HistorialReservasModel model = toEntity(dto);
        model = repository.save(model);
        return toDTO(model);
    }

    @Override
    public HistorialReservasDTO update(Integer id, HistorialReservasDTO historialReservas) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public HistorialReservasDTO delete(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public HistorialReservasDTO getById(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public List<HistorialReservasDTO> getAll() {
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}
