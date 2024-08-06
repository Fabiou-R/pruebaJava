package com.RiwiAcademy.persistence.crud;

import com.RiwiAcademy.entities.Estudiantes;
import com.RiwiAcademy.persistence.configDB.ConfigDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class crudEstudiante {
    public void createStudent(Estudiantes student) {
        String query = "INSERT INTO students (name, email) VALUES (?, ?)";

        try (Connection conn = ConfigDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, student.getNombre());
            pstmt.setString(2, student.getEmail());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Estudiantes student) {
        String query = "UPDATE students SET name = ?, email = ?, status = ? WHERE student_id = ?";

        try (Connection conn = ConfigDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, student.getNombre());
            pstmt.setString(2, student.getEmail());
            pstmt.setBoolean(3, student.isStatus());
            pstmt.setInt(4, student.getIdEstudiante());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Estudiantes> getActiveStudents() {
        List<Estudiantes> students = new ArrayList<>();
        String query = "SELECT * FROM students WHERE status = TRUE";

        try (Connection conn = ConfigDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Estudiantes student = new Estudiantes();
                student.setIdEstudiante(rs.getInt("student_id"));
                student.setNombre(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setStatus(rs.getBoolean("status"));
                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public Estudiantes getStudentByIdOrEmail(int id, String email) {
        Estudiantes student = null;
        String query = "SELECT s.*, c.course_name FROM students s LEFT JOIN enrollments e ON s.student_id = e.student_id LEFT JOIN courses c ON e.course_id = c.course_id WHERE s.student_id = ? OR s.email = ?";

        try (Connection conn = ConfigDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.setString(2, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                student = new Estudiantes();
                student.setIdEstudiante(rs.getInt("student_id"));
                student.setNombre(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setStatus(rs.getBoolean("status"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
