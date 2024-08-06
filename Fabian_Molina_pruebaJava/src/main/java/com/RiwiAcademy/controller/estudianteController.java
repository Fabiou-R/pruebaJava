package com.RiwiAcademy.controller;

import com.RiwiAcademy.entities.Estudiantes;
import com.RiwiAcademy.persistence.crud.crudEstudiante;

import java.util.List;

public class estudianteController {
    private crudEstudiante crud;

    public estudianteController() {
        this.crud = new crudEstudiante();
    }

    public void createStudent(String name, String email) {
        Estudiantes student = new Estudiantes();
        student.setNombre(name);
        student.setEmail(email);
        student.setStatus(true);
        crud.createStudent(student);
    }

    public void updateStudent(int studentId, String name, String email, boolean status) {
        Estudiantes student = new Estudiantes();
        student.setIdEstudiante(studentId);
        student.setNombre(name);
        student.setEmail(email);
        student.setStatus(status);
        crud.updateStudent(student);
    }

    public List<Estudiantes> getActiveStudents() {
        return crud.getActiveStudents();
    }

    public Estudiantes getStudentByIdOrEmail(int id, String email) {
        return crud.getStudentByIdOrEmail(id, email);
    }
}
