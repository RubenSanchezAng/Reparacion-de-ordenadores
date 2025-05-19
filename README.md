#  Proyecto Intermodular 1º DAW 2024/2025  <img src="LogoEmpresa.png" alt="Icono" width="100"/>

## Servicio de Reparaciones Informáticas
## 📑 Índice
1. [Descripción General](#descripción-general)
2. [Objetivos del Proyecto](#objetivos-del-proyecto)
3. [Equipo](#equipo)
4. [Subsistemas del Proyecto](#subsistemas-del-proyecto)
   - [Gestión de Materiales](#1-gestión-de-materiales)
   - [Gestión de Personal](#2-gestión-de-personal)
   - [Gestión de Reparaciones](#3-gestión-de-reparaciones)
   - [Gestión de Clientes](#4-gestión-de-clientes)
   - [Generación de Informes](#5-generación-de-informes)
5. [Requisitos del Sistema](#requisitos-del-sistema)
6. [Requisitos del Proyecto](#requisitos-del-proyecto)


---
###  Descripción General

Este proyecto tiene como objetivo **crear una empresa de servicios de reparación informática** que incluye:

- Desarrollo de una **aplicación de gestión integral** del servicio técnico.
- Diseño de una **web corporativa**.
- **Instalación informática** que dé soporte a la empresa.

---

###  Objetivos del Proyecto

- Crear una aplicación intuitiva y eficiente para gestionar un taller de reparaciones.
- Integrar todos los procesos desde la recepción del equipo hasta su devolución.
- Mejorar la trazabilidad y eficiencia en la gestión de recursos.
- Facilitar la toma de decisiones mediante herramientas analíticas.
- Diseñar una infraestructura informática adecuada.
- Desarrollar una aplicación web.

---
## 👥 Equipo

Este proyecto fue desarrollado por:

- Rubén Sánchez
- Alejandro Farinós
- Irma Wendolin
- Manuel Rubio
- Lucas Alamar

---
###  Subsistemas del Proyecto

#### 1. Gestión de Materiales
## :wrench: Introducción

El **Subsistema de Gestión de Materiales** es una parte clave del sistema de reparaciones informáticas. Este módulo permite:

- :package: Controlar el inventario de piezas y repuestos.
- :clipboard: Gestionar pedidos a proveedores.
- :hammer_and_wrench: Asignar materiales a reparaciones concretas.
- :warning: Evitar quiebres de stock con alertas automáticas.

> :bulb: _Este subsistema se integra con los módulos de personal, reparaciones, clientes e informes._

---

## :package: Funcionalidades del Subsistema

### :card_index_dividers: Registro de materiales y repuestos

Permite agregar nuevos ítems al inventario, incluyendo:

- Nombre del material
- Descripción
- Proveedor
- Precio unitario
- Cantidad

---

### :inbox_tray: Gestión de stock

- Control de entradas y salidas.
- Visualización de stock actual.
- Alerta de **stock bajo** cuando la cantidad llega al mínimo.
- Recuento automatizado.

---

### :receipt: Orden de compras

- Generación automática de pedidos a proveedores.
- Historial completo de órdenes emitidas.
- Asociaciones con proveedores registrados.

---

### :hammer_and_wrench: Asignación de materiales

- Los materiales pueden asignarse a reparaciones específicas.
- Se registra cantidad usada, fecha y técnico responsable.

---

### :clock4: Historial de materiales

- Informes por período, reparación o cliente.
- Consulta del uso y coste acumulado por reparación.

---

## :bar_chart: Estructura del Código Java

```java
public class Material {
    private String nombre;
    private int stock;
    private String proveedor;
    private double precio;

    public Material(String nombre, int stock, String proveedor, double precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.proveedor = proveedor;
        this.precio = precio;
    }

    public void actualizarStock(int cantidad) {
        this.stock += cantidad;
    }

    public boolean esStockBajo() {
        return this.stock < 5;
    }

    // Getters y Setters...
}
```



---

#### 2. Gestión de Personal
**Objetivo:** Administrar al equipo técnico.  
**Funcionalidades:**
- Registro de empleados y sus especialidades.
- Gestión de turnos y horarios.
- Asignación de tareas.
- Evaluación de desempeño.

---

#### 3. Gestión de Reparaciones
**Objetivo:** Seguimiento de cada reparación desde el ingreso hasta la entrega.  
**Funcionalidades:**
- Registro del problema, diagnóstico y equipo.
- Asignación de técnicos y materiales.
- Seguimiento de estado (en espera, en proceso, completada).
- Estimación de costes y tiempos.
- Informes por cliente y tipo de reparación.

---

#### 4. Gestión de Clientes
**Objetivo:** Administración de personas y empresas que solicitan servicios.  
**Funcionalidades:**
- Registro de datos del cliente.
- Historial de reparaciones.
- Presupuestos personalizados.
- Notificaciones de estado.
- Clasificación de clientes.

---

#### 5. Generación de Informes
**Objetivo:** Seguimiento y análisis del negocio.  
**Funcionalidades:**
- Informes financieros.
- Control de inventario.
- Rendimiento del personal.
- Satisfacción del cliente.
- Exportación (PDF/Excel) e importación de datos.

---

###  Requisitos del Sistema

- **Interfaz Gráfica Amigable (GUI)**
- **Base de datos relacional** (ej. MySQL)
- **Sistema de autenticación** y control de acceso
- **Documentación técnica y guía de usuario**

---

###  Requisitos del Proyecto

- Cumplimiento con todos los módulos del proyecto intermodular.
- Instrucciones del profesorado y del *product owner*.

---

###  Alcance del Proyecto

- Dirigido a talleres pequeños y medianas empresas.

