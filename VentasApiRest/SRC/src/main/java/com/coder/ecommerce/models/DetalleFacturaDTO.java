package com.coder.ecommerce.models;

import java.util.List;

public class DetalleFacturaDTO {
    private int cantidad;
    private ProductoDTO producto;
    private Double subtotal;



    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }




    public Double getSubtotal() {
        return subtotal;
    }

    public void setPrecio(Double subtotal) {
        this.subtotal = subtotal;
    }


    public ProductoDTO getProducto() {
        return producto;
    }


    public void setProducto(ProductoDTO productos) {
        producto = productos;
    }
}
