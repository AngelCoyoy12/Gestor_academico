package Gestor_Academico;

public class CursoYaExistenteException extends Exception {
    public CursoYaExistenteException(String mensaje) {
        super(mensaje);
    }
}