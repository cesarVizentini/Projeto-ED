package model;

public class Cliente {

	private int id;
	private String nome;
	private String documentoCPF;
	private String telefone;

	public Cliente(int id, String nome, String documentoCPF, String telefone) {
		this.id = id;
		this.nome = nome;
		this.documentoCPF = documentoCPF;
		this.telefone = telefone;
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

}