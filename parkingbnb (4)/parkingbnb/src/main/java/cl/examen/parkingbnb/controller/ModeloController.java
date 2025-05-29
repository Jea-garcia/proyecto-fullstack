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

import cl.examen.parkingbnb.dto.ModeloDTO;
import cl.examen.parkingbnb.service.IModeloService;

@RestController
@RequestMapping("/api/crud/modelo")
public class ModeloController {
    @Autowired
    IModeloService serviceModelo;
    @PostMapping
    public ModeloDTO insert(@RequestBody ModeloDTO modelo) {
        return serviceModelo.save(modelo);
    }
    @PutMapping("/{id}")
    public ModeloDTO update(@PathVariable Integer id, @RequestBody ModeloDTO modelo) {
        return serviceModelo.update(id, modelo);
    }
    @DeleteMapping("/{id}")
    public ModeloDTO delete(@PathVariable Integer id){
        return serviceModelo.delete(id);
    }
    @GetMapping("/{id}")
    public ModeloDTO getById(@PathVariable Integer id) {
        return serviceModelo.getById(id);
    }
    @GetMapping
    public List<ModeloDTO>getAll(){
        return serviceModelo.getAll();
    }


}
