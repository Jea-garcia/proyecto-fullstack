


package cl.examen.parkingbnb.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "ParkingBNB API",
        version = "1.0",
        description = "Documentación de la API de ParkingBNB",
        contact = @Contact(name = "Jean Garcia", email = "jean@parkingbnb.cl")
    )
)
public class OpenApiConfig {
}
