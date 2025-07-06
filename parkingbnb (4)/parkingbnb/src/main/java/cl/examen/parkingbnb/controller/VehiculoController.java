package cl.examen.parkingbnb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.examen.parkingbnb.dto.VehiculoDTO;
import cl.examen.parkingbnb.service.IVehiculoService;

@RestController
@RequestMapping("/api/crud/vehiculo")
public class VehiculoController {

    @Autowired
    private IVehiculoService vehiculoService;

    @PostMapping
    public ResponseEntity<VehiculoDTO> create(@RequestBody VehiculoDTO dto) {
        VehiculoDTO created = vehiculoService.save(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehiculoDTO> update(@PathVariable Long id, @RequestBody VehiculoDTO dto) {
        VehiculoDTO updated = vehiculoService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VehiculoDTO> delete(@PathVariable Long id) {
        VehiculoDTO deleted = vehiculoService.delete(id);
        return ResponseEntity.ok(deleted);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDTO> getById(@PathVariable Long id) {
        VehiculoDTO dto = vehiculoService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<VehiculoDTO>> getAll() {
        List<VehiculoDTO> list = vehiculoService.getAll();
        return ResponseEntity.ok(list);
    }
}
