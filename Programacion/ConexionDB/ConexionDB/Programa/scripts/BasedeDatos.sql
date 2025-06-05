create database ReparacionOrdenadores;
use ReparacionOrdenadores;
CREATE TABLE Cliente (
    id INT PRIMARY KEY,
    correo VARCHAR(100),
    nombre VARCHAR(100),
    direccion VARCHAR(200)
);
CREATE TABLE Empleado (
    id_Empleado INT PRIMARY KEY,
    cargo VARCHAR(100),
    nombre VARCHAR(100),
    tlf VARCHAR(20)
);
CREATE TABLE Administrativo (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Empleado(id_Empleado)
);
CREATE TABLE Tecnico (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Empleado(id_Empleado)
);

CREATE TABLE Equipo (
    id INT PRIMARY KEY,
    estado VARCHAR(50),
    fecha DATE,
    modelo VARCHAR(100),
    marca VARCHAR(100),
    idT INT,
    FOREIGN KEY (idT) REFERENCES Tecnico(id)
);

CREATE TABLE Factura (
    id INT PRIMARY KEY,
    cantidad DECIMAL(10, 2),
	idA INT,
	FOREIGN KEY (idA) REFERENCES Administrativo(id)

);

CREATE TABLE Presupuesto (
    id INT PRIMARY KEY,
    cantidad DECIMAL(10, 2),
    idE INT,
    idC INT,
    idF INT,
    FOREIGN KEY (idC) REFERENCES Cliente(id),
    FOREIGN KEY (idE) REFERENCES Equipo(id),
    FOREIGN KEY (idF) REFERENCES Factura(id)
);
CREATE TABLE Almacen (
    id INT PRIMARY KEY,
    fecha DATE,
    ubicacion VARCHAR(100)
);

CREATE TABLE Materiales (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    stock INT,
    coste DECIMAL(10, 2),
    idA INT,
	FOREIGN KEY (idA) REFERENCES Almacen(id)

);

CREATE TABLE Presupuesto_Materiales (
    id INT,
    idM INT,
    PRIMARY KEY (id, idM),
    FOREIGN KEY (id) REFERENCES Presupuesto(id),
    FOREIGN KEY (idM) REFERENCES Materiales(id)
);

CREATE TABLE Proveedor (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    telefono VARCHAR(20)
    );

CREATE TABLE Orden_Compra (
    id INT PRIMARY KEY,
    fecha DATE,
    idP INT,	
	idA INT,
	FOREIGN KEY (idA) REFERENCES Administrativo(id),
    FOREIGN KEY (idP) REFERENCES Proveedor(id)
);

CREATE TABLE Linea_Compra (
    id INT PRIMARY KEY,
    nlineas INT,
    ida INT,
    idM INT,
    FOREIGN KEY (ida) REFERENCES Orden_Compra(id),
	FOREIGN KEY (idM) REFERENCES Materiales(id)

);









