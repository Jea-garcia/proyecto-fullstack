package cl.examen.parkingbnb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.examen.parkingbnb.dto.VehiculoDTO;
import cl.examen.parkingbnb.mapper.VehiculoMapper;
import cl.examen.parkingbnb.model.VehiculoModel;
import cl.examen.parkingbnb.repository.VehiculoRepository;
import cl.examen.parkingbnb.service.IVehiculoService;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private VehiculoMapper vehiculoMapper;

    @Override
    public VehiculoDTO save(VehiculoDTO dto) {
        VehiculoModel model = vehiculoMapper.toEntity(dto);
        VehiculoModel saved = vehiculoRepository.save(model);
        return vehiculoMapper.toDTO(saved);
    }

    @Override
    public VehiculoDTO update(Long id, VehiculoDTO dto) {
        VehiculoModel existing = vehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
        existing.setPatente(dto.getPatente());
        existing.setMarca(dto.getMarca());
        existing.setModelo(dto.getModelo());
        existing.setAnio(dto.getAnio());

        if (dto.getClienteRut() != null) {
            existing.setCliente(new cl.examen.parkingbnb.model.ClienteModel());
            existing.getCliente().setRut(dto.getClienteRut());
        }

        VehiculoModel updated = vehiculoRepository.save(existing);
        return vehiculoMapper.toDTO(updated);
    }

    @Override
    public VehiculoDTO delete(Long id) {
        VehiculoModel model = vehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
        vehiculoRepository.delete(model);
        return vehiculoMapper.toDTO(model);
    }

    @Override
    public VehiculoDTO getById(Long id) {
        VehiculoModel model = vehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
        return vehiculoMapper.toDTO(model);
    }

    @Override
    public List<VehiculoDTO> getAll() {
        List<VehiculoModel> list = vehiculoRepository.findAll();
        return list.stream().map(vehiculoMapper::toDTO).collect(Collectors.toList());
    }
}
