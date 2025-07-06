package cl.examen.parkingbnb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.examen.parkingbnb.dto.EstacionamientoDTO;
import cl.examen.parkingbnb.model.EstacionamientoModel;
import cl.examen.parkingbnb.repository.EstacionamientoRepository;
import cl.examen.parkingbnb.service.IEstacionamientoService;

@Service
public class EstacionamientoServiceImpl implements IEstacionamientoService {

    @Autowired
    EstacionamientoRepository repositoryEstacionamiento;

    @Override
    public EstacionamientoDTO save(EstacionamientoDTO dto) {
        EstacionamientoModel entidad = dtoToEntity(dto);
        EstacionamientoModel guardada = repositoryEstacionamiento.save(entidad);
        return entityToDto(guardada);
    }

    @Override
    public EstacionamientoDTO update(Integer id, EstacionamientoDTO dto) {
        EstacionamientoModel existente = repositoryEstacionamiento.findById(id.longValue())
                .orElseThrow(() -> new RuntimeException("No existe"));
        existente.setUbicacion(dto.getUbicacion());
        existente.setTipo(dto.getTipo());
        existente.setEstado(dto.getEstado());
        existente.setTarifa(dto.getTarifa());
        EstacionamientoModel actualizada = repositoryEstacionamiento.save(existente);
        return entityToDto(actualizada);
    }

    @Override
    public EstacionamientoDTO delete(Integer id) {
        EstacionamientoModel entidad = repositoryEstacionamiento.findById(id.longValue())
                .orElseThrow(() -> new RuntimeException("No existe"));
        repositoryEstacionamiento.delete(entidad);
        return entityToDto(entidad);
    }

    @Override
    public EstacionamientoDTO getById(Integer id) {
        EstacionamientoModel entidad = repositoryEstacionamiento.findById(id.longValue())
                .orElseThrow(() -> new RuntimeException("No existe"));
        return entityToDto(entidad);
    }

    @Override
    public List<EstacionamientoDTO> getAll() {
        List<EstacionamientoModel> entidades = repositoryEstacionamiento.findAll();
        return entidades.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    // Conversores
    private EstacionamientoModel dtoToEntity(EstacionamientoDTO dto) {
        EstacionamientoModel e = new EstacionamientoModel();
        e.setId(dto.getId() != 0 ? Long.valueOf(dto.getId()) : null);
        e.setUbicacion(dto.getUbicacion());
        e.setTipo(dto.getTipo());
        e.setEstado(dto.getEstado());
        e.setTarifa(dto.getTarifa());
        return e;
    }

    private EstacionamientoDTO entityToDto(EstacionamientoModel e) {
        EstacionamientoDTO dto = new EstacionamientoDTO();
        dto.setId(e.getId() != null ? e.getId().intValue() : 0);
        dto.setUbicacion(e.getUbicacion());
        dto.setTipo(e.getTipo());
        dto.setEstado(e.getEstado());
        dto.setTarifa(e.getTarifa());
        return dto;
    }
}
