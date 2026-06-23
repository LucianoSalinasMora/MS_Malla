MS_Mallas
Encargado de administrar la estructura curricular de la institución, controlando los planes de estudio, carreras y los flujos de asignaturas.

Especificaciones Técnicas
Puerto: 8002

Base de Datos (Laragon): malla_db

Tecnologías: Spring Boot 3.4.1, Hibernate (FetchType.EAGER), MySQL, Spring Data JPA, Springdoc OpenAPI (Swagger), JUnit 5, Mockito

Responsabilidades Principales
Mantiene el catálogo oficial de carreras y asignaturas, valida de forma estricta los prerrequisitos encadenados de cada asignatura y sirve de pivote de consulta para el módulo de Inscripciones y Avance Curricular.

Estructura de Desarrollo y Pruebas
Estructura de Carpetas: Configuración global de Swagger bajo el paquete config. Pruebas unitarias organizadas en las carpetas controller y service dentro del directorio src/test/java/SigueTuCarrera/.

Carga Inicial: Archivo SQL configurado al lado de application.properties utilizando sentencias INSERT IGNORE INTO.

Endpoints Principales
GET /asignaturas/{codigo} - Buscar asignatura y mapear sus prerrequisitos.

POST /auth/asignaturas - Dar de alta una nueva asignatura en la malla.

GET /carreras - Listar los planes de estudio disponibles.

GET /swagger-ui.html - Documentación interactiva de la API.

Compilación y Despliegue Docker
Bash
mvn clean package
docker build -t ms-mallas:1.0 .
docker run -d -p 8002:8002 --name ms-mallas -e SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal
