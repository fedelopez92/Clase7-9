package com.example.alumno.clase7_9;

/**
 * Created by alumno on 07/09/2017.
 */

public class Persona {

    private String nombre;
    private String apellido;

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return this.apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public Persona(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
