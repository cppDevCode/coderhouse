package com.coder.ClienteApiRest.Model;


public class ClienteOutput {
    private String nombre;

    // Clase Output JSON

    private String apellido;

    private int anios = -1;

    public int getAnios() {
        return anios;
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setAnios(int edad) {
        this.anios = edad;
    }

}
