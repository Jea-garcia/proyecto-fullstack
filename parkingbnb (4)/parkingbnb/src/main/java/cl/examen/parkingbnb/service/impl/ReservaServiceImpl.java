package cl.examen.parkingbnb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.examen.parkingbnb.dto.ReservaDTO;
import cl.examen.parkingbnb.mapper.ReservaMapper;
import cl.examen.parkingbnb.model.ReservaModel;
import cl.examen.parkingbnb.repository.ReservaRepository;
import cl.examen.parkingbnb.service.IReservaService;

@Service
public class ReservaServiceImpl implements IReservaService {

    @Autowired
    ReservaRepository repositoryReserva;

    @Autowired
    ReservaMapper mapper;  // Mapper que convierte DTO <-> Model

    @Override
    public ReservaDTO save(ReservaDTO reservaDTO) {
        ReservaModel reservaModel = mapper.toEntity(reservaDTO);
        ReservaModel saved = repositoryReserva.save(reservaModel);
        return mapper.toDTO(saved);
    }

    @Override
    public ReservaDTO update(Integer id, ReservaDTO reservaDTO) {
        ReservaModel reservaModel = mapper.toEntity(reservaDTO);
        reservaModel.setId(id);
        ReservaModel updated = repositoryReserva.save(reservaModel);
        return mapper.toDTO(updated);
    }

    @Override
    public ReservaDTO delete(Integer id) {
        ReservaModel reservaModel = repositoryReserva.findById(id).orElse(null);
        if (reservaModel != null) {
            repositoryReserva.delete(reservaModel);
            return mapper.toDTO(reservaModel);
        }
        return null;
    }

    @Override
    public ReservaDTO getById(Integer id) {
        return repositoryReserva.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<ReservaDTO> getAll() {
        List<ReservaDTO> lista = new ArrayList<>();
        repositoryReserva.findAll().forEach(reserva -> lista.add(mapper.toDTO(reserva)));
        return lista;
    }
}
