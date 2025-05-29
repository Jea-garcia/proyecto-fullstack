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

import cl.examen.parkingbnb.dto.ColorDTO;
import cl.examen.parkingbnb.service.IColorService;

@RestController
@RequestMapping("/api/crud/color")
public class ColorController {
    @Autowired
    IColorService serviceColor;

    @PostMapping
    public ColorDTO insert(@RequestBody ColorDTO color) {
        return serviceColor.insert(color);
    }
    @PutMapping("/{id}")
    public ColorDTO update(@PathVariable Integer id, @RequestBody ColorDTO color) {
        return serviceColor.update(id, color);
    }
    @DeleteMapping("/{id}")
    public ColorDTO delete(@PathVariable Integer id){
        return serviceColor.delete(id);
    }
    @GetMapping("/{id}")
    public ColorDTO getById(@PathVariable Integer id) {
        return serviceColor.getById(id);
    }
    @GetMapping
    public List<ColorDTO>getAll(){
        return serviceColor.getAll();
    }

}
