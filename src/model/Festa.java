package model;

public class Festa {
	
	private int id;
	private String tema;
	private String cliente;
	private String dataFesta;
	private String horarioInicio;
	private String horarioFinal;
	private String endereco;
	private double valorCobrado;
	
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
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public double getValorCobrado() {
		return valorCobrado;
	}
	
	public void setValorCobrado(double valorCobrado) {
		this.valorCobrado = valorCobrado;
	}
}
