package com.coder.ecommerce.repository;

import com.coder.ecommerce.models.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface RepositoryDetalleFactura extends JpaRepository<DetalleFactura, Long> {
    /*
    Dado que tengo que posiblemente tenga que eliminar mas de 1 registro de la tabla de detalle
    de factura utilizo funciones de JPA para personalizar la consulta de borrado a la db y evitar
    la eliminacion recorriendo 1 a uno de los registros.
     */
/*    @Modifying
    @Transactional
    @Query("DELETE FROM DetalleFactura o WHERE o.idFactura = ?1")
    void borrarPorIdFactura (Long idFactura);
*/
}
