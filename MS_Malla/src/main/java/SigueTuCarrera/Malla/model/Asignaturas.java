package SigueTuCarrera.Malla.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "Representa una asignatura o curso que forma parte de la malla académica")
public class Asignaturas {

    @Id
    @Schema(
        description = "Código alfanumérico único de la asignatura (ingresado manualmente)", 
        example = "INF-324",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String codigoAsignatura;

    @Schema(
        description = "Nombre oficial de la asignatura", 
        example = "Estructuras de Datos y Algoritmos",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String nombre;

    @Schema(
        description = "Cantidad de créditos académicos que otorga la asignatura", 
        example = "6"
    )
    private Integer creditos;

    @Schema(
        description = "Número del semestre en el cual se sugiere cursar la asignatura", 
        example = "3"
    )
    private Integer semestreSugerido;
    
    @ElementCollection(fetch = FetchType.EAGER) 
    @Schema(
        description = "Lista de códigos de asignaturas que son prerrequisito para poder cursar esta",
        example = "[\"INF-112\", \"MAT-111\"]"
    )
    private List<String> prerrequisitos;
}