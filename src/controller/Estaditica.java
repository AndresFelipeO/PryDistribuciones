package controller;

import java.util.ArrayList;

public class Estaditica {

    public double[][] tablaDistribuccionEP(ArrayList<Estudiante> estudiante) {
        // 19 20 21 22 y mas X
        // 45-55, 55-65, 65-75, 75-85 Y
        int x = 19;
        int y = 45;
        double[][] tabla = new double[5][5];
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
    }
    
    public void imprimirTabla(double [][] prmTabla,String labelX,String labelY,String titulo){
        int x=1;
        int y=1;
        System.out.println("\n----"+titulo+"----");
        int i=0;
        while(i<prmTabla[0].length){
            System.out.print("   "+labelY+(i+1)); 
            i++;
        }
        System.out.println();
        for (i = 0; i < prmTabla.length; i++) {
            System.out.print(labelX+(x+i)+" ");
            for (int j = 0; j < prmTabla[i].length; j++) {
                System.out.print((int)prmTabla[i][j] + "    ");
            }
            System.out.println("");
        }
    }

    public double redondear(double numero) {
        return Math.round(numero * 100) / 100d;
    }
/////////////////////////// PUNTO 1 //////////////////////////////

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

    public double PromedioY(ArrayList<Double> y){
        double bnd = 0;
        for (int i = 0; i < y.size(); i++){
        bnd= bnd + y.get(i);
        }
        System.out.println(bnd/y.size());
        return bnd/y.size();
    }

    public double Intervarianza(ArrayList<Double> x, ArrayList<Double> y, double matriz[][],int n){
        ArrayList<Double> marginalesX = calcularMarginalesX(matriz);
        ArrayList<Double> mediaCondicional =  mediaCondicional(x,y,matriz);
        double promedio = 176.5;
        double bnd = 0;
        for (int i = 0; i < marginalesX.size(); i++){
                bnd = bnd + Math.pow((mediaCondicional.get(i)-promedio),2)*(marginalesX.get(i)/n);
            }
    return bnd;
    }

    public double VarianzaCondicional(ArrayList<Double> y, double matriz[][],int n){
        ArrayList<Double> marginalesY = calcularMarginalesY(matriz);
        double promedio = 176.5;
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
