package model;

public class ClienteNo {

	private ClienteNo anterior;
	private ClienteNo proximo;
	private Cliente cliente;
	
	public ClienteNo(Cliente cliente) {
		this.cliente = cliente;
		this.anterior = null;
		this.proximo = null;
	}

	public ClienteNo getAnterior() {
		return anterior;
	}

	public void setAnterior(ClienteNo anterior) {
		this.anterior = anterior;
	}

	public ClienteNo getProximo() {
		return proximo;
	}

	public void setProximo(ClienteNo proximo) {
		this.proximo = proximo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
