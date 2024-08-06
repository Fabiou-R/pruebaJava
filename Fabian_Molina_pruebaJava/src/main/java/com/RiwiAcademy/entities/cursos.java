package com.RiwiAcademy.entities;

public class cursos {
    private int idCurso;
    private String nombreCurso;
    private String descripcion;

    public int getIdCurso() {
        return idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
