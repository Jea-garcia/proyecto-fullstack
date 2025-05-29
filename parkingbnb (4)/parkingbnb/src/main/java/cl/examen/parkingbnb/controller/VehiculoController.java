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

import cl.examen.parkingbnb.dto.VehiculoDTO;
import cl.examen.parkingbnb.service.IVehiculoService;

@RestController
@RequestMapping("/api/crud/vehiculo")
public class VehiculoController {
    @Autowired
    IVehiculoService serviceVehiculo;

    @PostMapping
    public VehiculoDTO insert(@RequestBody VehiculoDTO vehiculo) {
        return serviceVehiculo.save(vehiculo);
    }
    @PutMapping("/{patente}")
    public VehiculoDTO update(@PathVariable String patente, @RequestBody VehiculoDTO vehiculo) {
        return serviceVehiculo.update(patente, vehiculo);
    }
    @DeleteMapping("/{patente}")
    public VehiculoDTO delete(@PathVariable String patente){
        return serviceVehiculo.delete(patente);
    }
    @GetMapping("/{patente}")
    public VehiculoDTO getById(@PathVariable String patente) {
        return serviceVehiculo.getById(patente);
    }
    @GetMapping
    public List<VehiculoDTO>getAll(){
        return serviceVehiculo.getAll();
    }


}
