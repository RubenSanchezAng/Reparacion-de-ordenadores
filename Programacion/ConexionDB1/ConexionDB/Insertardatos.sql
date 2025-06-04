INSERT INTO Cliente (id, correo, nombre, direccion) VALUES
(1, 'ana.gomez@example.com', 'Ana Gómez', 'Calle Falsa 123, Valencia'),
(2, 'juan.perez@example.com', 'Juan Pérez', 'Avenida Siempreviva 742, Madrid'),
(3, 'maria.lopez@example.com', 'María López', 'Plaza Mayor 5, Barcelona'),
(4, 'pedro.ruiz@example.com', 'Pedro Ruiz', 'Ronda de Poniente 8, Sevilla'),
(5, 'laura.garcia@example.com', 'Laura García', 'Paseo del Prado 1, Valencia');

INSERT INTO Telefono (id, tel) VALUES
(1, '600123456'),
(2, '601234567'),
(3, '602345678'),
(4, '603456789'),
(5, '604567890');

INSERT INTO Encuesta (id, comentario, fecha, calf, idC) VALUES
(1, 'Excelente servicio, muy rápido.', '2024-05-15', 5, 1),
(2, 'Bien, pero podría mejorar el tiempo de respuesta.', '2024-05-16', 3, 2),
(3, 'Muy satisfecho con la reparación.', '2024-05-17', 4, 3),
(4, 'Necesité llamar varias veces para seguimiento.', '2024-05-18', 2, 4),
(5, 'Todo perfecto, lo recomiendo.', '2024-05-19', 5, 5);

INSERT INTO Equipo (id, estado, fecha, modelo, marca, idC) VALUES
(101, 'Reparado', '2024-05-10', 'Laptop XPS 15', 'Dell', 1),
(102, 'En Diagnóstico', '2024-05-12', 'Smart TV QLED', 'Samsung', 2),
(103, 'Pendiente Pieza', '2024-05-14', 'Smartphone Pixel 6', 'Google', 3),
(104, 'Entregado', '2024-05-16', 'Tablet iPad Air', 'Apple', 4),
(105, 'Reparado', '2024-05-18', 'PC Sobremesa Gaming', 'HP', 5);

INSERT INTO Tecnico (id) VALUES
(1001),
(1002),
(1003),
(1004),
(1005);

INSERT INTO Diagnostico (id, tipo, formato, fecha, fechaH, hora, idT) VALUES
(10001, 'Fallo de Encendido', 'Presencial', '2024-05-11', '2024-05-11', '10:00:00', 1001),
(10002, 'Problema de Software', 'Remoto', '2024-05-13', '2024-05-13', '14:30:00', 1002),
(10003, 'Daño Físico Pantalla', 'Presencial', '2024-05-15', '2024-05-15', '09:00:00', 1003),
(10004, 'Lentitud del Sistema', 'Remoto', '2024-05-17', '2024-05-17', '11:15:00', 1004),
(10005, 'Fallo de Tarjeta Gráfica', 'Presencial', '2024-05-19', '2024-05-19', '16:00:00', 1005);


INSERT INTO Equipo_Diagnostico (idC, idD) VALUES
(1, 10001),
(2, 10002),
(3, 10003),
(4, 10004),
(5, 10005);

INSERT INTO Diagnostico_Cliente (id, idC) VALUES
(10001, 1),
(10002, 2),
(10003, 3),
(10004, 4),
(10005, 5);

INSERT INTO Factura (id, cantidad) VALUES
(201, 150.00),
(202, 75.50),
(203, 300.25),
(204, 99.99),
(205, 50.00);

INSERT INTO Presupuesto (id, cantidad, idD, idC, idF) VALUES
(301, 120.00, 10001, 1, 201),
(302, 60.00, 10002, 2, 202),
(303, 280.00, 10003, 3, 203),
(304, 85.00, 10004, 4, 204),
(305, 45.00, 10005, 5, 205);

INSERT INTO Linea_Factura (id, numlineas, id_factura) VALUES
(401, 2, 201),
(402, 1, 202),
(403, 3, 203),
(404, 1, 204),
(405, 1, 205);

