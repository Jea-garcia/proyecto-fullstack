package cl.examen.parkingbnb.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/crud/usuario")

public class UsuarioController {
    @Autowired
    IUsuarioService serviceUsuario;

   @PostMapping
    public ResponseEntity<Object> insert(@Valid @RequestBody UsuarioDTO usuario) {
    return ResponseEntity.ok(serviceUsuario.insert(usuario));
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
    public ResponseEntity<?> getById(@PathVariable Integer id) {
    UsuarioDTO usuario = serviceUsuario.getById(id);
    if (usuario == null) {
        return ResponseEntity.status(404).body(Collections.singletonMap("message", "Usuario no existe"));
    }
    return ResponseEntity.ok(usuario);
}

    @GetMapping
    public List<UsuarioDTO>getAll(){
        return serviceUsuario.getAll();
    }

}
