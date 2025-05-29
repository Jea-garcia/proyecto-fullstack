package cl.examen.parkingbnb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.examen.parkingbnb.dto.ClienteDTO;
import cl.examen.parkingbnb.service.IClienteService;
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
    public ClienteDTO insert(@RequestBody ClienteDTO cliente) {
        return serviceCliente.insert(cliente);
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
public ClienteDTO getByRut(@PathVariable String rut) {
    return serviceCliente.getByRut(rut);
}
    @GetMapping
    public List<ClienteDTO>getAll(){
        return serviceCliente.getAll();
    }

}