INSERT INTO Linea_Presupuesto (id, no_linea, id_presupuesto) VALUES
(501, 1, 301),
(502, 1, 302),
(503, 2, 303),
(504, 1, 304),
(505, 1, 305);

INSERT INTO Materiales (id, nombre, cantidad, coste) VALUES
(601, 'Pantalla LCD', 5, 80.00),
(602, 'Memoria RAM 8GB', 10, 35.00),
(603, 'Batería de Litio', 7, 25.00),
(604, 'Disco SSD 500GB', 3, 60.00),
(605, 'Teclado USB', 12, 15.00);

INSERT INTO Presupuesto_Materiales (id, idM) VALUES
(301, 601),
(302, 602),
(303, 601),
(304, 604),
(305, 603);

INSERT INTO Administrativo (id) VALUES
(701),
(702),
(703),
(704),
(705);

INSERT INTO Factura_Administrativo (idF, idA) VALUES
(201, 701),
(202, 702),
(203, 703),
(204, 704),
(205, 705);

INSERT INTO Orden_Compra (id, fecha) VALUES
(801, '2024-05-01'),
(802, '2024-05-05'),
(803, '2024-05-10'),
(804, '2024-05-15'),
(805, '2024-05-20');


INSERT INTO Linea_Compra (id, nlineas, ida) VALUES
(901, 3, 801),
(902, 1, 802),
(903, 5, 803),
(904, 2, 804),
(905, 4, 805);

INSERT INTO Proveedor (id, nombre, telefono, ida) VALUES
(1001, 'Tech Supplies S.L.', '912345678', 801),
(1002, 'Componentes Rápidos S.A.', '934567890', 802),
(1003, 'Global Parts Corp.', '956789012', 803),
(1004, 'Materiales Electrónicos', '967890123', 804),
(1005, 'Distribuidora Tech', '978901234', 805);

INSERT INTO Proveedor_Telefono (id, telefono) VALUES
(1001, '912345678'),
(1001, '610112233'),
(1002, '934567890'),
(1003, '956789012'),
(1004, '967890123');

INSERT INTO Almacen (id, stock, fecha, ubicacion) VALUES
(1101, 150, '2024-05-20', 'Nave A, Pasillo 1'),
(1102, 75, '2024-05-20', 'Nave B, Estante 3'),
(1103, 200, '2024-05-21', 'Nave C, Zona de Recepción'),
(1104, 120, '2024-05-21', 'Nave A, Pasillo 5'),
(1105, 90, '2024-05-22', 'Nave B, Estante 1');

INSERT INTO Almacen_Administrativo (id, idad) VALUES
(1101, 701),
(1102, 702),
(1103, 703),
(1104, 704),
(1105, 705);

INSERT INTO Materiales_Almacen (id, idA) VALUES
(601, 1101),
(602, 1102),
(603, 1103),
(604, 1104),
(605, 1105);

INSERT INTO Cliente_Administrativo (idC, idA) VALUES
(1, 701),
(2, 702),
(3, 703),
(4, 704),
(5, 705);

INSERT INTO Empleado (id_Empleado, cargo, nombre, tlf) VALUES
(2001, 'Técnico Senior', 'Carlos Ruiz', '650111222'),
(2002, 'Técnico Junior', 'Sofía Vargas', '650333444'),
(2003, 'Recepcionista', 'Elena Martín', '650555666'),
(2004, 'Gerente de Almacén', 'David Jiménez', '650777888'),
(2005, 'Contable', 'Isabel Castro', '650999000');

INSERT INTO Turnos (id_Turnos, horas) VALUES
(3001, '08:00:00'),
(3002, '16:00:00'),
(3003, '09:00:00'),
(3004, '17:00:00'),
(3005, '10:00:00');

INSERT INTO hora_inicio (id_Empleado, id_Turnos) VALUES
(2001, 3001),
(2002, 3001),
(2003, 3003),
(2004, 3001),
(2005, 3003);

INSERT INTO hora_fin (id_Empleado, id_Turnos) VALUES
(2001, 3002),
(2002, 3002),
(2003, 3004),
(2004, 3002),
(2005, 3004);

