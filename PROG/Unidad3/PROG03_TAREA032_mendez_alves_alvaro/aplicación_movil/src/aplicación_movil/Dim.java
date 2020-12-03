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
public class Dim {
    
    Integer peso, largo, antcho, alto;

    public Dim() {
    }

    public Dim(Integer peso, Integer largo, Integer antcho, Integer alto) {
        this.peso = peso;
        this.largo = largo;
        this.antcho = antcho;
        this.alto = alto;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getLargo() {
        return largo;
    }

    public void setLargo(Integer largo) {
        this.largo = largo;
    }

    public Integer getAntcho() {
        return antcho;
    }

    public void setAntcho(Integer antcho) {
        this.antcho = antcho;
    }

    public Integer getAlto() {
        return alto;
    }

    public void setAlto(Integer alto) {
        this.alto = alto;
    }

    @Override
    public String toString() {
        return "Dim{" + "peso=" + peso + ", largo=" + largo + 
                ", antcho=" + antcho + ", alto=" + alto + '}';
    }
   
}
