/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea031articulo;

/**
 *
 * @author alvar
 */
public class EntradaArticulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Articulo 1
        Articulo articulo1 = new Articulo("AB0001545", "AAAEEE", 11, 5.6, (byte)10);
        
        // Articulo 2
        Articulo articulo2 = new Articulo();
        articulo2.setCodigoBarra("AB0001566");
        articulo2.setDenominacion("EEEAAA");
        articulo2.setUnidades(8);
        articulo2.setPrecioCompra(5.5);
        articulo2.setBeneficio((byte)50);
        
        System.out.println("Articulo1");
        System.out.println("CodigoBarra= "+articulo1.getCodigoBarra());
        System.out.println("Denominacion= "+articulo1.getDenominacion());
        System.out.println("Unidades= "+articulo1.getUnidades());
        System.out.println("PrecioCompra= "+articulo1.getPrecioCompra());
        System.out.println("Beneficio= "+articulo1.getBeneficio());
        System.out.println("PVP= "+articulo1.pvp());

        System.out.println("Articulo1");                                     
        System.out.println(articulo2.toString());
        
    }
    
}
