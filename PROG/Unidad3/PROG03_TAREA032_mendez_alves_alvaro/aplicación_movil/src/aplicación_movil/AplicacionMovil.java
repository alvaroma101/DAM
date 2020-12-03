/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicación_movil;

import java.util.Scanner;

/**
 *
 * @author alvar
 */
public class AplicacionMovil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Integer numTelefono, IMEI, soVersion, dimPeso, dimLargo, dimAncho, dimAlto,
                cfResolucion, cfNumCamaras, ctResolucion, ctNumCamaras;
        String marca, modelo, soTipo;
        boolean cfEstabilizador, ctEstabilizador;

        Scanner teclado = new Scanner(System.in);
        System.out.print("Numero de teléfono:");
        numTelefono = teclado.nextInt();
        System.out.print("IMEI:");
        IMEI = teclado.nextInt();
        System.out.print("Marca:");
        marca = teclado.next();
        System.out.print("Modelo:");
        modelo = teclado.next();
        System.out.print("Tipo de sistema operativo:");
        soTipo = teclado.next();
        System.out.print("Versión de sistema operativo:");
        soVersion = teclado.nextInt();
        System.out.print("Peso:");
        dimPeso = teclado.nextInt();
        System.out.print("Largo:");
        dimLargo = teclado.nextInt();
        System.out.print("Ancho:");
        dimAncho = teclado.nextInt();
        System.out.print("Alto:");
        dimAlto = teclado.nextInt();
        System.out.print("Resolución de la cámara frontal:");
        cfResolucion = teclado.nextInt();
        System.out.print("Número de cámaras frontales:");
        cfNumCamaras = teclado.nextInt();
        System.out.print("¿La cámara frontal tiene estabilizador?:");
        cfEstabilizador = teclado.nextBoolean();
        System.out.print("Resolución de la cámara trasera:");
        ctResolucion = teclado.nextInt();
        System.out.print("Número de cámaras traseras:");
        ctNumCamaras = teclado.nextInt();
        System.out.print("¿La cámara trasera tiene estabilizador?:");
        ctEstabilizador = teclado.nextBoolean();

        So so = new So(soTipo, soVersion);
        Dim dim = new Dim(dimPeso, dimLargo, dimAncho, dimAlto);
        Cam cfCam = new Cam(cfResolucion, cfNumCamaras, cfEstabilizador);
        Cam ctCam = new Cam(ctResolucion, ctNumCamaras, ctEstabilizador);

        Movil movil1 = new Movil(numTelefono, IMEI, marca, modelo, so, dim, cfCam, ctCam);
        
        System.out.print(movil1.toString());
    }

}
