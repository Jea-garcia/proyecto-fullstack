package cl.examen.parkingbnb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.examen.parkingbnb.dto.RegionDTO;
import cl.examen.parkingbnb.service.IRegionService;

@RestController
@RequestMapping("/api/crud/region")
public class RegionController {
    @Autowired
    IRegionService serviceRegion;

    @GetMapping("/{id}")
    public RegionDTO getById(@PathVariable Integer id) {
        return serviceRegion.getById(id);
    }

    @GetMapping
    public List<RegionDTO> getAll() {
        return serviceRegion.getAll();
    }
    @PostMapping
    public RegionDTO createRegion(@RequestBody RegionDTO regionDTO) {
        return serviceRegion.save(regionDTO);
    }
}
