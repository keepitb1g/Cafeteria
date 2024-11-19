package model;

import java.util.List;

public class Cafe {
	private int gramosCafe;
	private int mililitrosAgua;
	private String tamaño;
	private List<String> ingredientesOpcionales;
	public Cafeteria _cafe;

	public Cafe(int gramosCafe, int mililitrosAgua, String tamaño, List<String> ingredientesOpcionales) {
		this.gramosCafe = gramosCafe;
		this.mililitrosAgua = mililitrosAgua;
		this.tamaño = tamaño;
		this.ingredientesOpcionales = ingredientesOpcionales; }

	public int getGramosCafe() {
		return this.gramosCafe;
	}

	public void setGramosCafe(int aGramosCafe) {
		this.gramosCafe = aGramosCafe;
	}

	public int getMililitrosAgua() {
		return this.mililitrosAgua;
	}

	public void setMililitrosAgua(int aMililitrosAgua) {
		this.mililitrosAgua = aMililitrosAgua;
	}

	public String getTamaño() {
		return this.tamaño;
	}

	public void setTamaño(String aTamaño) {
		this.tamaño = aTamaño;
	}

	public List<String> getIngredientesOpcionales() {
		return ingredientesOpcionales;
	}

	public void setIngredientesOpcionales(List<String> aIngredientesOpcionales) {
		this.ingredientesOpcionales = ingredientesOpcionales;
	}@Override public String toString() {
		return "Café{" + "gramosCafe=" + gramosCafe + ", mililitrosAgua=" + mililitrosAgua + ", tamaño='" + tamaño + '\'' + ", ingredientesOpcionales=" + ingredientesOpcionales + '}';
	}
}