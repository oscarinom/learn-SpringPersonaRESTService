package com.oscarinom.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona {
    @Id
    private int id;
    private String Nombre;
    private String Apellido;
    @JsonPropertyOrder({"id","nombre","apellido"})
    public Persona(int id, String nombre, String apellido) {
        this.id = id;
        Nombre = nombre;
        Apellido = apellido;
    }

    public Persona(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }
}
