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

import cl.examen.parkingbnb.dto.PagoDTO;
import cl.examen.parkingbnb.service.IPagoService;

@RestController
@RequestMapping("/api/crud/pago")
public class PagoController {
    @Autowired
    IPagoService servicePago;

    @PostMapping
    public PagoDTO insert(@RequestBody PagoDTO pago) {
        return servicePago.save(pago);
    }
    @PutMapping("/{id}")
    public PagoDTO update(@PathVariable Integer id, @RequestBody PagoDTO pago) {
        return servicePago.update(id, pago);
    }
    @DeleteMapping("/{id}")
    public PagoDTO delete(@PathVariable Integer id){
        return servicePago.delete(id);
    }
    @GetMapping("/{id}")
    public PagoDTO getById(@PathVariable Integer id) {
        return servicePago.getById(id);
    }
    @GetMapping
    public List<PagoDTO>getAll(){
        return servicePago.getAll();
    }

}
