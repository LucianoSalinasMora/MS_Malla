INSERT INTO carrera (carrera_id, nombre_carrera, duracion_semestres)
VALUES (1, 'Ingeniería en Informática', 8)
ON DUPLICATE KEY UPDATE carrera_id=carrera_id;

INSERT INTO asignaturas (codigo_asignatura, nombre, creditos, semestre_sugerido)
VALUES ('INF-100', 'Introducción a la Programación', 6, 1)
ON DUPLICATE KEY UPDATE codigo_asignatura=codigo_asignatura;

INSERT INTO asignaturas (codigo_asignatura, nombre, creditos, semestre_sugerido)
VALUES ('INF-101', 'Estructuras de Datos', 6, 3)
ON DUPLICATE KEY UPDATE codigo_asignatura=codigo_asignatura;

INSERT INTO asignaturas_prerrequisitos (asignaturas_codigo_asignatura, prerrequisitos)
VALUES ('INF-101', 'INF-100')
ON DUPLICATE KEY UPDATE asignaturas_codigo_asignatura=asignaturas_codigo_asignatura;