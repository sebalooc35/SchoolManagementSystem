package org.example;


import java.util.List;
import java.util.Map;

public class GestorAcademico {

    private List estudiantes;
    private List cursos;
    private Map<Estudiante, Curso> asignacionesCursos;

    public GestorAcademico(List estudiantes, List cursos, Map<Estudiante, Curso> asignacionesCursos) {
        this.estudiantes = estudiantes;
        this.cursos = cursos;
        this.asignacionesCursos = asignacionesCursos;
    }
}
