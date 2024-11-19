package model;

import java.util.List;

public class Cafe {
	private String nombre;
	private int gramosCafe;
	private int mililitrosAgua;
	private String tamano;
	private List<String> ingredientesOpcionales;

	// Constructor
	public Cafe(String nombre, int gramosCafe, int mililitrosAgua, String tamano, List<String> ingredientesOpcionales) {
		this.nombre = nombre;
		this.gramosCafe = gramosCafe;
		this.mililitrosAgua = mililitrosAgua;
		this.tamano = tamano;
		this.ingredientesOpcionales = ingredientesOpcionales;
	}

	// Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getGramosCafe() {
		return gramosCafe;
	}

	public void setGramosCafe(int gramosCafe) {
		this.gramosCafe = gramosCafe;
	}

	public int getMililitrosAgua() {
		return mililitrosAgua;
	}

	public void setMililitrosAgua(int mililitrosAgua) {
		this.mililitrosAgua = mililitrosAgua;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public List<String> getIngredientesOpcionales() {
		return ingredientesOpcionales;
	}

	public void setIngredientesOpcionales(List<String> ingredientesOpcionales) {
		this.ingredientesOpcionales = ingredientesOpcionales;
	}

	@Override
	public String toString() {
		return "Cafe:\n" +
				"Nombre: " + nombre + "\n" +
				"Gramos de cafe: " + gramosCafe + "\n" +
				"Mililitros de agua: " + mililitrosAgua + "\n" +
				"Tamano: " + tamano + "\n" +
				"Ingredientes opcionales: " + String.join(", ", ingredientesOpcionales) + "\n";
	}
}
