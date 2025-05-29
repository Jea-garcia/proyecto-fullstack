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

import cl.examen.parkingbnb.dto.HistorialReservasDTO;
import cl.examen.parkingbnb.service.IHistorialReservasService;

@RestController
@RequestMapping("/api/crud/historialReservas")
public class HistorialReservasController {
    @Autowired
    IHistorialReservasService serviceHistorialReservas;
    @PostMapping
    public HistorialReservasDTO insert(@RequestBody HistorialReservasDTO historialReservas) {
        return serviceHistorialReservas.save(historialReservas);
    }
    @PutMapping("/{id}")
    public HistorialReservasDTO update(@PathVariable Integer id, @RequestBody HistorialReservasDTO historialReservas) {
        return serviceHistorialReservas.update(id, historialReservas);
    }
    @DeleteMapping("/{id}")
    public HistorialReservasDTO delete(@PathVariable Integer id){
        return serviceHistorialReservas.delete(id);
    }
    @GetMapping("/{id}")
    public HistorialReservasDTO getById(@PathVariable Integer id) {
        return serviceHistorialReservas.getById(id);
    }
    @GetMapping
    public List<HistorialReservasDTO>getAll(){
        return serviceHistorialReservas.getAll();
    }

}
