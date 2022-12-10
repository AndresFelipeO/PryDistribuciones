package controller;

import java.util.ArrayList;
import java.util.List;

public class Estaditica {

    public int[][] tablaDistribuccionEP(ArrayList<Estudiante> estudiante) {
        // 19 20 21 22 y mas
        // 45-55, 55-65, 65-75, 75-90
        int x = 19;
        int y = 45;
        int[][] tabla = new int[5][5];
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                for (int w = 0; w < estudiante.size(); w++) {
                    if (x <= 22 && estudiante.get(w).getEdad() == x) {
                        if (estudiante.get(w).getPeso() > y && estudiante.get(w).getPeso() <= y + 10) {
                            tabla[i][j]++;
                        }
                    } else if (x > 22 && estudiante.get(w).getEdad() >= x) {
                        if (estudiante.get(w).getPeso() > y && estudiante.get(w).getPeso() <= y + 10) {
                            tabla[i][j]++;
                        }
                    }
                }
                y += 10;
            }
            x++;
            y = 45;
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(tabla[i][j] + " ");
            }
            System.out.println("");
        }
        return tabla;
    }
    public int[][] tablaDistribuccionPH(ArrayList<Estudiante> estudiante) {
        // 0, 1, 2, 3 x h 
        // 45-55, 55-65, 65-75, 75-90 y p
        int x = 0;
        int y = 45;
        int[][] tabla = new int[4][5];
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                for (int w = 0; w < estudiante.size(); w++) {
                    if (x <= 22 && estudiante.get(w).getNumeroHermanos() == x) {
                        if (estudiante.get(w).getPeso() > y && estudiante.get(w).getPeso() <= y + 10) {
                            tabla[i][j]++;
                        }
                    } 
                    
                }
                y += 10;
            }
            x++;
            y = 45;
        }
        for (int i = 0; i <  tabla.length; i++) {
            for (int j = 0; j <tabla[i].length; j++) {
                System.out.print(tabla[i][j] + " ");
            }
            System.out.println("");
        }
        return tabla;
    }

  

    public void tablaDistribuccionHF(ArrayList<Estudiante> estudiante) {
        // 0, 1, 2, 3 h
        // 3,4,5,6,7 f
        int y = 0;
        int x = 3;
        int[][] tabla = new int[5][4];
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
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                System.out.print(tabla[i][j] + " ");
            }
            System.out.println("");
        }
    }
    // public void imprimirTablas(double [][] prmTabla,String labelX,String label){
    //     for (int i = 0; i < tabla.length; i++) {
    //         for (int j = 0; j < tabla[i].length; j++) {
    //             System.out.print(tabla[i][j] + " ");
    //         }
    //         System.out.println("");
    //     }
    // }

    public double redondear(double numero) {
        return Math.round(numero * 100) / 100d;
    }

    public ArrayList<Double> calcularMarginalesX(double matriz[][]) {
        ArrayList<Double> marginalesX = new ArrayList<>();
        double suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                suma = suma + matriz[i][j];
            }
            marginalesX.add(suma);
            suma = 0;
        }
        return marginalesX;
    }

    public ArrayList<Double> calcularMarginalesY(double matriz[][]) {
        ArrayList<Double> marginalesY = new ArrayList<>();
        double suma = 0;
        for (int i = 0; i < matriz[0].length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                suma = suma + matriz[j][i];
            }
            marginalesY.add(suma);
            suma = 0;
        }
        return marginalesY;
    }

    public double cuadroMedioContigencia(double matriz[][]) {
        ArrayList<Double> marginalesY = calcularMarginalesY(matriz);
        ArrayList<Double> marginalesX = calcularMarginalesX(matriz);

        double resultado = 0;

        for (int i = 0; i < marginalesX.size(); i++)
            for (int j = 0; j < marginalesY.size(); j++) {
                resultado = resultado + ((Math.pow(matriz[i][j], 2)) / (marginalesX.get(i) * marginalesY.get(j)));
            }
        return resultado - 1;
    }

    public double coeficieContingenciaCramer(double matriz[][]) {
        double CMD = cuadroMedioContigencia(matriz);
        double minimo = minimo(matriz);
        return redondear(CMD / minimo);
    }

    public double minimo(double matriz[][]) {
        double x = matriz[0].length - 1;
        double y = matriz.length - 1;

        if (x < y) {
            return x;
        } else {
            return y;
        }
    }

    /////////////////////////// Intervarianza///////////////////

    public ArrayList<Double> mediaCondicional(ArrayList<Double> x, ArrayList<Double> y, double matriz[][]) {
        ArrayList<Double> marginalesX = calcularMarginalesX(matriz);
        ArrayList<Double> marginalesY = calcularMarginalesY(matriz);
         ArrayList<Double> Resultado=new ArrayList<>();
         double bnd=0;
          for (int i = 0; i < marginalesX.size(); i++){
             for (int j = 0; j < marginalesY.size(); j++) {
                 bnd = bnd + y.get(j)*((matriz[i][j])/(marginalesX.get(i)));
            }
            Resultado.add(bnd);
            bnd=0;
          }
        return Resultado;
    }

    public double PromedioY(ArrayList<Double> y){
        double bnd = 0;
        for (int i = 0; i < y.size(); i++){
        bnd= bnd + y.get(i);
        }
        System.out.println(bnd/y.size());
        return bnd/y.size();
    }

    public double Intervarianza(ArrayList<Double> x, ArrayList<Double> y, double matriz[][]){
        ArrayList<Double> marginalesX = calcularMarginalesX(matriz);
        ArrayList<Double> marginalesY = calcularMarginalesY(matriz);
        ArrayList<Double> mediaCondicional =  mediaCondicional(x,y,matriz);
        double promedio = 176.5;
        double bnd = 0;

        for (int i = 0; i < marginalesX.size(); i++){
             for (int j = 0; j < marginalesY.size(); j++) {
                bnd = (mediaCondicional.get(i)-)
            }
        return 0.0;

    }

}
