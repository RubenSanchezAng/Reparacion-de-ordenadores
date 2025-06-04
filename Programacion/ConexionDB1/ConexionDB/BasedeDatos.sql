create database proyectoRuben;
use proyectoRuben;
CREATE TABLE Cliente (
    id INT PRIMARY KEY,
    correo VARCHAR(100),
    nombre VARCHAR(100),
    direccion VARCHAR(200)
);

CREATE TABLE Telefono (
    id INT PRIMARY KEY,
    tel VARCHAR(20)
);

CREATE TABLE Encuesta (
    id INT PRIMARY KEY,
    comentario TEXT,
    fecha DATE,
    calf INT,
    idC INT,
    FOREIGN KEY (idC) REFERENCES Cliente(id)
);

CREATE TABLE Equipo (
    id INT PRIMARY KEY,
    estado VARCHAR(50),
    fecha DATE,
    modelo VARCHAR(100),
    marca VARCHAR(100),
    idC INT,
    FOREIGN KEY (idC) REFERENCES Cliente(id)
);

CREATE TABLE Tecnico (
    id INT PRIMARY KEY
);

CREATE TABLE Diagnostico (
    id INT PRIMARY KEY,
    tipo VARCHAR(100),
    formato VARCHAR(100),
    fecha DATE,
    fechaH DATE,
    hora TIME,
    idT INT,
    FOREIGN KEY (idT) REFERENCES Tecnico(id)
);

CREATE TABLE Equipo_Diagnostico (
    idC INT,
    idD INT,
    PRIMARY KEY (idC, idD),
    FOREIGN KEY (idC) REFERENCES Cliente(id),
    FOREIGN KEY (idD) REFERENCES Diagnostico(id)
);

CREATE TABLE Diagnostico_Cliente (
    id INT,
    idC INT,
    PRIMARY KEY (id, idC),
    FOREIGN KEY (id) REFERENCES Diagnostico(id),
    FOREIGN KEY (idC) REFERENCES Cliente(id)
);

CREATE TABLE Factura (
    id INT PRIMARY KEY,
    cantidad DECIMAL(10, 2)
);

CREATE TABLE Presupuesto (
    id INT PRIMARY KEY,
    cantidad DECIMAL(10, 2),
    idD INT,
    idC INT,
    idF INT,
    FOREIGN KEY (idC) REFERENCES Cliente(id),
    FOREIGN KEY (idD) REFERENCES Diagnostico(id),
    FOREIGN KEY (idF) REFERENCES Factura(id)
);

CREATE TABLE Linea_Factura (
    id INT PRIMARY KEY,
    numlineas INT,
    id_factura INT,
    FOREIGN KEY (id_factura) REFERENCES Factura(id)
);

CREATE TABLE Linea_Presupuesto (
    id INT PRIMARY KEY,
    no_linea INT,
    id_presupuesto INT,
    FOREIGN KEY (id_presupuesto) REFERENCES Presupuesto(id)
);

CREATE TABLE Materiales (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    cantidad INT,
    coste DECIMAL(10, 2)
);

CREATE TABLE Presupuesto_Materiales (
    id INT,
    idM INT,
    PRIMARY KEY (id, idM),
    FOREIGN KEY (id) REFERENCES Presupuesto(id),
    FOREIGN KEY (idM) REFERENCES Materiales(id)
);

CREATE TABLE Administrativo (
    id INT PRIMARY KEY
);

CREATE TABLE Factura_Administrativo (
    idF INT,
    idA INT,
    PRIMARY KEY (idF, idA),
    FOREIGN KEY (idF) REFERENCES Factura(id),
    FOREIGN KEY (idA) REFERENCES Administrativo(id)
);

CREATE TABLE Orden_Compra (
    id INT PRIMARY KEY,
    fecha DATE
);

CREATE TABLE Linea_Compra (
    id INT PRIMARY KEY,
    nlineas INT,
    ida INT,
    FOREIGN KEY (ida) REFERENCES Orden_Compra(id)
);

CREATE TABLE Proveedor (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    telefono VARCHAR(20),
    ida INT,
    FOREIGN KEY (ida) REFERENCES Orden_Compra(id)
);

CREATE TABLE Proveedor_Telefono (
    id INT,
    telefono VARCHAR(20),
    PRIMARY KEY (id, telefono),
    FOREIGN KEY (id) REFERENCES Proveedor(id)
);

CREATE TABLE Almacen (
    id INT PRIMARY KEY,
    stock INT,
    fecha DATE,
    ubicacion VARCHAR(100)
);

CREATE TABLE Almacen_Administrativo (
    id INT,
    idad INT,
    PRIMARY KEY (id, idad),
    FOREIGN KEY (id) REFERENCES Almacen(id),
    FOREIGN KEY (idad) REFERENCES Administrativo(id)
);

CREATE TABLE Materiales_Almacen (
    id INT,
    idA INT,
    PRIMARY KEY (id, idA),
    FOREIGN KEY (id) REFERENCES Materiales(id),
    FOREIGN KEY (idA) REFERENCES Almacen(id)
);

CREATE TABLE Cliente_Administrativo (
    idC INT,
    idA INT,
    PRIMARY KEY (idC, idA),
    FOREIGN KEY (idC) REFERENCES Cliente(id),
    FOREIGN KEY (idA) REFERENCES Administrativo(id)
);

CREATE TABLE Empleado (
    id_Empleado INT PRIMARY KEY,
    cargo VARCHAR(100),
    nombre VARCHAR(100),
    tlf VARCHAR(20)
);

CREATE TABLE Turnos (
    id_Turnos INT PRIMARY KEY,
    horas TIME
);

CREATE TABLE hora_inicio (
    id_Empleado INT,
    id_Turnos INT,
    PRIMARY KEY (id_Empleado, id_Turnos),
    FOREIGN KEY (id_Empleado) REFERENCES Empleado(id_Empleado),
    FOREIGN KEY (id_Turnos) REFERENCES Turnos(id_Turnos)
);

CREATE TABLE hora_fin (
    id_Empleado INT,
    id_Turnos INT,
    PRIMARY KEY (id_Empleado, id_Turnos),
    FOREIGN KEY (id_Empleado) REFERENCES Empleado(id_Empleado),
    FOREIGN KEY (id_Turnos) REFERENCES Turnos(id_Turnos)
);


