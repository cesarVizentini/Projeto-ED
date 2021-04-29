package persistence;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ArquivosDiretorios;
import model.Festa;
import model.FestaNo;

public class FestaDao {
	private FestaNo inicio;

	public FestaDao() {
		this.inicio = null;
	}

	public int tamanho() {
		FestaNo aux = this.inicio;
		int cont = 0;
		if (aux != null) {
			while (aux.getProximo() != null) {
				aux = aux.getProximo();
				cont++;
			}
		}
		return cont;
	}

	public Festa getFesta(int festa) {
		FestaNo aux = this.inicio;
		for (int i = 0; i < festa; i++) {
			aux = aux.getProximo();
		}
		if (aux == null) {
			return null;
		}
		return aux.getFesta();
	}

	public void adicionarSalvarFesta(Festa festa) {
		FestaNo no = new FestaNo(festa);
		if (this.inicio == null) {
			this.inicio = no;
		} else {
			FestaNo aux = this.inicio;
			while (aux.getProximo() != null) {
				aux = aux.getProximo();
			}
			aux.setProximo(no);
			no.setAnterior(aux);
		}
		ArquivosDiretorios arquivosDiretorios = new ArquivosDiretorios();
		try {
			arquivosDiretorios.salvarFesta(festa);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void adicionarFesta(Festa festa) {
		FestaNo no = new FestaNo(festa);
		if (this.inicio == null) {
			this.inicio = no;
		} else {
			FestaNo aux = this.inicio;
			while (aux.getProximo() != null) {
				aux = aux.getProximo();
			}
			aux.setProximo(no);
			no.setAnterior(aux);
		}
	}

	public void removerFestaInicio() {
		if (this.inicio == null) {
			JOptionPane.showMessageDialog(null, "Não há festas para excluir, a lista está vazia!", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			this.inicio = this.inicio.getProximo();
			if (this.inicio != null) {
				this.inicio.setAnterior(null);
			}
		}
	}

	public void removerFestaFinal() {
		if (this.inicio == null) {
			JOptionPane.showMessageDialog(null, "Não há festas para excluir, a lista está vazia!", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else if (this.inicio.getProximo() == null) {
			this.inicio = null;
		} else {
			FestaNo aux = this.inicio;
			while (aux.getProximo() != null) {
				aux = aux.getProximo();
			}
			aux = aux.getAnterior();
			aux.setProximo(null);
		}
	}

	public void removerFesta(int posicao) {
		if (posicao == 1) {
			removerFestaInicio();
		} else if (posicao == tamanho() + 1) {
			removerFestaFinal();
		} else if (posicao <= tamanho() && posicao > 0) {
			FestaNo aux = this.inicio;
			for (int i = 0; i < posicao - 1; i++) {
				aux = aux.getProximo();
			}
			FestaNo aux2 = aux.getAnterior();
			aux = aux.getProximo();
			aux2.setProximo(aux);
			aux.setAnterior(aux2);
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao excluir festa", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void alterarFesta() {

	}

//	public boolean AtualizaDado(T dadoProcurado) {
//		boolean atualizou = false;
//		if (VerificaListaVazia()) {
//			return atualizou;
//		} else {
//			Node<T> aux;
//			aux = primeiro;
//			while (aux.getProximo() != null) {
//				if (aux.getDado().equals(dadoProcurado)) {
//					T novoDado = null;
//					aux.setDado(novoDado);
//					// atualizar no BD
//					atualizou = true;
//				}
//			}
//		}
//		return atualizou;
//	}

	public String mostraFesta() {
		String mostra;
		if (this.inicio == null) {
			mostra = "Não há festas para mostrar, a lista está vazia!";
		} else {
			StringBuffer buffer = new StringBuffer();
			FestaNo aux = this.inicio;
			while (aux != null) {
				buffer.append("Codigo: " + aux.getFesta().getId() + " |Tema: " + aux.getFesta().getTema()
						+ " |Cliente: " + aux.getFesta().getCliente() + " |Data da festa: "
						+ aux.getFesta().getDataFesta() + " |Horário de inicio: " + aux.getFesta().getDataFesta()
						+ " |Horário de término: " + aux.getFesta().getDataFesta() + " |Endereço: " + aux.getFesta().toString() + " |Valor Cobrado R$: "
						+ aux.getFesta().getValorCobrado() + "\n");
				aux = aux.getProximo();
			}
			mostra = buffer.toString();
		}
		return mostra;
	}

//	private FestaNo getFestaNo(int festaNo) {
//		FestaNo aux = this.inicio;
//		for (int i = 0; i < festaNo; i++) {
//			aux = aux.getProximo();
//		}
//		if (aux == null) {
//			return null;
//		}
//		return aux;
//	}

	public int getIndex(int id) {
		FestaNo aux = this.inicio;
		boolean existe = false;
		int pos = 1;

		if (id == aux.getFesta().getId()) {
			existe = true;
		}
		while (aux != null && id != aux.getFesta().getId()) {
			aux = aux.getProximo();
			if (id == aux.getFesta().getId()) {
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

	public Festa getUltimoElemento() {
		FestaNo aux = this.inicio;
		while (aux.getProximo() != null) {
			aux = aux.getProximo();
		}
		return aux.getFesta();
	}

}
