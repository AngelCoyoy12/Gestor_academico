package Gestor_Academico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GestorAcademico implements ServiciosAcademicosL {
    private List<Estudiante> estudiantes;
    private List<Curso> cursos;
    private HashMap<Curso, ArrayList<Estudiante>> inscripciones;

    // Constructor
    public GestorAcademico() {
        estudiantes = new ArrayList<>();
        cursos = new ArrayList<>();
        inscripciones = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
        }
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        Curso curso = buscarCurso(idCurso);
        if (curso != null) {
            if (!inscripciones.containsKey(curso)) {
                inscripciones.put(curso, new ArrayList<>());
            }
            List<Estudiante> inscritos = inscripciones.get(curso);
            if (inscritos.contains(estudiante)) {
                throw new EstudianteYaInscritoException("El estudiante ya está inscrito en el curso.");
            } else {
                inscritos.add(estudiante);
            }
        }
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        Curso curso = buscarCurso(idCurso);
        Estudiante estudiante = buscarEstudiante(idEstudiante);
        if (curso != null && estudiante != null) {
            List<Estudiante> inscritos = inscripciones.get(curso);
            if (inscritos == null || !inscritos.contains(estudiante)) {
                throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en el curso.");
            } else {
                inscritos.remove(estudiante);
            }
        } else {
            throw new EstudianteNoInscritoEnCursoException("Curso o estudiante no encontrado.");
        }
    }

    public Estudiante buscarEstudiante(int id) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                return estudiante;
            }
        }
        return null;
    }

    public Curso buscarCurso(int id) {
        for (Curso curso : cursos) {
            if (curso.getId() == id) {
                return curso;
            }
        }
        return null;
    }

    public ArrayList<Estudiante> obtenerEstudiantesInscritos(Curso curso) {
        return inscripciones.getOrDefault(curso, new ArrayList<>());
    }
}
