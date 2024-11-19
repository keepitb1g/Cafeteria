package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cafeteria {
	private String nombre;
	private String direccion;
	private Map<String, String> redesSociales;
	private List<Cafe> listaCafes;

	// Constructor
	public Cafeteria(String nombre, String direccion, Map<String, String> redesSociales, List<Cafe> listaCafes) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.redesSociales = redesSociales;
		this.listaCafes = new ArrayList<>();
	}

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

	// M�todos para gestionar los caf�s
	public void agregarCaf�(Cafe cafe) {
		listaCafes.add(cafe);
	}

	public List<Cafe> obtenerCaf�sPorTama�o(String tamano) {
		List<Cafe> cafesPorTama�o = new ArrayList<>();
		for (Cafe cafe : listaCafes) {
			if (cafe.getTama�o().equals(tamano)) {
				cafesPorTama�o.add(cafe);
			}
		}
		return cafesPorTama�o;
	}

	public void descontinuarCaf�(Cafe cafe) {
		listaCafes.remove(cafe);
	}

	public void modificarInformaci�n(String nuevoNombre, String nuevaDireccion, Map<String, String> nuevasRedesSociales) {
		this.nombre = nuevoNombre;
		this.direccion = nuevaDireccion;
		this.redesSociales = nuevasRedesSociales;
	}

	@Override
	public String toString() {
		return "Cafeter�a{" +
				"nombre='" + nombre + '\'' +
				", direccion='" + direccion + '\'' +
				", redesSociales=" + redesSociales +
				", listaCafes=" + listaCafes +
				'}';
	}
}
