package model;

import java.util.List;
import java.util.Map;
import java.util.Vector;
import model.Cafe;
import controller.CafeteriaController;

public class Cafeteria {
	private String _nombre;
	private String _direccion;
	private Map<String, String> _redesSociales;
	private List<Cafe> _listaCafes;
	public Vector<Cafe> _cafe = new Vector<Cafe>();
	public CafeteriaController _unnamed_CafeteriaController_;

	public String getNombre() {
		return this._nombre;
	}

	public void setNombre(String aNombre) {
		this._nombre = aNombre;
	}

	public String getDireccion() {
		return this._direccion;
	}

	public void setDireccion(String aDireccion) {
		this._direccion = aDireccion;
	}

	public Map<String, String> getRedesSociales() {
		throw new UnsupportedOperationException();
	}

	public void setRedesSociales(Map<String, String> aRedesSociales) {
		throw new UnsupportedOperationException();
	}

	public List<Cafe> getListaCafes() {
		throw new UnsupportedOperationException();
	}

	public void setListaCafes(List<Cafe> aListaCafes) {
		throw new UnsupportedOperationException();
	}

	public void getAttribute() {
		throw new UnsupportedOperationException();
	}

	public void setAttribute(Object aAttribute) {
		throw new UnsupportedOperationException();
	}

	public void agregarCafe(Cafe aCafe) {
		throw new UnsupportedOperationException();
	}

	public List<Cafe> obtenerCafesPorTamaño(String aTamaño) {
		throw new UnsupportedOperationException();
	}

	public void descontinuarCafe(Cafe aCafe) {
		throw new UnsupportedOperationException();
	}

	public void modificarInformacion(String aNuevoNombre, String aNuevaDireccion, Map<String, String> aNuevasRedesSociales) {
		throw new UnsupportedOperationException();
	}

	public String toString() {
		throw new UnsupportedOperationException();
	}
}