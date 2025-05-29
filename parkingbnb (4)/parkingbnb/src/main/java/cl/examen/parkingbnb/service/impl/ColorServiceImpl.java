package cl.examen.parkingbnb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.examen.parkingbnb.dto.ColorDTO;
import cl.examen.parkingbnb.model.ColorModel;
import cl.examen.parkingbnb.repository.ColorRepository;
import cl.examen.parkingbnb.service.IColorService;

@Service
public class ColorServiceImpl implements IColorService {

    @Autowired
    private ColorRepository repository;

    // Helper para mapear Entity -> DTO
    private ColorDTO mapToDTO(ColorModel entity) {
        if (entity == null) return null;
        return new ColorDTO(entity.getId(), entity.getNombre());
    }

    // Helper para mapear DTO -> Entity
    private ColorModel mapToEntity(ColorDTO dto) {
        if (dto == null) return null;
        ColorModel entity = new ColorModel();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        return entity;
    }

    @Override
    public ColorDTO insert(ColorDTO color) {
        ColorModel entity = mapToEntity(color);
        entity.setId(null); // para que se genere id automático
        ColorModel saved = repository.save(entity);
        return mapToDTO(saved);
    }

    @Override
    public ColorDTO update(Integer id, ColorDTO color) {
        return repository.findById(id).map(existing -> {
            existing.setNombre(color.getNombre());
            ColorModel updated = repository.save(existing);
            return mapToDTO(updated);
        }).orElse(null); // o lanzar excepción si no existe
    }

    @Override
    public ColorDTO delete(Integer id) {
        return repository.findById(id).map(existing -> {
            repository.delete(existing);
            return mapToDTO(existing);
        }).orElse(null);
    }

    @Override
    public ColorDTO getById(Integer id) {
        return repository.findById(id).map(this::mapToDTO).orElse(null);
    }

    @Override
    public List<ColorDTO> getAll() {
        return ((List<ColorModel>)repository.findAll())
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
}
