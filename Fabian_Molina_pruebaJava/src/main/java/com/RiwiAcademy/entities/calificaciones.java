package com.RiwiAcademy.entities;

public class calificaciones {
    private int id;
    private int calificacion;

    public int getId() {
        return id;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "calificaciones{" +
                "id=" + id +
                ", calificacion=" + calificacion +
                '}';
    }
}
