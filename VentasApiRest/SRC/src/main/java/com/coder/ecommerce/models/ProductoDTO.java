package com.coder.ecommerce.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


//Establezco Entidad para la tabla productos relacionada con la tabla detalleFactura
@Getter
@Setter
public class ProductoDTO {

    @Schema(description = "Descripcion del producto",requiredMode = Schema.RequiredMode.REQUIRED, example = "Televisor 29")
    private String descripcion;
    @Schema(description = "Codigo del Producto",requiredMode = Schema.RequiredMode.REQUIRED, example = "7798844787")
    private String codigo;
}
