package model;

public class Cafe {
	private int _gramosCafe;
	private int _mililitrosAgua;
	private String _tamaño;
	private List<String> _ingredientesOpcionales;
	public Cafeteria _cafe;

	public int getGramosCafe() {
		return this._gramosCafe;
	}

	public void setGramosCafe(int aGramosCafe) {
		this._gramosCafe = aGramosCafe;
	}

	public int getMililitrosAgua() {
		return this._mililitrosAgua;
	}

	public void setMililitrosAgua(int aMililitrosAgua) {
		this._mililitrosAgua = aMililitrosAgua;
	}

	public String getTamaño() {
		return this._tamaño;
	}

	public void setTamaño(String aTamaño) {
		this._tamaño = aTamaño;
	}

	public List<String> getIngredientesOpcionales() {
		throw new UnsupportedOperationException();
	}

	public void setIngredientesOpcionales(List<String> aIngredientesOpcionales) {
		throw new UnsupportedOperationException();
	}
}