# Gestión de Inventario de Libros

Este proyecto es una aplicación de consola desarrollada en Java que permite gestionar un inventario de libros, registrar ventas y generar reportes de ventas. Está diseñado para ser utilizado en un entorno educativo o como base para proyectos más complejos.

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes:

- **`factories`**: Contiene la clase `MenuFactory`, que se encarga de inicializar y gestionar los menús principales de la aplicación.
- **`main`**: Contiene la clase principal `Main` que inicia la ejecución del programa.
- **`menus`**: Contiene las clases que implementan los menús para gestionar libros, ventas y reportes.
- **`modelos`**: Contiene las clases que representan las entidades principales del sistema, como `Libro` y `Venta`.
- **`servicio`**: Contiene las clases que implementan la lógica de negocio, como `ServicioLibros`, `ServicioVentas` y `ServicioReportes`.
- **`util`**: Contiene utilidades como `ArchivoUtil` para la lectura y escritura de archivos.

## Funcionalidades

### Gestión de Libros
- Agregar libros al inventario.
- Listar libros disponibles.

### Gestión de Ventas
- Registrar ventas de libros.
- Validar el stock disponible antes de realizar una venta.

### Reportes
- Generar un reporte general de ventas, mostrando:
  - Título del libro.
  - Cantidad vendida.
  - Total generado por las ventas.

## Archivos de Datos

El proyecto utiliza dos archivos CSV para almacenar los datos:

- **`libros.csv`**: Contiene la información de los libros en el inventario.
  - Formato: `Titulo|Autor|Genero|Precio|Stock`
- **`ventas.csv`**: Contiene el registro de las ventas realizadas.
  - Formato: `libro|cantidad|fecha`

## Requisitos

- **Java 21** o superior.
- Un entorno de desarrollo como Eclipse o Visual Studio Code.

## Ejecución

1. Clona este repositorio en tu máquina local.
2. Asegúrate de tener configurado el entorno de Java.
3. Compila y ejecuta la clase principal `Main` ubicada en el paquete `main`.

