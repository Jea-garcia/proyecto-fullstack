package cl.examen.parkingbnb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.examen.parkingbnb.dto.ComunaDTO;
import cl.examen.parkingbnb.service.IComunaService;

@RestController
@RequestMapping("/api/crud/comuna")
public class ComunaController {
    @Autowired
    IComunaService serviceComuna;

    @PostMapping
    public ComunaDTO insert(@RequestBody ComunaDTO comuna) {
        return serviceComuna.insert(comuna);
    }

    @PutMapping("/{id}")
    public ComunaDTO update(@PathVariable Long id, @RequestBody ComunaDTO comuna) {
        return serviceComuna.update(id, comuna);
    }

    @DeleteMapping("/{id}")
    public ComunaDTO delete(@PathVariable Long id){
        return serviceComuna.delete(id);
    }

    @GetMapping("/{id}")
    public ComunaDTO getById(@PathVariable Long id) {
        return serviceComuna.getById(id);
    }

    @GetMapping
    public List<ComunaDTO> getAll(){
        return serviceComuna.getAll();
    }
}
