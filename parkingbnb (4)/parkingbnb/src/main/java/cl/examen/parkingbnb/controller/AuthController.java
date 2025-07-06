package cl.examen.parkingbnb.controller;

import cl.examen.parkingbnb.dto.LoginDTO;
import cl.examen.parkingbnb.dto.UsuarioDTO;
import cl.examen.parkingbnb.service.IUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginDto) {
        UsuarioDTO usuario = usuarioService.findByUsername(loginDto.getUsername());

        if (usuario == null) {
            return ResponseEntity.status(401).body("Usuario no encontrado");
        }

        if (!usuario.getPassword().equals(loginDto.getPassword())) {
            return ResponseEntity.status(401).body("Contraseña incorrecta");
        }

        // Login exitoso: devuelve DTO de usuario (sin password idealmente)
        return ResponseEntity.ok(usuario);
    }
}
