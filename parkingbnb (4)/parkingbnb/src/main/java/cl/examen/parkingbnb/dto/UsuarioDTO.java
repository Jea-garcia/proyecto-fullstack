package cl.examen.parkingbnb.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {

    private int id;

    @NotBlank(message = "El rut es obligatorio")
    private String rut;

    @NotBlank(message = "El nombre de usuario es obligatorio")
    private String username;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;

    @NotBlank(message = "El rol es obligatorio")
    private String rol;
    
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El formato del email no es válido")
    private String email;
}
