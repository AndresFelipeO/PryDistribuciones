import java.util.ArrayList;

import controller.Estaditica;
import model.Datos;

public class App {
    public static void main(String[] args) throws Exception {
        Datos misDatos=new Datos();
        Estaditica esta=new Estaditica();
       // double[][] tabla=esta.tablaDistribuccionEP(misDatos.getEstudiantes());
       //esta.tablaDistribuccionEP(misDatos.getEstudiantes());
    //    System.out.println();
    //    esta.tablaDistribuccionPH(misDatos.getEstudiantes());
        double[][] matriz = new double[4][5];
        matriz[0][0]=8;
        matriz[0][1]=11;
        matriz[0][2]=10;
        matriz[0][3]=1;
        matriz[0][4]=0;
        matriz[1][0]=2;
        matriz[1][1]=12;
        matriz[1][2]=14;
        matriz[1][3]=30;
        matriz[1][4]=2;
        matriz[2][0]=10;
        matriz[2][1]=12;
        matriz[2][2]=24;
        matriz[2][3]=17;
        matriz[2][4]=7;
        matriz[3][0]=0;
        matriz[3][1]=5;
        matriz[3][2]=12;
        matriz[3][3]=2;
        matriz[3][4]=21;

        // x
         ArrayList<Double> x = new ArrayList<>();
         x.add(55.0);
         x.add(60.0);
         x.add(65.0);
         x.add(70.0);
        // y
         ArrayList<Double> y=new ArrayList<>();
         y.add(155.0);
         y.add(165.0);
         y.add(175.0);
         y.add(185.0);
         y.add(195.0);

        //esta.mediaCondicional(x, y, matriz);
        esta.PromedioY(y);

     // esta.calcularMarginalesX(matriz);
    // System.out.println(esta.cuadroMedioContigencia(matriz));

    //System.out.println(esta.coeficieContingenciaCramer(tabla));
    


    }
}
