package principal;

import controller.CafeteriaController;
import gui_vista.CafeteriaGUI;
import model.Cafeteria;
import data.GestorArchivos;

import java.util.HashMap;
import java.util.Map;

public class Principal {
	public static void main(String[] args) {
		// Datos iniciales de la cafeteria
		String nombre = "Cafeteria Central";
		String direccion = "Calle Falsa 123";
		Map<String, String> redesSociales = new HashMap<>();
		redesSociales.put("Instagram", "@cafeteria_central");
		redesSociales.put("Facebook", "Cafeteria Central");

		// Crear el objeto Cafeteria utilizando el constructor con tres parámetros
		Cafeteria cafeteria = new Cafeteria(nombre, direccion, redesSociales);

		// Crear el controlador de la cafeteria
		CafeteriaController controller = new CafeteriaController(cafeteria);

		// Guardar datos iniciales en los archivos solo si no existen
		if (!GestorArchivos.existeArchivo("cafeteria.txt")) {
			controller.guardarDatosCafeteria();
		}
		if (!GestorArchivos.existeArchivo("cafes.txt")) {
			controller.guardarDatosCafes();
		}

		// Cargar datos iniciales desde archivos
		controller.cargarDatosCafeteria();
		controller.cargarDatosCafes();

		// Modificar la información de la cafeteria
		controller.modificarInformacionCafeteria(nombre, direccion, redesSociales);

		// Guardar de nuevo para asegurar que se actualicen los datos iniciales si no existen
		controller.guardarDatosCafeteria();
		controller.guardarDatosCafes();

		// Crear la GUI de la cafeteria
		CafeteriaGUI gui = new CafeteriaGUI(controller);

		// Mostrar datos iniciales en la GUI
		gui.mostrarDatos();
	}
}
