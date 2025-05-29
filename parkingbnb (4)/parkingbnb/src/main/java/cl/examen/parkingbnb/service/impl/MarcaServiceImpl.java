package cl.examen.parkingbnb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.examen.parkingbnb.dto.MarcaDTO;
import cl.examen.parkingbnb.model.MarcaModel;
import cl.examen.parkingbnb.repository.MarcaRepository;
import cl.examen.parkingbnb.service.IMarcaService;
@Service
public class MarcaServiceImpl implements IMarcaService {

    @Autowired
    private MarcaRepository repositoryMarca;

    private MarcaDTO convertToDTO(MarcaModel entity) {
        return new MarcaDTO(entity.getId(), entity.getNombre());
    }

    private MarcaModel convertToEntity(MarcaDTO dto) {
        return new MarcaModel(dto.getId(), dto.getNombre());
    }

    @Override
    public MarcaDTO save(MarcaDTO marcaDTO) {
        MarcaModel entity = convertToEntity(marcaDTO);
        MarcaModel saved = repositoryMarca.save(entity);
        return convertToDTO(saved);
    }

    @Override
    public MarcaDTO update(Integer id, MarcaDTO marcaDTO) {
        return repositoryMarca.findById(id)
            .map(existing -> {
                existing.setNombre(marcaDTO.getNombre());
                MarcaModel updated = repositoryMarca.save(existing);
                return convertToDTO(updated);
            }).orElseThrow(() -> new RuntimeException("Marca no encontrada con id " + id));
    }

    @Override
    public MarcaDTO delete(Integer id) {
        MarcaModel entity = repositoryMarca.findById(id)
            .orElseThrow(() -> new RuntimeException("Marca no encontrada con id " + id));
        repositoryMarca.deleteById(id);
        return convertToDTO(entity);
    }

    @Override
    public MarcaDTO getById(Integer id) {
        MarcaModel entity = repositoryMarca.findById(id)
            .orElseThrow(() -> new RuntimeException("Marca no encontrada con id " + id));
        return convertToDTO(entity);
    }

    @Override
    public List<MarcaDTO> getAll() {
        List<MarcaDTO> dtos = new ArrayList<>();
        repositoryMarca.findAll().forEach(entity -> dtos.add(convertToDTO(entity)));
        return dtos;
    }
}
