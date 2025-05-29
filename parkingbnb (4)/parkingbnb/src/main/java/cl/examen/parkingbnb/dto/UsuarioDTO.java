package cl.examen.parkingbnb.dto;

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
    private String rut;
    private String username;
    private String password;
    private String rol;
    private String email;
}
