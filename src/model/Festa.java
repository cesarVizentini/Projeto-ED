package model;

public class Festa {
	
	private int id;
	private String tema;
	private String cliente;
	private String dataFesta;
	private String horarioInicio;
	private String horarioFinal;
	private String logradouro;
	private String nomeOficial;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	private double valorCobrado = 100.00;
	private double desconto;
	private String endereco;
	
	public Festa(int id, String tema, String cliente, String dataFesta, String horarioInicio, String horarioFinal, String endereco, double valorCobrado) {
		this.id = id;
		this.tema = tema;
		this.cliente = cliente;
		this.dataFesta = dataFesta;
		this.horarioInicio = horarioInicio;
		this.horarioFinal = horarioFinal;
		this.endereco = endereco;
		this.valorCobrado = valorCobrado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDataFesta() {
		return dataFesta;
	}
	
	public void setDataFesta(String dataFesta) {
		this.dataFesta = dataFesta;
	}
	
	public String getHorarioInicio() {
		return horarioInicio;
	}
	
	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	
	public String getHorarioFinal() {
		return horarioFinal;
	}
	
	public void setHorarioFinal(String horarioFinal) {
		this.horarioFinal = horarioFinal;
	}
	
	// Endereco da festa
	
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
	
	// Fim Endereco da festa
	
	public double getValorCobrado() {
		return valorCobrado;
	}
	
	public void setValorCobrado(double valorCobrado) {
		this.valorCobrado = valorCobrado;
	}
	
	public double getDesconto() {
		return desconto;
	}
	
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	
	@Override
	public String toString() {
		endereco = getLogradouro() + " " + getNomeOficial() + ", " + getNumero() + " - " + getComplemento() + " - "
				+ getBairro() + ", " + getCidade() + " - " + getUf() + ", " + getCep();
		return endereco;
	}
}
