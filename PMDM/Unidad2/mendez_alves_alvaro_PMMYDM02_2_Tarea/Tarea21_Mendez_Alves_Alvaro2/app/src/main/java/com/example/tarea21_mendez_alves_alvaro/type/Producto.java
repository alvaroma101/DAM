package com.example.tarea21_mendez_alves_alvaro.type;

import java.util.Comparator;

public class Producto {

    private Integer id;
    private String producto;
    private Integer cantidad;
    private Float precio;

    public Producto(Integer id, String producto, Integer cantidad, Float precio) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Producto(String producto, Integer cantidad, Float precio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto:\t" + producto + "\nCantidad:\t" + cantidad + "\nPrecio:\t" + precio + "€";
    }
}
