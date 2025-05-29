package cl.examen.parkingbnb.service.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.examen.parkingbnb.dto.MultasDTO;
import cl.examen.parkingbnb.mapper.MultasMapper;
import cl.examen.parkingbnb.model.MultasModel;
import cl.examen.parkingbnb.repository.MultasRepository;
import cl.examen.parkingbnb.service.IMultasService;

@Service
public class MultasServiceImpl implements IMultasService {

    @Autowired
    private MultasRepository repositoryMultas;

    @Autowired
    private MultasMapper mapper;

    @Override
    public MultasDTO save(MultasDTO multasDTO) {
        return mapper.toDTO(repositoryMultas.save(mapper.toEntity(multasDTO)));
    }

    @Override
    public MultasDTO update(Integer id, MultasDTO multasDTO) {
        MultasModel multaModel = mapper.toEntity(multasDTO);
        multaModel.setId(id);
        return mapper.toDTO(repositoryMultas.save(multaModel));
    }

    @Override
    public MultasDTO delete(Integer id) {
        return repositoryMultas.findById(id).map(multa -> {
            repositoryMultas.delete(multa);
            return mapper.toDTO(multa);
        }).orElse(null);
    }

    @Override
    public MultasDTO getById(Integer id) {
        return repositoryMultas.findById(id).map(mapper::toDTO).orElse(null);
    }

    @Override
    public List<MultasDTO> getAll() {
        List<MultasDTO> lista = new ArrayList<>();
        repositoryMultas.findAll().forEach(multa -> lista.add(mapper.toDTO(multa)));
        return lista;
    }
}
