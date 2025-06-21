package cl.examen.parkingbnb.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Schema(description = "DTO para la entidad Usuario")
public class UsuarioDTO {

    @Schema(description = "ID del usuario", example = "1")
    private int id;

    @NotBlank(message = "El rut es obligatorio")
    @Schema(description = "RUT del usuario", example = "12345678-9")
    private String rut;

    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Schema(description = "Nombre de usuario", example = "jlopez")
    private String username;

    @NotBlank(message = "La contraseña es obligatoria")
    @Schema(description = "Contraseña", example = "P@ss12345")
    private String password;

    @NotBlank(message = "El rol es obligatorio")
    @Schema(description = "Rol asignado", example = "ADMIN")
    private String rol;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El formato del email no es válido")
    @Schema(description = "Correo electrónico", example = "usuario@dominio.cl")
    private String email;
}
