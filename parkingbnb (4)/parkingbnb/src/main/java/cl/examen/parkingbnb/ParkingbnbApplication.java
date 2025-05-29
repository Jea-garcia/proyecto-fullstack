package cl.examen.parkingbnb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "cl.examen.parkingbnb.model") // donde están tus entidades reales
public class ParkingbnbApplication {
    public static void main(String[] args) {
        SpringApplication.run(ParkingbnbApplication.class, args);
    }
}