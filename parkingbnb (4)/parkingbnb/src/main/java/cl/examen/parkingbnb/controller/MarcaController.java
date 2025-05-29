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

import cl.examen.parkingbnb.dto.MarcaDTO;
import cl.examen.parkingbnb.service.IMarcaService;

@RestController
@RequestMapping("/api/crud/marca")
public class MarcaController {
    @Autowired
    IMarcaService serviceMarca;
    @PostMapping
    public MarcaDTO insert(@RequestBody MarcaDTO marca) {
        return serviceMarca.save(marca);
    }
    @PutMapping("/{id}")
    public MarcaDTO update(@PathVariable Integer id, @RequestBody MarcaDTO marca) {
        return serviceMarca.update(id, marca);
    }
    @DeleteMapping("/{id}")
    public MarcaDTO delete(@PathVariable Integer id){
        return serviceMarca.delete(id);
    }
    @GetMapping("/{id}")
    public MarcaDTO getById(@PathVariable Integer id) {
        return serviceMarca.getById(id);
    }
    @GetMapping
    public List<MarcaDTO>getAll(){
        return serviceMarca.getAll();
    }


}
