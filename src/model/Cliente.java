package model;

public class Cliente {

	private int id;
	private String nome;
	private String documentoCPF;
	private String telefone;
	private int festasAlugadas;

	public Cliente(int id, String nome, String documentoCPF, String telefone, int festasAlugadas) {
		this.id = id;
		this.nome = nome;
		this.documentoCPF = documentoCPF;
		this.telefone = telefone;
		this.festasAlugadas = festasAlugadas;
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

	public String getDocumentoCPF() {
		return documentoCPF;
	}

	public void setDocumentoCPF(String documentoCPF) {
		this.documentoCPF = documentoCPF;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return getNome();
	}
	
	public int getFestasAlugadas() {
		return festasAlugadas;
	}

	public void setFestasAlugadas(int festasAlugadas) {
		this.festasAlugadas = festasAlugadas;
	}

}