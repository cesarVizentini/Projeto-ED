package model;

public class TemaNo {
	
	private TemaNo anterior;
	private TemaNo proximo;
	private Tema tema;
	
	public TemaNo(Tema tema) {
		this.tema = tema;
		this.anterior = null;
		this.proximo = null;
	}

	public TemaNo getAnterior() {
		return anterior;
	}

	public void setAnterior(TemaNo anterior) {
		this.anterior = anterior;
	}

	public TemaNo getProximo() {
		return proximo;
	}

	public void setProximo(TemaNo proximo) {
		this.proximo = proximo;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	
}
