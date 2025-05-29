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

import cl.examen.parkingbnb.dto.UsuarioDTO;
import cl.examen.parkingbnb.service.IUsuarioService;

@RestController
@RequestMapping("/api/crud/usuario")
public class UsuarioController {
    @Autowired
    IUsuarioService serviceUsuario;
    @PostMapping
    public UsuarioDTO insert(@RequestBody UsuarioDTO usuario) {
        return serviceUsuario.save(usuario);
    }
    @PutMapping("/{id}")
    public UsuarioDTO update(@PathVariable Integer id, @RequestBody UsuarioDTO usuario) {
        return serviceUsuario.update(id, usuario);
    }
    @DeleteMapping("/{id}")
    public UsuarioDTO delete(@PathVariable Integer id){
        return serviceUsuario.delete(id);
    }
    @GetMapping("/{id}")
    public UsuarioDTO getById(@PathVariable Integer id) {
        return serviceUsuario.getById(id);
    }
    @GetMapping
    public List<UsuarioDTO>getAll(){
        return serviceUsuario.getAll();
    }

}
