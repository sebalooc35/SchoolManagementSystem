package org.example;


import org.example.Exceptions.CourseNotFoundException;
import org.example.Exceptions.StudentNotFoundException;
import org.example.model.Curso;
import org.example.model.Estudiante;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GestorAcademico implements ServiciosAcademicos{

    public static Curso getCursoById(int idCurso, List<Curso> cursos) throws CourseNotFoundException {
        Curso curso = null;

        Iterator<Curso> cursosIterator = cursos.iterator();
        while(cursosIterator.hasNext()){
            curso = cursosIterator.next();
            if(curso.getId() == idCurso){
                break;
            }
        }
        if(curso == null){
            throw new CourseNotFoundException(String.format("El curso con id %d no existe en nuestra base de datos.", idCurso));
        }

        return curso;
    }

    public static void validateEstudianteIsMatriculado(Estudiante estudiante, List<Estudiante> estudiantes) throws StudentNotFoundException{

        if(!estudiantes.contains(estudiante)){
            throw new StudentNotFoundException("El estudiante que ha enviado no se encuentra en nuestra base de datos");
        }
    }

    private List estudiantes;
    private List cursos;
    private Map<Estudiante, Curso> asignacionesCursos;

    public GestorAcademico(List estudiantes, List cursos, Map<Estudiante, Curso> asignacionesCursos) {
        this.estudiantes = estudiantes;
        this.cursos = cursos;
        this.asignacionesCursos = asignacionesCursos;
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) {
        this.estudiantes.add(estudiante);
    }

    @Override
    public void agregarCurso(Curso curso) {
        this.cursos.add(curso);
    }

    @Override
    public void insciribirEstudianteCurso(Estudiante estudiante, int idCurso) throws Exception{

        Curso curso = getCursoById(idCurso, this.cursos);

        validateEstudianteIsMatriculado(estudiante, estudiantes);

        this.asignacionesCursos.put(estudiante, curso);
    }


    @Override
    public void desinsciribirEstudianteCurso(Estudiante estudiante, int idCurso) throws Exception {

        Curso curso = getCursoById(idCurso, this.cursos);

        validateEstudianteIsMatriculado(estudiante, estudiantes);

        this.asignacionesCursos.remove(estudiante);
    }
}
