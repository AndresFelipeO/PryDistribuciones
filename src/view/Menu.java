package view;

import java.util.ArrayList;
import java.util.Scanner;
import controller.Estaditica;
import controller.Tabla;
import model.Datos;

public class Menu {
    private static Scanner in = new Scanner(System.in);
    private static Datos misDatos = new Datos();
    private static Estaditica estadistica = new Estaditica();
    private static Tabla tablaEstadistica = new Tabla();

    public static void mostrarMenu(int opc) {
        if (opc != 3) {
            System.out.println("\nTaller 2 Estadistica");
            System.out.println("1.Primer y Tercer Punto");
            System.out.println("2.Segundo Punto");
            System.out.println("3.Salir");
            System.out.print("Digite una opcion: ");
            opc = in.nextInt();
            procesarInformacion(opc);
            mostrarMenu(opc);
        }
    }

    private static void procesarInformacion(int opc) {
        switch (opc) {
            case 1:
                System.out.println("Primer y Tercer Punto");
                primerTercerPunto();
                break;
            case 2:
                System.out.println("Segundo Punto");
                SegundoPunto();
                break;
            case 3:
                System.out.println("Saliendo del programa");
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;
        }

    }

    private static void primerTercerPunto() {
        tablaEP();
        tablaPH();
        tablaHF();
    }

    private static void tablaEP() {
        double[][] tabla = tablaEstadistica.tablaDistribuccionEP(misDatos.getEstudiantes());
        ArrayList<Double> x = new ArrayList<>();
        x.add(19.0);
        x.add(20.0);
        x.add(21.0);
        x.add(22.0);
        x.add(23.0);
        ArrayList<Double> y = new ArrayList<>();
        y.add(45.0);
        y.add(55.0);
        y.add(65.0);
        y.add(75.0);
        mostrarInfoTabla(tabla, x, y, "Tabla Edad Peso");
    }

    private static void tablaPH() {
        double[][] tabla = tablaEstadistica.tablaDistribuccionPH(misDatos.getEstudiantes());
        ArrayList<Double> x = new ArrayList<>();
        x.add(0.0);
        x.add(1.0);
        x.add(2.0);
        x.add(3.0);
        ArrayList<Double> y = new ArrayList<>();
        y.add(45.0);
        y.add(55.0);
        y.add(65.0);
        y.add(75.0);
        mostrarInfoTabla(tabla, x, y, "Tabla Peso Hermanos");
    }

    private static void tablaHF() {
        double[][] tabla = tablaEstadistica.tablaDistribuccionHF(misDatos.getEstudiantes());
        ArrayList<Double> x = new ArrayList<>();
        x.add(2.0);
        x.add(3.0);
        x.add(4.0);
        x.add(5.0);
        x.add(6.0);
        x.add(7.0);
        ArrayList<Double> y = new ArrayList<>();
        y.add(0.0);
        y.add(1.0);
        y.add(2.0);
        y.add(3.0);
        mostrarInfoTabla(tabla, x, y, "Tabla Hermanos Familia");
    }

    private static void mostrarInfoTabla(double[][] tabla, ArrayList<Double> x, ArrayList<Double> y, String titulo) {
        tablaEstadistica.imprimirTabla(tabla, "x", "y", titulo);
        System.out.println("Cuadro medio de contingencia: " + estadistica.cuadroMedioContigencia(tabla));
        System.out.println("Coeficiente de Creamer: " + estadistica.coeficieContingenciaCramer(tabla));
        System.out.println("Media Y: " + estadistica.PromedioY(y,tabla,28));
        System.out.println("Varianza condicional: " + estadistica.VarianzaCondicional(y, tabla, 28));
        System.out.println("Intervarianza: " + estadistica.Intervarianza(x, y, tabla, 28));
        System.out.println("Razon de correlacion: " + estadistica.RazonCorrelacion(tabla, x, y, 28));
    }

    private static void SegundoPunto() {
       tablaEG();
       tablaPG();
       tablaHG();
       tablaFG();
    }
    private static void tablaEG() {
        double[][] tabla = tablaEstadistica.tablaDistribuccionEG(misDatos.getEstudiantes());
        ArrayList<Double> x = new ArrayList<>();
        x.add(1.0);
        x.add(0.0);
        ArrayList<Double> y = new ArrayList<>();
        y.add(19.0);
        y.add(20.0);
        y.add(21.0);
        y.add(22.0);
        y.add(23.0);
        mostrarInfoTabla(tabla, x, y, "Tabla Edad Genero");
    }

    private static void tablaPG() {
        double[][] tabla = tablaEstadistica.tablaDistribuccionPG(misDatos.getEstudiantes());
        ArrayList<Double> x = new ArrayList<>();
        x.add(1.0);
        x.add(0.0);
        ArrayList<Double> y = new ArrayList<>();
        y.add(45.0);
        y.add(55.0);
        y.add(65.0);
        y.add(75.0);
        mostrarInfoTabla(tabla, x, y, "Tabla Peso Genero");
    }
    
    private static void tablaHG() {
        double[][] tabla = tablaEstadistica.tablaDistribuccionHG(misDatos.getEstudiantes());
        ArrayList<Double> x = new ArrayList<>();
        x.add(1.0);
        x.add(0.0);
        ArrayList<Double> y = new ArrayList<>();
        y.add(0.0);
        y.add(1.0);
        y.add(2.0);
        y.add(3.0);
        mostrarInfoTabla(tabla, x, y, "Tabla Hermanos Genero");
    }
    private static void tablaFG() {
        double[][] tabla = tablaEstadistica.tablaDistribuccionFG(misDatos.getEstudiantes());
        ArrayList<Double> x = new ArrayList<>();
        x.add(1.0);
        x.add(0.0);
        ArrayList<Double> y = new ArrayList<>();
        y.add(2.0);
        y.add(3.0);
        y.add(4.0);
        y.add(5.0);
        y.add(6.0);
        y.add(7.0);
        mostrarInfoTabla(tabla, x, y, "Tabla Familia Genero");
    }
}