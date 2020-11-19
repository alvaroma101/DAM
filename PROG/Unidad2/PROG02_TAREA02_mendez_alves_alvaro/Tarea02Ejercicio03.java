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
public class Tarea02Ejercicio03 {
    
    public static void main(String[] args) {
        
        double evaluacion1 = 7.8;
        double evaluacion2 = 4.7;
        double evaluacion3 = 5.6;
        
        int media = (int) Math.round((evaluacion1 + evaluacion2 + evaluacion3)/3);

        System.out.println("Nota de la 1 evaluación: "+evaluacion1);
        System.out.println("Nota de la 2 evaluación: "+evaluacion2);
        System.out.println("Nota de la 3 evaluación: "+evaluacion3);
        System.out.println("La nota media del alumno es: "+media);

    }
}
