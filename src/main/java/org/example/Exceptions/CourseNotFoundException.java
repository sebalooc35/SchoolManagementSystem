package org.example.Exceptions;

public class CourseNotFoundException extends Exception {
    public CourseNotFoundException(String mensaje){
       super(mensaje);
    }
}
