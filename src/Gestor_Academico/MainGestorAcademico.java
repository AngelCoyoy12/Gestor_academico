package Gestor_Academico;

import java.util.Date;

public class MainGestorAcademico {
    public static void main(String[] args) {
        GestorAcademico gestor = new GestorAcademico();

        // Crear y agregar estudiantes
        Estudiante estudiante1 = new Estudiante(1, "Pablo", "Gonzales", new Date(), "matriculado");
        Estudiante estudiante2 = new Estudiante(2, "Marisol", "Ordoñez", new Date(), "matriculado");
        Estudiante estudiante3 = new Estudiante(3, "Pepita", "Lopez", new Date(), "matriculado");

        try {
            gestor.matricularEstudiante(estudiante1);
            gestor.matricularEstudiante(estudiante2);

            // Crear y agregar cursos
            Curso curso1 = new Curso(1, "Matemáticas", "Curso de matemáticas avanzado", 3, "1.0");
            Curso curso2 = new Curso(2, "Historia", "Curso de historia universal", 2, "1.0");
            Curso curso3 = new Curso( 3, "Matematicas", "Curso de matematicas avanzado", 1, "1.0");

            gestor.agregarCurso(curso1);
            gestor.agregarCurso(curso2);

            // Inscribir estudiantes en cursos
            gestor.inscribirEstudianteCurso(estudiante1, 1);
            gestor.inscribirEstudianteCurso(estudiante2, 2);
            gestor.inscribirEstudianteCurso(estudiante3, 3);

            // Obtener estudiantes inscritos en un curso
            System.out.println("Estudiantes inscritos en Matemáticas:");
            for (Estudiante est : gestor.obtenerEstudiantesInscritos(curso1)) {
                System.out.println(est.getNombre() + " " + est.getApellido());
            }

            System.out.println("Estudiantes inscritos en Historia:");
            for (Estudiante est : gestor.obtenerEstudiantesInscritos(curso2)) {
                System.out.println(est.getNombre() + " " + est.getApellido());
            }

            // Desinscribir estudiante de un curso
            gestor.desinscribirEstudianteCurso(1, 1);

        } catch (EstudianteYaInscritoException | EstudianteNoInscritoEnCursoException e) {
            System.err.println(e.getMessage());
        }
    }
}
