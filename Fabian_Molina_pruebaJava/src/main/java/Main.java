import com.RiwiAcademy.controller.estudianteController;
import com.RiwiAcademy.entities.Estudiantes;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static estudianteController estudianteController = new estudianteController();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Riwi Academy ---");
            System.out.println("1. Gestionar Estudiantes");
            System.out.println("2. Gestionar Cursos");
            System.out.println("3. Gestionar Inscripciones");
            System.out.println("4. Gestionar Calificaciones");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    gestionarEstudiantes(scanner);
                    break;
                case 2:
                    // gestionarCursos(scanner);
                    break;
                case 3:
                    // gestionarInscripciones(scanner);
                    break;
                case 4:
                    // gestionarCalificaciones(scanner);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }

        scanner.close();
    }

    private static void gestionarEstudiantes(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("\n--- Gestionar Estudiantes ---");
            System.out.println("1. Crear Estudiante");
            System.out.println("2. Editar Estudiante");
            System.out.println("3. Listar Estudiantes Activos");
            System.out.println("4. Buscar Estudiante por ID o Email");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    crearEstudiante(scanner);
                    break;
                case 2:
                    editarEstudiante(scanner);
                    break;
                case 3:
                    listarEstudiantesActivos();
                    break;
                case 4:
                    buscarEstudiante(scanner);
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }
    }

    private static void crearEstudiante(Scanner scanner) {
        System.out.print("Ingrese el nombre del estudiante: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese el email del estudiante: ");
        String email = scanner.nextLine();
        estudianteController.createStudent(name, email);
        System.out.println("Estudiante creado exitosamente.");
    }

    private static void editarEstudiante(Scanner scanner) {
        System.out.print("Ingrese el ID del estudiante a editar: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nuevo nombre del estudiante: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese el nuevo email del estudiante: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese el nuevo estado del estudiante (true/false): ");
        boolean status = scanner.nextBoolean();
        scanner.nextLine(); // Limpiar el buffer
        estudianteController.updateStudent(studentId, name, email, status);
        System.out.println("Estudiante editado exitosamente.");
    }

    private static void listarEstudiantesActivos() {
        List<Estudiantes> students = estudianteController.getActiveStudents();
        System.out.println("Estudiantes Activos:");
        for (Estudiantes student : students) {
            System.out.println("ID: " + student.getIdEstudiante() + ", Nombre: " + student.getNombre() + ", Email: " + student.getEmail());
        }
    }

    private static void buscarEstudiante(Scanner scanner) {
        System.out.print("Ingrese el ID del estudiante o el email: ");
        String input = scanner.nextLine();
        Estudiantes student;
        try {
            int id = Integer.parseInt(input);
            student = estudianteController.getStudentByIdOrEmail(id, null);
        } catch (NumberFormatException e) {
            student = estudianteController.getStudentByIdOrEmail(0, input);
        }
        if (student != null) {
            System.out.println("Estudiante encontrado: ID: " + student.getIdEstudiante() + ", Nombre: " + student.getNombre() + ", Email: " + student.getEmail());
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }
}
