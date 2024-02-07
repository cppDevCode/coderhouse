package com.coder.ecommerce.repository;

import com.coder.ecommerce.models.Factura;
import com.coder.ecommerce.models.FacturaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryFactura extends JpaRepository<Factura, Long> {

}
