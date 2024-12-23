﻿# Gestión de Cafetería

## Descripción

Este proyecto es una aplicación de escritorio para gestionar una cafetería. Permite almacenar información sobre la cafetería y gestionar una lista de cafés disponibles. Los datos se guardan y cargan desde archivos para asegurar la persistencia entre sesiones.

## Funcionalidades del Programa

- **Agregar Café**: Añade nuevos cafés a la lista de la cafetería.
- **Visualizar Datos**: Muestra la información de la cafetería y la lista de cafés.
- **Guardar Datos**: Almacena la información en archivos de texto.
- **Cargar Datos**: Carga la información desde archivos de texto.

## Clases

### `Cafeteria`

#### Atributos

- `String nombre`: Nombre de la cafetería.
- `String direccion`: Dirección de la cafetería.
- `Map<String, String> redesSociales`: Redes sociales de la cafetería.
- `List<Cafe> listaCafes`: Lista de cafés disponibles en la cafetería.

#### Métodos

- `Cafeteria(String nombre, String direccion, Map<String, String> redesSociales)`: Constructor.
- `Cafeteria(String nombre, String direccion, Map<String, String> redesSociales, List<Cafe> listaCafes)`: Constructor.
- `void agregarCafe(Cafe cafe)`: Agrega un café a la lista.
- `List<Cafe> obtenerCafesPorTamano(String tamano)`: Obtiene cafés por tamaño.
- `void descontinuarCafe(Cafe cafe)`: Elimina un café de la lista.
- `void modificarInformacion(String nuevoNombre, String nuevaDireccion, Map<String, String> nuevasRedesSociales)`: Modifica la información de la cafetería.
- `String toString()`: Representa el objeto como una cadena.

### `Cafe`

#### Atributos

- `String nombre`: Nombre del café.
- `int gramosCafe`: Gramos de café utilizados.
- `int mililitrosAgua`: Mililitros de agua utilizados.
- `String tamano`: Tamaño del café.
- `List<String> ingredientesOpcionales`: Ingredientes opcionales del café.

#### Métodos

- `Cafe(String nombre, int gramosCafe, int mililitrosAgua, String tamano, List<String> ingredientesOpcionales)`: Constructor.
- `String toString()`: Representa el objeto como una cadena.

### `CafeteriaController`

#### Atributos

- `Cafeteria cafeteria`: Objeto de la clase `Cafeteria`.

#### Métodos

- `CafeteriaController(Cafeteria cafeteria)`: Constructor.
- `Cafeteria getCafeteria()`: Obtiene el objeto `Cafeteria`.
- `void agregarCafe(Cafe cafe)`: Agrega un café a la cafetería.
- `List<Cafe> obtenerCafesPorTamano(String tamano)`: Obtiene cafés por tamaño.
- `void descontinuarCafe(Cafe cafe)`: Elimina un café de la lista.
- `void modificarInformacionCafeteria(String nuevoNombre, String nuevaDireccion, Map<String, String> nuevasRedesSociales)`: Modifica la información de la cafetería.
- `void guardarDatosCafeteria()`: Guarda los datos de la cafetería.
- `void cargarDatosCafeteria()`: Carga los datos de la cafetería.
- `void guardarDatosCafes()`: Guarda los datos de los cafés.
- `void cargarDatosCafes()`: Carga los datos de los cafés.

### `GestorArchivos`

#### Métodos

- `static void guardarCafeteria(Cafeteria cafeteria, String archivo)`: Guarda los datos de la cafetería en un archivo.
- `static Cafeteria cargarCafeteria(String archivo)`: Carga los datos de la cafetería desde un archivo.
- `static void guardarCafes(List<Cafe> cafes, String archivo)`: Guarda los datos de los cafés en un archivo.
- `static List<Cafe> cargarCafes(String archivo)`: Carga los datos de los cafés desde un archivo.
- `static boolean existeArchivo(String archivo)`: Verifica si un archivo existe.

### `CafeteriaGUI`

#### Atributos

- `CafeteriaController controller`: Objeto controlador para gestionar la lógica de negocio.
- `JTextArea textArea`: Área de texto para mostrar datos.
- `JTextField nombreCafeField, gramosField, mililitrosField, tamanoField, ingredientesField`: Campos de texto para entrada de datos.

#### Métodos

- `CafeteriaGUI(CafeteriaController controller)`: Constructor.
- `void initialize()`: Inicializa los componentes de la GUI.
- `void agregarCafe()`: Agrega un café utilizando los datos ingresados.
- `void mostrarDatos()`: Muestra los datos en la `textArea`.
- `void cargarDatos()`: Carga los datos desde los archivos.
- `void guardarDatos()`: Guarda los datos en los archivos.
