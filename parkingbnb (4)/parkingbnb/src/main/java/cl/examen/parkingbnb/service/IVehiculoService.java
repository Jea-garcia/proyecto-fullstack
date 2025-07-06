package cl.examen.parkingbnb.service;

import java.util.List;
import cl.examen.parkingbnb.dto.VehiculoDTO;

public interface IVehiculoService {

    VehiculoDTO save(VehiculoDTO vehiculo);

    VehiculoDTO update(Long id, VehiculoDTO vehiculo);

    VehiculoDTO delete(Long id);

    VehiculoDTO getById(Long id);

    List<VehiculoDTO> getAll();
}
