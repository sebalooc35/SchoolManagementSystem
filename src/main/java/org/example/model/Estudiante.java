package org.example.model;

import java.util.Date;

public class Estudiante extends Persona{
    private Long id;
    private EstadoEstudiante estado;

    public Estudiante(Long id, String nombre, String apellido, Date fechaDeNacimiento, EstadoEstudiante estado) {
        super(nombre, apellido, fechaDeNacimiento);
        this.id = id;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public EstadoEstudiante getEstado() {
        return estado;
    }

    public void setEstado(EstadoEstudiante estado) {
        this.estado = estado;
    }
}
