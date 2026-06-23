package SigueTuCarrera.Malla.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "Representa una carrera universitaria dentro de la malla curricular")
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(
        description = "Identificador único autogenerado de la carrera", 
        example = "1", 
        accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long carreraId;

    @Schema(
        description = "Nombre oficial de la carrera académica", 
        example = "Ingeniería Civil en Informática", 
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String nombreCarrera;

    @Schema(
        description = "Cantidad total de semestres académicos que dura la carrera", 
        example = "10"
    )
    private Integer duracionSemestres;
}