package org.example;

import org.example.Exceptions.CourseNotFoundException;
import org.example.Exceptions.StudentNotFoundException;
import org.example.model.Curso;
import org.example.model.EstadoEstudiante;
import org.example.model.Estudiante;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Estudiante estudiante1 = new Estudiante(1L,"Andres","Ordonez", LocalDate.parse("2005-03-16", formatter), EstadoEstudiante.GRADUADO);
        Estudiante estudiante2 = new Estudiante(2L,"Sebastian","Rivas",LocalDate.parse("2004-06-20",formatter), EstadoEstudiante.MATRICULADO);
        Curso curso1 = new Curso(1L, "Matematicas 1", "Matematicas Pre Calculo", 8, "1.0.0");
        Curso curso2 = new Curso(2L, "Informatica 1", "Logica y Matematicas discretas", 5, "1.0.0");

        GestorAcademico gestorAcademico = new GestorAcademico();

        gestorAcademico.agregarCurso(curso1);
        gestorAcademico.matricularEstudiante(estudiante1);

        try{
            gestorAcademico.insciribirEstudianteCurso(estudiante1, 1);
            System.out.println(String.format("El estudiante %s con id %d ha sido agregado al curso %s con id %d con exito.",estudiante1.getNombre()+estudiante1.getApellido(), estudiante1.getId(), GestorAcademico.getCursoById(1, gestorAcademico.getCursos()).getNombre(), 1 ));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            gestorAcademico.insciribirEstudianteCurso(estudiante2, 1);
            System.out.println(String.format("El estudiante %s con id %d ha sido agregado al curso %s con id %d con exito.",estudiante1.getNombre()+estudiante1.getApellido(), estudiante1.getId(), GestorAcademico.getCursoById(1, gestorAcademico.getCursos()).getNombre(), 1 ));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            gestorAcademico.desinsciribirEstudianteCurso(estudiante1, 1);
            System.out.println(String.format("El estudiante %s con id %d ha sido desasignado del curso %s con id %d con exito.",estudiante1.getNombre()+estudiante1.getApellido(), estudiante1.getId(), GestorAcademico.getCursoById(1, gestorAcademico.getCursos()).getNombre(), 1 ));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            gestorAcademico.desinsciribirEstudianteCurso(estudiante1, 1);
            System.out.println(String.format("El estudiante %s con id %d ha sido desasignado del curso %s con id %d con exito.",estudiante1.getNombre()+estudiante1.getApellido(), estudiante1.getId(), GestorAcademico.getCursoById(1, gestorAcademico.getCursos()).getNombre(), 1 ));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
