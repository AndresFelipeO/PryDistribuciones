package controller;

public abstract class Persona {
    private int edad;    
    private double peso;
    private char genero;
    public Persona(int edad, double peso, char genero) {
        this.edad = edad;
        this.peso = peso;
        this.genero = genero;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public char getGenero() {
        return genero;
    }
    public void setGenero(char genero) {
        this.genero = genero;
    }
}
