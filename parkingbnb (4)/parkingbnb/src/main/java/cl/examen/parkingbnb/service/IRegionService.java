package cl.examen.parkingbnb.service;

import java.util.List;
import cl.examen.parkingbnb.dto.RegionDTO;

public interface IRegionService {
    RegionDTO getById(Integer id);
    List<RegionDTO> getAll();
}
