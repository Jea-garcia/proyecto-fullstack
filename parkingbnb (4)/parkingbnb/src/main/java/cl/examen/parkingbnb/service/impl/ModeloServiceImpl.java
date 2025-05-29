package cl.examen.parkingbnb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.examen.parkingbnb.dto.ModeloDTO;
import cl.examen.parkingbnb.model.ModeloModel;
import cl.examen.parkingbnb.repository.ModeloRepository;
import cl.examen.parkingbnb.service.IModeloService;

@Service
public class ModeloServiceImpl implements IModeloService {
    @Autowired
    ModeloRepository repositoryModelo;

    @Override
    public ModeloDTO save(ModeloDTO dto) {
        ModeloModel entity = toEntity(dto);
        return toDTO(repositoryModelo.save(entity));
    }

    @Override
    public ModeloDTO update(Integer id, ModeloDTO dto) {
        ModeloModel entity = toEntity(dto);
        entity.setId(id); // asegúrate de establecer el ID
        return toDTO(repositoryModelo.save(entity));
    }

    @Override
    public ModeloDTO delete(Integer id) {
        ModeloDTO dto = getById(id);
        repositoryModelo.deleteById(id);
        return dto;
    }

    @Override
    public ModeloDTO getById(Integer id) {
        return toDTO(repositoryModelo.findById(id).orElseThrow());
    }

    @Override
    public List<ModeloDTO> getAll() {
        return ((List<ModeloModel>) repositoryModelo.findAll())
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private ModeloDTO toDTO(ModeloModel entity) {
        return new ModeloDTO(
            entity.getId(),
            entity.getNombre(),
            null // Aquí deberías mapear MarcaEntity -> MarcaDTO si lo necesitas
        );
    }

    private ModeloModel toEntity(ModeloDTO dto) {
        ModeloModel entity = new ModeloModel();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        return entity;
    }
}
