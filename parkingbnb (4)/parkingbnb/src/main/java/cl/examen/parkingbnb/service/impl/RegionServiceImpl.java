package cl.examen.parkingbnb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.examen.parkingbnb.dto.RegionDTO;
import cl.examen.parkingbnb.model.RegionModel;
import cl.examen.parkingbnb.repository.RegionRepository;
import cl.examen.parkingbnb.service.IRegionService;

@Service
public class RegionServiceImpl implements IRegionService {
    @Autowired
    RegionRepository repositoryRegion;

    @Override
    public RegionDTO getById(Integer id) {
        RegionModel model = repositoryRegion.findById(id).orElse(null);
        if (model == null) return null;
        return new RegionDTO(model.getId(), model.getNombre());
    }

    @Override
    public List<RegionDTO> getAll() {
        List<RegionModel> regiones = repositoryRegion.findAll();
        return regiones.stream()
                       .map(r -> new RegionDTO(r.getId(), r.getNombre()))
                       .collect(Collectors.toList());
    }
}

