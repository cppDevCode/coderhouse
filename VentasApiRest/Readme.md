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

#### To-do
- Terminar con las relaciones
- Funcionabilidad completa
- etc...

### Ejecucion

`$ java -jar 2daPreEntrega-Baldres.jar`

### Route:
- server.com/ : Muestra una pequeña ayuda
- server.com/clientes/listar: Lista la tabla de clientes
- server.com/clientes/agregar: agrega el json definido a la db
- server.com/clientes/modificar/{id}: modifica el registro de clientes de acuerdo a su ID
- server.com/clientes/eliminar/{id}
- server.com/productos/listar
- server.com/productos/agregar
- server.com/productos/modificar
- server.com/productos/eliminar/{id}
- server.com/facturas/listar
- server.com/facturas/agregar
- server.com/facturas/modificar


