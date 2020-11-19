/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2;
/**
 * Tarea02Ejercicio02
 * Programa de ejemplo de declaración de variables y vista previa.
 * @author alvaro
 */
public class Tarea02Ejercicio02 {

    public enum cursos {
        DAM1, DAM2, DAW1, DAW2
    };

    public static void main(String[] args) {
        String nombre = "Álvaro";
        String apellidos = "Méndez Alves";
        int edad = 24;
        boolean matriculado = true;
        cursos curso = cursos.DAM1;
        double media = 8.75;

        System.out.println("----- EJERCICIO DE VARIABLES Y TIPOS DE DATOS -----");
        System.out.println("El alumno se llama " + nombre + " " + apellidos);
        System.out.println("Tiene " + edad + " años");
        System.out.println("Matriculado " + matriculado + " en " + curso);
        System.out.println("Su nota media es " + media);

    }

}
