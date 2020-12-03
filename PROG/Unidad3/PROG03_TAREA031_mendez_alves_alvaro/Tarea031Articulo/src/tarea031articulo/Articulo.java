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
public class Articulo {
    
    String codigoBarra;
    String denominacion;
    Integer unidades;
    double precioCompra;
    byte beneficio;

    public Articulo() {
    }

    public Articulo(String codigoBarra, String denominacion, Integer unidades, 
            double precioCompra, byte beneficio) {
        this.codigoBarra = codigoBarra;
        this.denominacion = denominacion;
        this.unidades = unidades;
        this.precioCompra = precioCompra;
        this.beneficio = beneficio;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public byte getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(byte beneficio) {
        this.beneficio = beneficio;
    }
    
    public double pvp() {
        return this.precioCompra + ((this.precioCompra*this.beneficio)/100);
    }

    @Override
    public String toString() {
        return "CodigoBarra= " + codigoBarra + "\nDenominacion= " + 
                denominacion + "\nUnidades= " + unidades + "\nPrecioCompra= " + 
                precioCompra + "\nBeneficio= " + beneficio + "\nPVP= " + pvp();
    }
    
    
}
