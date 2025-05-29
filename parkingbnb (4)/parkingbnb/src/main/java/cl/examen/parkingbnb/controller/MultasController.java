package cl.examen.parkingbnb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

import cl.examen.parkingbnb.dto.MultasDTO;
import cl.examen.parkingbnb.service.IMultasService;

@RestController
@RequestMapping("/api/crud/multas")
public class MultasController {

    @Autowired
    private IMultasService serviceMultas;

    @PostMapping
    public MultasDTO insert(@Valid @RequestBody MultasDTO multas) {
        return serviceMultas.save(multas);
    }

    @PutMapping("/{id}")
    public MultasDTO update(@PathVariable Integer id, @Valid @RequestBody MultasDTO multas) {
        return serviceMultas.update(id, multas);
    }

    @DeleteMapping("/{id}")
    public MultasDTO delete(@PathVariable Integer id) {
        return serviceMultas.delete(id);
    }

    @GetMapping("/{id}")
    public MultasDTO getById(@PathVariable Integer id) {
        return serviceMultas.getById(id);
    }

    @GetMapping
    public List<MultasDTO> getAll() {
        return serviceMultas.getAll();
    }
}