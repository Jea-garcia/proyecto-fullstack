package cl.examen.parkingbnb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.examen.parkingbnb.dto.ReservaDTO;
import cl.examen.parkingbnb.service.IReservaService;

@RestController
@RequestMapping("/api/crud/reserva")
public class ReservaController {
    @Autowired
    IReservaService serviceReserva;

    @PostMapping
    public ReservaDTO insert(@RequestBody ReservaDTO reserva) {
        return serviceReserva.save(reserva);
    }
    @PutMapping("/{id}")
    public ReservaDTO update(@PathVariable Integer id, @RequestBody ReservaDTO reserva) {
        return serviceReserva.update(id, reserva);
    }
    @DeleteMapping("/{id}")
    public ReservaDTO delete(@PathVariable Integer id){
        return serviceReserva.delete(id);
    }
    @GetMapping("/{id}")
    public ReservaDTO getById(@PathVariable Integer id) {
        return serviceReserva.getById(id);
    }
    @GetMapping
    public List<ReservaDTO>getAll(){
        return serviceReserva.getAll();
    }

}
