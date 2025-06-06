package cl.examen.parkingbnb.dto;



import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteDTO {
        
    @NotBlank(message = "El RUT es obligatorio")
    private String rut;
    private String dv;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String direccion;
    private String email;
    private String fechaNacimiento;
    private String telefono;
    private String celular;
    private ComunaDTO comuna;
  
}