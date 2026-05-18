# MS_Mallas
Encargado de administrar la estructura curricular de la institución, controlando los planes de estudio, carreras y los flujos de asignaturas.
## Especificaciones Técnicas
* **Puerto:** `8002`
* **Base de Datos (Laragon):** `malla_db`
* **Tecnologías:** Spring Boot 4.0.6, Hibernate (FetchType.EAGER), MySQL

## Responsabilidades Principales
* Mantener el catálogo oficial de carreras y asignaturas.
* Validar de forma estricta los prerrequisitos encadenados de cada asignatura.
* Servir de pivote de consulta para el módulo de Inscripciones y Avance Curricular.

## Endpoints Principales
* `GET /api/v1/asignaturas/{codigo}` - Buscar asignatura y mapear sus prerrequisitos.
* `POST /api/v1/asignaturas` - Dar de alta una nueva asignatura en la malla.
* `GET /api/v1/carreras` - Listar los planes de estudio disponibles.
