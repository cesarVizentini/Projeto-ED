package controller;

import java.io.IOException;

import model.Cliente;
import persistence.ClienteDao;

public class ClienteController {

	private ClienteDao lista;

	public ClienteController() {
		lista = new ClienteDao();
		ArquivosDiretorios arquivosDiretorios = new ArquivosDiretorios();
		try {
			lista = arquivosDiretorios.getClientes(lista);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void cadastrar(String nome, String documentoCPF, String telefone) {
		Cliente ultimo;
		int id = 0;
		int festasAlugadas = 0;
		if (lista != null) {
			ultimo = lista.getUltimoElemento();
			id = ultimo.getId() + 1;
		} else {
			id = 1;
			lista = new ClienteDao();
		}
		Cliente cliente = new Cliente(id, nome, documentoCPF, telefone, festasAlugadas);
		cliente.setNome(nome);
		cliente.setDocumentoCPF(documentoCPF);
		cliente.setTelefone(telefone);

		lista.adicionarSalvarCliente(cliente);
	}
}
