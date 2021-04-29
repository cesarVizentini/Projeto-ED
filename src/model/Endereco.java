package model;

public class Endereco {
	
	private String logradouro;
	private String nomeOficial;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	
	public Endereco(String logradouro, String nomeOficial, String numero, String complemento, String bairro,
			String cidade, String uf, String cep) {
		this.logradouro = logradouro;
		this.nomeOficial = nomeOficial;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNomeOficial() {
		return nomeOficial;
	}

	public void setNomeOficial(String nomeOficial) {
		this.nomeOficial = nomeOficial;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return getLogradouro() + " " + getNomeOficial() + ", " + getNumero() + " - " + getComplemento() + " - "
				+ getBairro() + ", " + getCidade() + " - " + getUf() + ", " + getCep();
	}

}
