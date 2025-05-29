package cl.examen.parkingbnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.examen.parkingbnb.dto.PagoDTO;
import cl.examen.parkingbnb.model.PagoModel;
import cl.examen.parkingbnb.model.ReservaModel;
import cl.examen.parkingbnb.repository.PagoRepository;
import cl.examen.parkingbnb.repository.ReservaRepository;
import cl.examen.parkingbnb.service.IPagoService;
@Service
public class PagoServiceImpl implements IPagoService {

    @Autowired
    PagoRepository repositoryPago;

    @Autowired
    ReservaRepository reservaRepository;

    private PagoDTO toDTO(PagoModel pago) {
        PagoDTO dto = new PagoDTO();
        dto.setId(pago.getId());
        dto.setReservaId(pago.getReserva().getId());
        dto.setMonto(pago.getMonto());
        dto.setMetodoPago(pago.getMetodoPago());
        dto.setFechaPago(pago.getFechaPago());
        return dto;
    }

    private PagoModel toEntity(PagoDTO dto) {
        PagoModel pago = new PagoModel();
        pago.setId(dto.getId());
        ReservaModel reserva = reservaRepository.findById(dto.getReservaId())
                            .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        pago.setReserva(reserva);
        pago.setMonto(dto.getMonto());
        pago.setMetodoPago(dto.getMetodoPago());
        pago.setFechaPago(dto.getFechaPago());
        return pago;
    }

    @Override
    public PagoDTO save(PagoDTO pagoDto) {
        PagoModel pago = toEntity(pagoDto);
        pago = repositoryPago.save(pago);
        return toDTO(pago);
    }

    @Override
    public PagoDTO update(Integer id, PagoDTO pagoDto) {
        PagoModel pagoExistente = repositoryPago.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
        ReservaModel reserva = reservaRepository.findById(pagoDto.getReservaId())
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        pagoExistente.setReserva(reserva);
        pagoExistente.setMonto(pagoDto.getMonto());
        pagoExistente.setMetodoPago(pagoDto.getMetodoPago());
        pagoExistente.setFechaPago(pagoDto.getFechaPago());
        pagoExistente = repositoryPago.save(pagoExistente);
        return toDTO(pagoExistente);
    }

    @Override
    public PagoDTO delete(Integer id) {
        PagoModel pago = repositoryPago.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
        repositoryPago.deleteById(id);
        return toDTO(pago);
    }

    @Override
    public PagoDTO getById(Integer id) {
        PagoModel pago = repositoryPago.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
        return toDTO(pago);
    }

    @Override
    public List<PagoDTO> getAll() {
        List<PagoModel> lista = (List<PagoModel>) repositoryPago.findAll();
        return lista.stream().map(this::toDTO).toList();
    }
}
