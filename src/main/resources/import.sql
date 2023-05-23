INSERT INTO trabajador (id_trabajador, apellido, email, nombre, password, precio_hora_extra, sueldo_base) Values (1, 'fanega', 'fanega@gmail.com','Alejandro' ,'{bcrypt}$2a$10$DAshztyKHSneszQMBFxs5.VHl.HUKIpSHu/n8t3f/PFiG0ZIEWi7.' ,26, 3012);
INSERT INTO trabajador (id_trabajador, apellido, email, nombre, password, precio_hora_extra, sueldo_base) Values (2, 'Claro', 'claro@gmail.com', 'José','{bcrypt}$2a$10$DAshztyKHSneszQMBFxs5.VHl.HUKIpSHu/n8t3f/PFiG0ZIEWi7.' ,29, 2312);
INSERT INTO cliente (id_cliente, apellido, ciudad, dni, email, nombre, telefono) Values (1, 'perez', 'madrid', '77654902F', 'perez@gmail.com', 'pepe', 675483297);
INSERT INTO cliente (id_cliente, apellido, ciudad, dni, email, nombre, telefono) Values (2, 'lópez', 'sevilla', '7797902S', 'lopez@gmail.com', 'paco', 675432873);
INSERT INTO reforma (id, fecha_final, fecha_inicio, presupuesto, jefe_de_obra_id_trabajador, propietario_id_cliente) Values (1, '2024-03-13', '2020-04-12', 12342, 1, 1);
INSERT INTO reforma (id, fecha_final, fecha_inicio, presupuesto, jefe_de_obra_id_trabajador, propietario_id_cliente) Values (2, '2023-03-13', '2021-04-12', 12282, 2, 1);
INSERT INTO linea_de_materiales (id_linea_de_materiales, cantidad, reforma_id) Values (1, 2, 1);
INSERT INTO linea_de_materiales (id_linea_de_materiales, cantidad, reforma_id) Values (2, 3, 2);
INSERT INTO materiales (id, coste, nombre, pvp_material, linea_venta_id_linea_de_materiales) Values (1, 12, 'ladrillos', 16, 1);
INSERT INTO materiales (id, coste, nombre, pvp_material, linea_venta_id_linea_de_materiales) Values (2, 13, 'cemento', 17, 2);
INSERT INTO parte_trabajador (fecha, reforma_id, trabajador_id, num_horas, num_horas_extra) Values ('2023-04-10', 1, 1, 12, 2);
INSERT INTO parte_trabajador (fecha, reforma_id, trabajador_id, num_horas, num_horas_extra) Values ('2020-02-14', 2, 2, 10, 1);

ALTER SEQUENCE HIBERNATE_SEQUENCE RESTART with 1000
