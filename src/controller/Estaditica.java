package controller;

import java.util.ArrayList;

public class Estaditica {
/////////////////////////// PUNTO 1 //////////////////////////////
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
    /////////////////////////// PUNTO 3 RAZON DE CORRELACION ///////////////////
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

    public double PromedioY(ArrayList<Double> y,double matriz[][], int n ){
        ArrayList<Double> marginalesY = calcularMarginalesY(matriz);
        double bnd = 0;
        for (int i = 0; i < y.size(); i++){
        bnd= bnd + y.get(i)*(marginalesY.get(i)/n);
        }
        return bnd;
    }

    public double Intervarianza(ArrayList<Double> x, ArrayList<Double> y, double matriz[][],int n){
        ArrayList<Double> marginalesX = calcularMarginalesX(matriz);
        ArrayList<Double> mediaCondicional =  mediaCondicional(x,y,matriz);
        double promedio = PromedioY(y,matriz,n);
        double bnd = 0;
        for (int i = 0; i < marginalesX.size(); i++){
                bnd = bnd + Math.pow((mediaCondicional.get(i)-promedio),2)*(marginalesX.get(i)/n);
            }
    return bnd;
    }

    public double VarianzaCondicional(ArrayList<Double> y, double matriz[][],int n){
        ArrayList<Double> marginalesY = calcularMarginalesY(matriz);
        double promedio = PromedioY(y,matriz,n);
        double bnd = 0;
        for (int i = 0; i < marginalesY.size(); i++){
                bnd = bnd + Math.pow((y.get(i)-promedio),2)*(marginalesY.get(i)/n);
            }
        return bnd;
    }

    public double RazonCorrelacion(double matriz[][],ArrayList<Double> x,ArrayList<Double> y, int totalDatos){

        double Intervarianza = Intervarianza(x, y, matriz, totalDatos);
        double VarianzaCondicional = VarianzaCondicional(y, matriz, totalDatos);

        return (Intervarianza/VarianzaCondicional)*100;

    }
}
