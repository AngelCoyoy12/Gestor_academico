package Gestor_Academico;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Curso, ArrayList<Estudiante>> inscripciones;

    // Constructor
    public GestorAcademico() {
        estudiantes = new ArrayList<>();
        cursos = new ArrayList<>();
        inscripciones = new HashMap<>();
    }

    // Métodos para gestionar estudiantes
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void eliminarEstudiante(int id) {
        estudiantes.removeIf(estudiante -> estudiante.getId() == id);
    }

    public Estudiante buscarEstudiante(int id) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                return estudiante;
            }
        }
        return null;
    }

    // Métodos para gestionar cursos
    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void eliminarCurso(int id) {
        cursos.removeIf(curso -> curso.getId() == id);
    }

    public Curso buscarCurso(int id) {
        for (Curso curso : cursos) {
            if (curso.getId() == id) {
                return curso;
            }
        }
        return null;
    }

    // Métodos para gestionar inscripciones
    public void inscribirEstudianteEnCurso(Estudiante estudiante, Curso curso) {
        if (!inscripciones.containsKey(curso)) {
            inscripciones.put(curso, new ArrayList<>());
        }
        inscripciones.get(curso).add(estudiante);
    }

    public ArrayList<Estudiante> obtenerEstudiantesInscritos(Curso curso) {
        return inscripciones.getOrDefault(curso, new ArrayList<>());
    }
}
