# Repositorio - Curso Programación con Java (CoderHouse)

## Ventas API REST

### 2da Pre-Entrega

#### Realizado
##### Primera Pre-Entrega 
- Se definio Entidades/Controladores y algunos Services
- Se genero la DataBase en MySql (se adjunta instrucciones de generacion de tablas)
- Se empleo SpringBoot con JPA
- Se encuentra Funcional para CRUD clientes/productos/facturas-detalles de facturas

##### Segunda Pre-Entrega
- Se consume API externa de acuerdo a lo solicitado
- Se Agrego DTO en Factura y Detalle de comprobante
- Se Agregaron Relaciones entre facturas y comprobantes
- Eliminacion en Cascada de Factura y Detalles de comprobantes
- Se descuenta productos vendidos

#### To-do
- Funcionabilidad completa
- etc...

### Ejecucion

`$ java -jar 2daPreEntrega-Baldres.jar`

### Route:
- localhost:8080/api/clientes/listar: Lista la tabla de clientes
- localhost:8080/api/clientes/agregar: agrega el json definido a la db
- localhost:8080/api/clientes/modificar/{id}: modifica el registro de clientes de acuerdo a su ID
- localhost:8080/api/clientes/eliminar/{id}
- localhost:8080/api/productos/listar
- localhost:8080/api/productos/agregar
- localhost:8080/api/productos/modificar
- localhost:8080/api/productos/eliminar/{id}
- localhost:8080/api/productos/stock?id=[ID]&ventas=[PRODUCTOS_VENDIDOS]
- localhost:8080/api/facturas/listar
- localhost:8080/api/facturas/agregar
- localhost:8080/api/facturas/modificar


