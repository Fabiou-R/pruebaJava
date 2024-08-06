package com.RiwiAcademy.entities;

public class Estudiantes {
    private String nombre;
    private boolean status;
    private int idEstudiante;
    private String email;


    public String getNombre() {
        return nombre;
    }

    public boolean isStatus() {
        return status;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
