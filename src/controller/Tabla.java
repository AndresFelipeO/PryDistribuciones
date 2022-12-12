package controller;
import java.util.ArrayList;

public class Tabla {
    public void imprimirTabla(double[][] prmTabla, String labelX, String labelY, String titulo) {
        System.out.println("\n----" + titulo + "----");
        int i = 0;
        while (i < prmTabla[0].length) {
            System.out.print("   " + labelY + (i + 1));
            i++;
        }
        System.out.println();
        for (i = 0; i < prmTabla.length; i++) {
            System.out.print(labelX + (i + 1) + " ");
            for (int j = 0; j < prmTabla[i].length; j++) {
                System.out.print((int) prmTabla[i][j] + "    ");
            }
            System.out.println("");
        }
    }

    /////////////////////////// PUNTO 1 //////////////////////////////
    public double[][] tablaDistribuccionEP(ArrayList<Estudiante> estudiante) {
        int x = 19;
        int y = 45;
        int aux=10;
        double[][] tabla = new double[5][4];
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                if(j==3)
                    aux+=5;
                for (int w = 0; w < estudiante.size(); w++) {
                    if (x <= 22 && estudiante.get(w).getEdad() == x) {
                        if (estudiante.get(w).getPeso() > y && estudiante.get(w).getPeso() <= y + aux) {
                            tabla[i][j]++;
                        }
                    } else if (x > 22 && estudiante.get(w).getEdad() >= x) {
                        if (estudiante.get(w).getPeso() > y && estudiante.get(w).getPeso() <= y + aux) {
                            tabla[i][j]++;
                        }
                    }
                }
                y += 10;
            }
            aux=10;
            x++;
            y = 45;
        }
        return tabla;
    }

    public double[][] tablaDistribuccionPH(ArrayList<Estudiante> estudiante) {
        int x = 0;
        int y = 45;
        int aux=10;
        double[][] tabla = new double[4][4];
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                if(j==3)
                    aux+=5;
                for (int w = 0; w < estudiante.size(); w++) {
                    if (x <= 22 && estudiante.get(w).getNumeroHermanos() == x) {
                        if (estudiante.get(w).getPeso() > y && estudiante.get(w).getPeso() <= y + aux) {
                            tabla[i][j]++;
                        }
                    }
                }
                y += 10;
            }
            x++;   
            aux=10;
            y = 45;
        }
        return tabla;
    }

    public double[][] tablaDistribuccionHF(ArrayList<Estudiante> estudiante) {
        int y = 0;
        int x = 2;
        double[][] tabla = new double[6][4];
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                for (int w = 0; w < estudiante.size(); w++) {
                    if (estudiante.get(w).getNumeroFamilia() == x) {
                        if (estudiante.get(w).getNumeroHermanos() == y) {
                            tabla[i][j]++;
                        }
                    }
                }
                y++;
            }
            x++;
            y = 0;
        }
        return tabla;
    }

    /////////////////////////// PUNTO 2 //////////////////////////////
    public double[][] tablaDistribuccionEG(ArrayList<Estudiante> estudiante) {
        char x = 'M';
        int y = 19;
        double[][] tabla = new double[2][5];
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                for (int w = 0; w < estudiante.size(); w++) {
                    if (estudiante.get(w).getGenero() == x) {
                        if (estudiante.get(w).getEdad() == y) {
                            tabla[i][j]++;
                        } else if (y >= 23 && estudiante.get(w).getEdad() >= 23) {
                            tabla[i][j]++;
                        }
                    }
                }
                y++;
            }
            x = 'F';
            y = 19;
        }
        return tabla;
    }

    public double[][] tablaDistribuccionPG(ArrayList<Estudiante> estudiante) {
        char x = 'M';
        int y = 45;
        int aux=10;
        double[][] tabla = new double[2][4];
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                if(j==3)
                    aux+=5;
                for (int w = 0; w < estudiante.size(); w++) {
                    if (estudiante.get(w).getGenero() == x) {
                        if (estudiante.get(w).getPeso() > y && estudiante.get(w).getPeso() <= y + aux) {
                            tabla[i][j]++;
                        }
                    }
                }
                y += 10;
            }
            aux=10;
            x = 'F';
            y = 45;
        }
        return tabla;
    }

    public double[][] tablaDistribuccionHG(ArrayList<Estudiante> estudiante) {
        char x = 'M';
        int y = 0;
        double[][] tabla = new double[2][4];
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                for (int w = 0; w < estudiante.size(); w++) {
                    if (estudiante.get(w).getGenero() == x) {
                        if (estudiante.get(w).getNumeroHermanos() == y) {
                            tabla[i][j]++;
                        }
                    }
                }
                y++;
            }
            x = 'F';
            y = 0;
        }
        return tabla;
    }

    public double[][] tablaDistribuccionFG(ArrayList<Estudiante> estudiante) {
        // 2,3,4,5,6,7 F
        // M, F X
        char x = 'M';
        int y = 2;
        double[][] tabla = new double[2][6];
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                for (int w = 0; w < estudiante.size(); w++) {
                    if (estudiante.get(w).getGenero() == x) {
                        if (estudiante.get(w).getNumeroFamilia() == y) {
                            tabla[i][j]++;
                        }
                    }
                }
                y++;
            }
            x = 'F';
            y = 2;
        }
        return tabla;
    }
}