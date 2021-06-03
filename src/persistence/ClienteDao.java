package persistence;

import java.io.IOException;
import javax.swing.JOptionPane;
import controller.ArquivosDiretorios;
import model.Cliente;
import model.ClienteNo;

public class ClienteDao {
	private ClienteNo inicio;

	public ClienteDao() {
		this.inicio = null;
	}

	public int tamanho() {
		ClienteNo aux = this.inicio;
		int cont = 0;
		if (aux != null) {
			while (aux.getProximo() != null) {
				aux = aux.getProximo();
				cont++;
			}
		}
		return cont;
	}

	public Cliente getCliente(int cliente) {
		ClienteNo aux = this.inicio;
		for (int i = 0; i < cliente; i++) {
			aux = aux.getProximo();
		}
		if (aux == null) {
			return null;
		}
		return aux.getCliente();
	}

	public void adicionarSalvarCliente(Cliente cliente) {
		ClienteNo no = new ClienteNo(cliente);
		if (this.inicio == null) {
			this.inicio = no;
		} else {
			ClienteNo aux = this.inicio;
			while (aux.getProximo() != null) {
				aux = aux.getProximo();
			}
			aux.setProximo(no);
			no.setAnterior(aux);
		}
		ArquivosDiretorios arquivosDiretorios = new ArquivosDiretorios();
		try {
			arquivosDiretorios.salvarCliente(cliente);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void adicionarCliente(Cliente cliente) {
		ClienteNo no = new ClienteNo(cliente);
		if (this.inicio == null) {
			this.inicio = no;
		} else {
			ClienteNo aux = this.inicio;
			while (aux.getProximo() != null) {
				aux = aux.getProximo();
			}
			aux.setProximo(no);
			no.setAnterior(aux);
		}
	}

	public void removerClienteInicio() {
		if (this.inicio == null) {
			JOptionPane.showMessageDialog(null, "N�o h� clientes para excluir, a lista est� vazia!", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			this.inicio = this.inicio.getProximo();
			if (this.inicio != null) {
				this.inicio.setAnterior(null);
			}
		}
	}

	public void removerClienteFinal() {
		if (this.inicio == null) {
			JOptionPane.showMessageDialog(null, "N�o h� clientes para excluir, a lista est� vazia!", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else if (this.inicio.getProximo() == null) {
			this.inicio = null;
		} else {
			ClienteNo aux = this.inicio;
			while (aux.getProximo() != null) {
				aux = aux.getProximo();
			}
			aux = aux.getAnterior();
			aux.setProximo(null);
		}
	}

	public void removerCliente(int posicao) {
		if (posicao == 1) {
			removerClienteInicio();
		} else if (posicao == tamanho() + 1) {
			removerClienteFinal();
		} else if (posicao <= tamanho() && posicao > 0) {
			ClienteNo aux = this.inicio;
			for (int i = 0; i < posicao - 1; i++) {
				aux = aux.getProximo();
			}
			ClienteNo aux2 = aux.getAnterior();
			aux = aux.getProximo();
			aux2.setProximo(aux);
			aux.setAnterior(aux2);
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao excluir cliente", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	public String mostraCliente() {
		String mostra;
		if (this.inicio == null) {
			mostra = "N�o h� clientes para mostrar, a lista est� vazia!";
		} else {
			StringBuffer buffer = new StringBuffer();
			ClienteNo aux = this.inicio;
			while (aux != null) {
				buffer.append("Codigo: " + aux.getCliente().getId() + " |Nome: " + aux.getCliente().getNome()
						+ " |Documento CPF: " + aux.getCliente().getDocumentoCPF() + " |Telefone: "
						+ aux.getCliente().getTelefone() + "\n");
				aux = aux.getProximo();
			}
			mostra = buffer.toString();
		}
		return mostra;
	}

	public int getIndex(int id) {
		ClienteNo aux = this.inicio;
		boolean existe = false;
		int pos = 1;

		if (id == aux.getCliente().getId()) {
			existe = true;
		}
		while (aux != null && id != aux.getCliente().getId()) {
			aux = aux.getProximo();
			if (id == aux.getCliente().getId()) {
				existe = true;
			}
			pos++;
		}
		if (existe) {
			return pos;
		} else {
			return 0;
		}
	}

	public Cliente getUltimoElemento() {
		ClienteNo aux = this.inicio;
		while (aux.getProximo() != null) {
			aux = aux.getProximo();
		}
		return aux.getCliente();
	}
	
	public Cliente getByName(String nome) {
		
		ClienteNo cliente = this.inicio;
		while (!cliente.getCliente().getNome().equals(nome)) {

			cliente = cliente.getProximo();
		}
		return cliente.getCliente();
	}

}
