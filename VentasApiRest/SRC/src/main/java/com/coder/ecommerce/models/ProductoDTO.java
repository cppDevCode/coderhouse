package com.coder.ecommerce.models;
import jakarta.persistence.*;


//Establezco Entidad para la tabla productos relacionada con la tabla detalleFactura
public class ProductoDTO {

    private String descripcion;

    private String codigo;

    private Double precio;


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }


}
