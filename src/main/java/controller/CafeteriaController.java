package controller;

import model.Cafeteria;
import model.Cafe;
import data.GestorArchivos;

import java.util.List;
import java.util.Map;

public class CafeteriaController {
	private Cafeteria cafeteria;

	// Constructor
	public CafeteriaController(Cafeteria cafeteria) {
		this.cafeteria = cafeteria;
	}

	public Cafeteria getCafeteria() {
		return cafeteria;
	}

	// Métodos para gestionar los cafes
	public void agregarCafe(Cafe cafe) {
		cafeteria.agregarCafe(cafe);
	}

	public List<Cafe> obtenerCafesPorTamano(String tamano) {
		return cafeteria.obtenerCafesPorTamano(tamano);
	}

	public void descontinuarCafe(Cafe cafe) {
		cafeteria.descontinuarCafe(cafe);
	}

	public void modificarInformacionCafeteria(String nuevoNombre, String nuevaDireccion, Map<String, String> nuevasRedesSociales) {
		cafeteria.modificarInformacion(nuevoNombre, nuevaDireccion, nuevasRedesSociales);
	}

	// Métodos para guardar y cargar datos
	public void guardarDatosCafeteria() {
		GestorArchivos.guardarCafeteria(cafeteria, "cafeteria.txt");
	}

	public void cargarDatosCafeteria() {
		Cafeteria cargada = GestorArchivos.cargarCafeteria("cafeteria.txt");
		if (cargada != null) {
			cafeteria.modificarInformacion(cargada.getNombre(), cargada.getDireccion(), cargada.getRedesSociales());
			cafeteria.setListaCafes(cargada.getListaCafes());
		}
	}

	public void guardarDatosCafes() {
		GestorArchivos.guardarCafes(cafeteria.getListaCafes(), "cafes.txt");
	}

	public void cargarDatosCafes() {
		List<Cafe> cafes = GestorArchivos.cargarCafes("cafes.txt");
		cafeteria.setListaCafes(cafes);
	}
}
