package Gestor_Academico;
import java.util.Date;



public class Estudiante extends Persona {
    private String estado; // "matriculado", "inactivo", "graduado"

    public Estudiante(int id, String nombre, String apellido, Date fechaDeNacimiento, String estado) {
        super(id, nombre, apellido, fechaDeNacimiento);
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
