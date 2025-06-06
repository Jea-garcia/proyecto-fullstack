package cl.examen.parkingbnb.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.examen.parkingbnb.dto.ClienteDTO;
import cl.examen.parkingbnb.service.IClienteService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/api/crud/cliente")
public class ClienteController {
    @Autowired
    IClienteService serviceCliente;

    @PostMapping
    public ResponseEntity<ClienteDTO> insert(@Valid @RequestBody ClienteDTO cliente) {
    return ResponseEntity.ok(serviceCliente.insert(cliente));
}
    @PutMapping("/{rut}")
    public ClienteDTO update(@PathVariable String rut, @RequestBody ClienteDTO cliente) {
    return serviceCliente.update(rut, cliente);
    }

   @DeleteMapping("/{rut}")
    public ClienteDTO delete(@PathVariable String rut){
    return serviceCliente.delete(rut);
    }

    @GetMapping("/{rut}")
    public ResponseEntity<?> getByRut(@PathVariable String rut) {
    ClienteDTO cliente = serviceCliente.getByRut(rut);
    if (cliente == null) {
        return ResponseEntity.status(404).body(Collections.singletonMap("message", "Cliente no existe"));
    }
    return ResponseEntity.ok(cliente);
    }
    
    @GetMapping
    public List<ClienteDTO>getAll(){
        return serviceCliente.getAll();
    }

}
