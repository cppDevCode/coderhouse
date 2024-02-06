package com.coder.ecommerce.repository;

import com.coder.ecommerce.models.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface RepositoryDetalleFactura extends JpaRepository<DetalleFactura, Long> {

}
