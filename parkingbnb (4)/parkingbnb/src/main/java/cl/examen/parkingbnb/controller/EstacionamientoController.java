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

import cl.examen.parkingbnb.dto.EstacionamientoDTO;
import cl.examen.parkingbnb.service.IEstacionamientoService;

@RestController
@RequestMapping("/api/crud/estacionamiento")
public class EstacionamientoController {
    @Autowired
    IEstacionamientoService serviceEstacionamiento;
    @PostMapping
    public EstacionamientoDTO insert(@RequestBody EstacionamientoDTO estacionamiento) {
        return serviceEstacionamiento.save(estacionamiento);
    }
    @PutMapping("/{id}")
    public EstacionamientoDTO update(@PathVariable Integer id, @RequestBody EstacionamientoDTO estacionamiento) {
        return serviceEstacionamiento.update(id, estacionamiento);
    }
    @DeleteMapping("/{id}")
    public EstacionamientoDTO delete(@PathVariable Integer id){
        return serviceEstacionamiento.delete(id);
    }
    @GetMapping("/{id}")
    public EstacionamientoDTO getById(@PathVariable Integer id) {
        return serviceEstacionamiento.getById(id);
    }
    @GetMapping
    public List<EstacionamientoDTO>getAll(){
        return serviceEstacionamiento.getAll();
    }

}
