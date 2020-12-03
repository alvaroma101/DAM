/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicación_movil;

/**
 *
 * @author alvar
 */
public class Cam {
    
    Integer resolucion, numCamaras;
    boolean estabilizador;

    public Cam() {
    }

    public Cam(Integer resolucion, Integer numCamaras, boolean estabilizador) {
        this.resolucion = resolucion;
        this.numCamaras = numCamaras;
        this.estabilizador = estabilizador;
    }

    public Integer getResolucion() {
        return resolucion;
    }

    public void setResolucion(Integer resolucion) {
        this.resolucion = resolucion;
    }

    public Integer getNumCamaras() {
        return numCamaras;
    }

    public void setNumCamaras(Integer numCamaras) {
        this.numCamaras = numCamaras;
    }

    public boolean isEstabilizador() {
        return estabilizador;
    }

    public void setEstabilizador(boolean estabilizador) {
        this.estabilizador = estabilizador;
    }

    @Override
    public String toString() {
        return "Cam{" + "resolucion=" + resolucion + 
                ", numCamaras=" + numCamaras + ", estabilizador=" + estabilizador + '}';
    }
}
