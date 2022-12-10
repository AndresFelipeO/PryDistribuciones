package model;
import java.util.ArrayList;
import controller.Estudiante;
import controller.Persona;

public class Datos {
    private ArrayList<Persona> estudiantes;  
    public Datos(){
        estudiantes=new ArrayList<>(); 
        generarDatos();
    }
    public ArrayList<Persona> getEstudiantes() {
        return estudiantes;
    }
    public void setEstudiantes(ArrayList<Persona> estudiantes) {
        this.estudiantes = estudiantes;
    }
    private void generarDatos(){
        estudiantes.add(new Estudiante(22, 50, 'M', 1, 4));
        estudiantes.add(new Estudiante(20, 70, 'M', 1, 4));
        estudiantes.add(new Estudiante(21, 78, 'M', 1, 4));
        estudiantes.add(new Estudiante(23, 90, 'M', 3, 7));
        estudiantes.add(new Estudiante(20, 82, 'M', 3, 5));
        estudiantes.add(new Estudiante(19, 60, 'F', 1, 3));
        estudiantes.add(new Estudiante(21, 62, 'M', 1, 4));
        estudiantes.add(new Estudiante(20, 69, 'M', 3, 4));
        estudiantes.add(new Estudiante(19, 80, 'F', 1, 3));
        estudiantes.add(new Estudiante(20, 49, 'F', 0, 2));
        estudiantes.add(new Estudiante(21, 75, 'M', 1, 4));
        estudiantes.add(new Estudiante(24, 80, 'M', 1, 3));
        estudiantes.add(new Estudiante(24, 58, 'M', 2, 5));
        estudiantes.add(new Estudiante(19, 63, 'M', 1, 4));
        estudiantes.add(new Estudiante(20, 65, 'M', 0, 3));
        estudiantes.add(new Estudiante(21, 70, 'M', 2, 4));
        estudiantes.add(new Estudiante(29, 85, 'M', 2, 5));
        estudiantes.add(new Estudiante(23, 49, 'F', 3, 6));
        estudiantes.add(new Estudiante(24, 52, 'M', 1, 4));
        estudiantes.add(new Estudiante(21, 67, 'M', 2, 3));
        estudiantes.add(new Estudiante(22, 68, 'F', 3, 3));
        estudiantes.add(new Estudiante(19, 55, 'M', 2, 5));
        estudiantes.add(new Estudiante(20, 78, 'M', 2, 5));
        estudiantes.add(new Estudiante(20, 85, 'M', 0, 3));
        estudiantes.add(new Estudiante(23, 81, 'M', 0, 3));
        estudiantes.add(new Estudiante(21, 76, 'M', 1, 3));
        estudiantes.add(new Estudiante(20, 68, 'M', 3, 6));
        estudiantes.add(new Estudiante(20, 60, 'M', 1, 4));
        estudiantes.add(new Estudiante(21, 60, 'M', 2, 4));
    }
}