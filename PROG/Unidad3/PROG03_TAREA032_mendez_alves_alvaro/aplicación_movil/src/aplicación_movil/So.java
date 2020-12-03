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
public class So {
    
    String tipo;
    Integer version;

    public So() {
    }

    public So(String tipo, Integer version) {
        this.tipo = tipo;
        this.version = version;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "So{" + "tipo=" + tipo + ", version=" + version + '}';
    }

}
