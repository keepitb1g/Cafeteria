package model;

public class Cafe {
	private int _gramosCafe;
	private int _mililitrosAgua;
	private String _tama�o;
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

	public String getTama�o() {
		return this._tama�o;
	}

	public void setTama�o(String aTama�o) {
		this._tama�o = aTama�o;
	}

	public List<String> getIngredientesOpcionales() {
		throw new UnsupportedOperationException();
	}

	public void setIngredientesOpcionales(List<String> aIngredientesOpcionales) {
		throw new UnsupportedOperationException();
	}
}