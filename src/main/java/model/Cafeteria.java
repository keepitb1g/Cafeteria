package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cafeteria {
	private String nombre;
	private String direccion;
	private Map<String, String> redesSociales;
	private List<Cafe> listaCafes;

	// Constructor con tres parámetros
	public Cafeteria(String nombre, String direccion, Map<String, String> redesSociales) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.redesSociales = redesSociales;
		this.listaCafes = new ArrayList<>();
	}

	// Constructor con cuatro parámetros
	public Cafeteria(String nombre, String direccion, Map<String, String> redesSociales, List<Cafe> listaCafes) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.redesSociales = redesSociales;
		this.listaCafes = listaCafes;
	}

	// Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Map<String, String> getRedesSociales() {
		return redesSociales;
	}

	public void setRedesSociales(Map<String, String> redesSociales) {
		this.redesSociales = redesSociales;
	}

	public List<Cafe> getListaCafes() {
		return listaCafes;
	}

	public void setListaCafes(List<Cafe> listaCafes) {
		this.listaCafes = listaCafes;
	}

	// Métodos para gestionar los cafes
	public void agregarCafe(Cafe cafe) {
		listaCafes.add(cafe);
	}

	public List<Cafe> obtenerCafesPorTamano(String tamano) {
		List<Cafe> cafesPorTamano = new ArrayList<>();
		for (Cafe cafe : listaCafes) {
			if (cafe.getTamano().equals(tamano)) {
				cafesPorTamano.add(cafe);
			}
		}
		return cafesPorTamano;
	}

	public void descontinuarCafe(Cafe cafe) {
		listaCafes.remove(cafe);
	}

	public void modificarInformacion(String nuevoNombre, String nuevaDireccion, Map<String, String> nuevasRedesSociales) {
		this.nombre = nuevoNombre;
		this.direccion = nuevaDireccion;
		this.redesSociales = nuevasRedesSociales;
	}

	@Override
	public String toString() {
		return "Cafeteria:\n" +
				"Nombre: '" + nombre + '\'' + "\n" +
				"Direccion: '" + direccion + '\'' + "\n" +
				"Redes Sociales: " + redesSociales.entrySet().stream()
				.map(entry -> entry.getKey() + ": " + entry.getValue())
				.collect(Collectors.joining(", ")) + "\n" +
				"Lista de cafes:\n" + listaCafes.stream()
				.map(Cafe::toString)
				.collect(Collectors.joining("\n")) + "\n";
	}
}
