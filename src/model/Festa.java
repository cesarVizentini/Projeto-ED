package model;

import java.sql.Time;
import java.util.Date;


public class Festa {
	
	private int id;
	private Tema Tema;
	private Cliente Cliente;
	private Date dataFesta;
	private Time horarioInicio;
	private Time horarioFinal;
	private double valorCobrado;
	private double desconto;
	private Endereco Endereco;
	
	public Festa(int id, Date dataFesta, Time horarioInicio, Time horarioFinal, double valorCobrado, double desconto, Tema Tema, Cliente Cliente, Endereco endereco) {
		this.id = id;
		this.dataFesta = dataFesta;
		this.horarioInicio = horarioInicio;
		this.horarioFinal = horarioFinal;
		this.valorCobrado = valorCobrado;
		this.desconto = desconto;
		this.Cliente = Cliente;
		this.Tema = Tema;
		this.Endereco = endereco;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tema getTema() {
		return Tema;
	}

	public void setTema(Tema tema) {
		Tema = tema;
	}

	public Cliente getCliente() {
		return Cliente;
	}

	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}

	public Date getDataFesta() {
		return dataFesta;
	}
	
	public void setDataFesta(Date dataFesta) {
		this.dataFesta = dataFesta;
	}
	
	public Time getHorarioInicio() {
		return horarioInicio;
	}
	
	public void setHorarioInicio(Time horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	
	public Time getHorarioFinal() {
		return horarioFinal;
	}
	
	public void setHorarioFinal(Time horarioFinal) {
		this.horarioFinal = horarioFinal;
	}
	
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

	public Endereco getEndereco() {
		return Endereco;
	}

	public void setEndereco(Endereco endereco) {
		Endereco = endereco;
	}
	
}
