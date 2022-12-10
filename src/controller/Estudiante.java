package controller;

public class Estudiante extends Persona{
    private int numeroHermanos;
    private int numeroFamilia;
    public Estudiante(int edad, double peso, char genero,int numeroHermanos,int numeroFamilia) {
        super(edad, peso, genero);
        this.numeroHermanos=numeroHermanos;
        this.numeroFamilia=numeroFamilia;
    }
    public int getNumeroHermanos() {
        return numeroHermanos;
    }
    public void setNumeroHermanos(int numeroHermanos) {
        this.numeroHermanos = numeroHermanos;
    }
    public int getNumeroFamilia() {
        return numeroFamilia;
    }
    public void setNumeroFamilia(int numeroFamilia) {
        this.numeroFamilia = numeroFamilia;
    }
}