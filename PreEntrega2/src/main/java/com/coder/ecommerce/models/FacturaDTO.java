package com.coder.ecommerce.models;


import java.time.LocalDateTime;
import java.util.List;

public class FacturaDTO {
    private Long id;
    private Long idCliente;

    private LocalDateTime creadoEn;
    private Double total;
    private List<DetalleFacturaDTO> detalleFactura;

    public FacturaDTO(){}
    public List<DetalleFacturaDTO> getDetalleFactura() {
        return this.detalleFactura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setDetalleFactura(List<DetalleFacturaDTO> detalleFactura) {
        this.detalleFactura = detalleFactura;
    }
}
