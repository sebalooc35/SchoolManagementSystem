package org.example;

import org.example.Exceptions.CourseNotFoundException;
import org.example.model.Curso;
import org.example.model.Estudiante;

public interface ServiciosAcademicos {

    public void matricularEstudiante(Estudiante estudiante);
    public void agregarCurso(Curso curso);
    public void insciribirEstudianteCurso(Estudiante estudiante, int idCurso) throws Exception;
    public void desinsciribirEstudianteCurso(Estudiante estudiante, int idCurso) throws Exception;
}
