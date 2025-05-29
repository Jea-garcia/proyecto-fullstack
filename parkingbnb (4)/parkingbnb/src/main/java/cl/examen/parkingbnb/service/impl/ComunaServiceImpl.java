package cl.examen.parkingbnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.examen.parkingbnb.dto.ComunaDTO;
import cl.examen.parkingbnb.model.ComunaModel;
import cl.examen.parkingbnb.repository.ComunaRepository;
import cl.examen.parkingbnb.service.IComunaService;

@Service
public class ComunaServiceImpl implements IComunaService {

    @Autowired
    ComunaRepository repositoryComuna;

    private ComunaModel toEntity(ComunaDTO dto) {
        ComunaModel model = new ComunaModel();
        model.setId(dto.getId());
        model.setNombre(dto.getNombre());
        return model;
    }

    private ComunaDTO toDTO(ComunaModel model) {
        ComunaDTO dto = new ComunaDTO();
        dto.setId(model.getId());
        dto.setNombre(model.getNombre());
        return dto;
    }

    @Override
    public ComunaDTO insert(ComunaDTO comuna) {
        ComunaModel saved = repositoryComuna.save(toEntity(comuna));
        return toDTO(saved);
    }

    @Override
    public ComunaDTO update(Long id, ComunaDTO comuna) {
        ComunaModel existing = repositoryComuna.findById(id).orElseThrow();
        existing.setNombre(comuna.getNombre());
        return toDTO(repositoryComuna.save(existing));
    }

    @Override
    public ComunaDTO delete(Long id) {
        ComunaModel comuna = repositoryComuna.findById(id).orElseThrow();
        repositoryComuna.deleteById(id);
        return toDTO(comuna);
    }

    @Override
    public ComunaDTO getById(Long id) {
        return toDTO(repositoryComuna.findById(id).orElseThrow());
    }

    @Override
    public List<ComunaDTO> getAll() {
        return repositoryComuna.findAll().stream().map(this::toDTO).toList();
    }
}
