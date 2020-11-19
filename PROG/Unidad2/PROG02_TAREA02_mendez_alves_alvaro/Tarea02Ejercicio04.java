/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2;

/**
 *
 * @author alvar
 */
public class Tarea02Ejercicio04 {
    public static void main(String[] args) {
        
        String nombre = "Alvaro";
        String apellido1 = "Mendez";
        String apellido2 = "Alves";
        int año = 1996;
        
        String usuario = nombre.substring(0, 1).toLowerCase()+
                apellido1.toLowerCase()+
                apellido2.substring(0, 1).toLowerCase()+
                String.valueOf(año).substring(String.valueOf(año).length()-2, String.valueOf(año).length());
        

        System.out.println("Nombre: "+nombre);
        System.out.println("Apellido1: "+apellido1);
        System.out.println("Apellido2: "+apellido2);
        System.out.println("El nombre de usuario es: "+usuario);

    }
}
