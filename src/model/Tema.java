package model;

public class Tema {
	
	private int id;
	private String nome;
	private double valorAluguel;
	private String descricao;
	
	public Tema(int id, String nome, String descricao, double valorAluguel) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valorAluguel = valorAluguel;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valorAluguel;
	}

	public void setValor(double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return getNome();
	}
	
}