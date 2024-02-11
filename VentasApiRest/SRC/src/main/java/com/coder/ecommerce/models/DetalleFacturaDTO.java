package com.coder.ecommerce.models;

import java.util.List;

public class DetalleFacturaDTO {
    private int cantidad;
    private ProductoDTO producto;
    private Double precioProducto;



    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }




    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecio(Double precioProducto) {
        this.precioProducto = precioProducto;
    }


    public ProductoDTO getProducto() {
        return producto;
    }


    public void setProducto(ProductoDTO productos) {
        producto = productos;
    }
}
