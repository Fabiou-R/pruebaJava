package com.RiwiAcademy.persistence.crud;

import com.RiwiAcademy.entities.cursos;
import com.RiwiAcademy.persistence.configDB.ConfigDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class crudCurso {
    public void createCourse(cursos course) {
        String query = "INSERT INTO courses (course_name, description) VALUES (?, ?)";

        try (Connection conn = ConfigDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, course.getNombreCurso());
            pstmt.setString(2, course.getDescripcion());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCourse(cursos course) {
        String query = "UPDATE courses SET course_name = ?, description = ? WHERE course_id = ?";

        try (Connection conn = ConfigDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, course.getNombreCurso());
            pstmt.setString(2, course.getDescripcion());
            pstmt.setInt(3, course.getIdCurso());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<cursos> getAllCourses() {
        List<cursos> courses = new ArrayList<>();
        String query = "SELECT * FROM courses";

        try (Connection conn = ConfigDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                cursos curso = new cursos();
                curso.setIdCurso(rs.getInt("course_id"));
                curso.setNombreCurso(rs.getString("course_name"));
                curso.setDescripcion(rs.getString("description"));
                courses.add(curso);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public void deleteCourse(int idCurso) {
        String query = "DELETE FROM courses WHERE course_id = ? AND course_id NOT IN (SELECT course_id FROM enrollments)";

        try (Connection conn = ConfigDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, idCurso);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
