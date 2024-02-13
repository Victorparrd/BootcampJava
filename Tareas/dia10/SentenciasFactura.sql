--Top clientes con más facturas
SELECT c.nombre || ' ' || c.apellido AS "Cliente", 
COUNT(f.cliente_id) AS "Cant_facturas" FROM cliente c
JOIN factura f ON c.id = f.cliente_id
GROUP BY "Cliente"
ORDER BY "Cant_facturas" DESC;
LIMIT 5;

--Top clientes que más gastaron
SELECT c.nombre || ' ' || c.apellido AS "Cliente", 
SUM(d.cantidad * p.precio) AS "Gasto_total" 
FROM cliente c JOIN factura f ON c.id = f.cliente_id
JOIN factura_detalle d ON f.id = d.factura_id
JOIN producto p ON d.producto_id = p.id
GROUP BY "Cliente"
ORDER BY "Gasto_total" DESC;
LIMIT 5;

--Top monedas más utilizadas
SELECT m.nombre, COUNT(f.moneda_id) AS "Cant_monedas" FROM moneda m
JOIN factura f ON m.id = f.moneda_id
GROUP BY m.nombre
ORDER BY "Cant_monedas" DESC;
LIMIT 5;

--Top proveedor de productos
SELECT p.nombre AS "Proveedor",
COUNT(pd.nombre) AS "Cantidad_productos" FROM proveedor p 
JOIN producto pd ON p.id = pd.proveedor_id
GROUP BY "Proveedor"
ORDER BY "Cantidad_productos" DESC;
LIMIT 5;

--Productos más vendidos
SELECT p.nombre AS "Producto", SUM(f.cantidad) AS "Vendidos"
FROM producto p JOIN factura_detalle f ON p.id = f.producto_id
GROUP BY "Producto"
ORDER BY "Vendidos" DESC
LIMIT 5;

--Productos menos vendidos
SELECT p.nombre AS "Producto", SUM(f.cantidad) AS "Vendidos"
FROM producto p JOIN factura_detalle f ON p.id = f.producto_id
GROUP BY "Producto"
ORDER BY "Vendidos" ASC;
LIMIT 5;

/*
Consulta que muestre fecha de emisión de factura, nombre y apellido del cliente, 
nombres de productos de esa factura, cantidades compradas, 
nombre de tipo de factura de una factura específica 
*/
SELECT f.fecha_emision, c.nombre || ' ' || c.apellido AS "cliente",
p.nombre AS "producto", d.cantidad, t.nombre AS "tipo_factura"
FROM cliente c JOIN factura f ON c.id = f.cliente_id
JOIN factura_tipo t ON f.factura_tipo_id = t.id
JOIN factura_detalle d ON f.id = d.factura_id
JOIN producto p ON d.producto_id = p.id;

--Montos de facturas ordenadas según totales
SELECT f.id AS "factura_id", SUM(p.precio * d.cantidad) AS "Total" FROM factura f
JOIN factura_detalle d ON f.id = d.factura_id
JOIN producto p ON d.producto_id = p.id
GROUP BY f.id
ORDER BY "Total" DESC;

--Mostrar el iva 10% de los montos totales de facturas (suponer que todos los productos tienen IVA 10%)
SELECT f.id AS "factura_id", 
SUM(p.precio * d.cantidad) AS "Total", SUM((p.precio * 0.1) * cantidad) AS "IVA_10"
FROM factura f JOIN factura_detalle d ON f.id = d.factura_id
JOIN producto p ON d.producto_id = p.id
GROUP BY f.id
ORDER BY "IVA_10" DESC;
