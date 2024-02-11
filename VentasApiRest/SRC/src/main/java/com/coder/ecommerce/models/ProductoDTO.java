package com.coder.ecommerce.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


//Establezco Entidad para la tabla productos relacionada con la tabla detalleFactura
@Getter
@Setter
public class ProductoDTO {

    private String descripcion;

    private String codigo;
}
