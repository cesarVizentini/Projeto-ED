package model;

public class FestaNo {

	private FestaNo anterior;
	private FestaNo proximo;
	private Festa festa;
	
	public FestaNo(Festa festa) {
		this.festa = festa;
		this.anterior = null;
		this.proximo = null;
	}

	public FestaNo getAnterior() {
		return anterior;
	}

	public void setAnterior(FestaNo anterior) {
		this.anterior = anterior;
	}

	public FestaNo getProximo() {
		return proximo;
	}

	public void setProximo(FestaNo proximo) {
		this.proximo = proximo;
	}

	public Festa getFesta() {
		return festa;
	}

	public void setFesta(Festa festa) {
		this.festa = festa;
	}
	
}
