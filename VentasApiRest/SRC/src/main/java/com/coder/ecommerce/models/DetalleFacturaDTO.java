package com.coder.ecommerce.models;

import java.util.List;

public class DetalleFacturaDTO {
    private int cantidad;
    private ProductoDTO producto;
    private Double precio;



    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }




    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    public ProductoDTO getProducto() {
        return producto;
    }


    public void setProducto(ProductoDTO productos) {
        producto = productos;
    }
}
