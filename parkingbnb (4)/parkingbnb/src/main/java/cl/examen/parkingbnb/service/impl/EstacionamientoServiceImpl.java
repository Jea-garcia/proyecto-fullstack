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
        // Buscar la entidad por id
        EstacionamientoModel existente = repositoryEstacionamiento.findById(id.longValue()).orElseThrow(() -> new RuntimeException("No existe"));
        // Actualizar campos con dto
        existente.setCampo(dto.getCampo());  // Ejemplo, actualizar campos necesarios
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

    // Métodos de conversión
    private EstacionamientoModel dtoToEntity(EstacionamientoDTO dto) {
        EstacionamientoModel e = new EstacionamientoModel(null, null, null);
        e.setId(dto.getId());
        e.setCampo(dto.getCampo());
        // setear todos los campos necesarios
        return e;
    }

    private EstacionamientoDTO entityToDto(EstacionamientoModel e) {
        EstacionamientoDTO dto = new EstacionamientoDTO();
        dto.setId(e.getId());
        dto.setCampo(e.getCampo());
        // setear todos los campos necesarios
        return dto;
    }
}
