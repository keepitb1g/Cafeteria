package model;

import java.util.List;

public class Cafe {
	private int gramosCafe;
	private int mililitrosAgua;
	private String tama�o;
	private List<String> ingredientesOpcionales;
	public Cafeteria _cafe;

	public Cafe(int gramosCafe, int mililitrosAgua, String tama�o, List<String> ingredientesOpcionales) {
		this.gramosCafe = gramosCafe;
		this.mililitrosAgua = mililitrosAgua;
		this.tama�o = tama�o;
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

	public String getTama�o() {
		return this.tama�o;
	}

	public void setTama�o(String aTama�o) {
		this.tama�o = aTama�o;
	}

	public List<String> getIngredientesOpcionales() {
		return ingredientesOpcionales;
	}

	public void setIngredientesOpcionales(List<String> aIngredientesOpcionales) {
		this.ingredientesOpcionales = ingredientesOpcionales;
	}@Override public String toString() {
		return "Caf�{" + "gramosCafe=" + gramosCafe + ", mililitrosAgua=" + mililitrosAgua + ", tama�o='" + tama�o + '\'' + ", ingredientesOpcionales=" + ingredientesOpcionales + '}';
	}
}