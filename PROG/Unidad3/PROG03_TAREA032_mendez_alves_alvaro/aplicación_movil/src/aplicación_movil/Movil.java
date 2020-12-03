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
public class Movil {
    
    Integer numTelefono;
    Integer IMEI;
    String marca;
    String modelo;
    So sistemaOperativo;
    Dim dimensiones;
    Cam camaraFrontal;
    Cam camaraTrasera;

    public Movil() {
    }

    public Movil(Integer numTelefono, Integer IMEI, String marca, String modelo, 
            So sistemaOperativo, Dim dimensiones, Cam camaraFrontal, Cam camaraTrasera) {
        this.numTelefono = numTelefono;
        this.IMEI = IMEI;
        this.marca = marca;
        this.modelo = modelo;
        this.sistemaOperativo = sistemaOperativo;
        this.dimensiones = dimensiones;
        this.camaraFrontal = camaraFrontal;
        this.camaraTrasera = camaraTrasera;
    }

    public Integer getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(Integer numTelefono) {
        this.numTelefono = numTelefono;
    }

    public Integer getIMEI() {
        return IMEI;
    }

    public void setIMEI(Integer IMEI) {
        this.IMEI = IMEI;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public So getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(So sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public Dim getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(Dim dimensiones) {
        this.dimensiones = dimensiones;
    }

    public Cam getCamaraFrontal() {
        return camaraFrontal;
    }

    public void setCamaraFrontal(Cam camaraFrontal) {
        this.camaraFrontal = camaraFrontal;
    }

    public Cam getCamaraTrasera() {
        return camaraTrasera;
    }

    public void setCamaraTrasera(Cam camaraTrasera) {
        this.camaraTrasera = camaraTrasera;
    }

    @Override
    public String toString() {
        return "Movil{" + "numTelefono=" + numTelefono + ", IMEI=" + IMEI + 
                ", marca=" + marca + ", modelo=" + modelo + 
                ", sistemaOperativo=" + sistemaOperativo + 
                ", dimensiones=" + dimensiones + ", camaraFrontal=" + camaraFrontal + 
                ", camaraTrasera=" + camaraTrasera + '}';
    }
   
}
