use ReparacionOrdenadores;
INSERT INTO Cliente VALUES 
(1, 'ana.garcia@example.com', 'Ana García', 'Calle Mayor 12'),
(2, 'luis.rodriguez@example.com', 'Luis Rodríguez', 'Av. del Sol 45'),
(3, 'maria.lopez@example.com', 'María López', 'Plaza Central 5'),
(4, 'carlos.martin@example.com', 'Carlos Martín', 'Calle Luna 33');

INSERT INTO Empleado VALUES 
(1, 'Administrativo', 'Laura Torres', '600123456'),
(2, 'Administrativo', 'Jorge Díaz', '611234567'),
(3, 'Técnico', 'Pedro Morales', '622345678'),
(4, 'Técnico', 'Sandra Ruiz', '633456789');

INSERT INTO Administrativo VALUES 
(1),
(2);

INSERT INTO Tecnico VALUES 
(3),
(4);

INSERT INTO Equipo VALUES 
(1, 'Reparado', '2025-05-01', 'XPS 13', 'Dell', 4),
(2, 'En reparación', '2025-05-02', 'MacBook Pro', 'Apple', 3),
(3, 'Pendiente diagnóstico', '2025-05-03', 'Aspire 5', 'Acer', 3),
(4, 'Reparado', '2025-05-04', 'ThinkPad X1', 'Lenovo', 4);


INSERT INTO Factura VALUES 
(1, 150.00 ,1),
(2, 200.50,1),
(3, 99.99,2),
(4, 175.75,2);

INSERT INTO Presupuesto VALUES 
(1, 150.00, 1, 1, 1),
(2, 200.50, 2, 2, 2),
(3, 99.99, 3, 3, 3),
(4, 175.75, 4, 4, 4);

INSERT INTO Almacen VALUES 
(1, '2025-04-01', 'Madrid - Norte'),
(2, '2025-04-05', 'Barcelona - Centro'),
(3, '2025-04-10', 'Valencia - Este'),
(4, '2025-04-15', 'Sevilla - Sur');

INSERT INTO Materiales VALUES 
(1, 'Pantalla LCD 13"', 120, 80.00,3),
(2, 'Batería portátil',40, 50.00,3),
(3,'Disco SSD 512GB', 70, 70.00,2),
(4, 'Pasta térmica',90, 5.75,1);

INSERT INTO Presupuesto_Materiales VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4);

INSERT INTO Proveedor VALUES 
(1, 'ElectroRepuestos S.A.', '911223344'),
(2, 'TechParts SL', '922334455'),
(3, 'Hardware Proveedores', '933445566'),
(4, 'Suministros Globales', '944556677');

INSERT INTO Orden_Compra VALUES 
(1, '2025-04-01',1,1),
(2, '2025-04-05',2,1),
(3, '2025-04-10',3,2),
(4, '2025-04-15',4,2);

INSERT INTO Linea_Compra VALUES 
(1,3, 2, 1),
(2,10, 3, 2),
(3,23, 1, 3),
(4,14, 4, 4);

