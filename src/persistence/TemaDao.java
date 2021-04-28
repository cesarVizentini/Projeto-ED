package persistence;

import java.io.IOException;
import javax.swing.JOptionPane;
import controller.ArquivosDiretorios;
import model.Tema;
import model.TemaNo;

public class TemaDao {
	private TemaNo inicio;

	public TemaDao() {
		this.inicio = null;
	}

	public int tamanho() {
		TemaNo aux = this.inicio;
		int cont = 0;
		if (aux != null) {
			while (aux.getProximo() != null) {
				aux = aux.getProximo();
				cont++;
			}
		}
		return cont;
	}

	public Tema getTema(int tema) {
		TemaNo aux = this.inicio;
		for (int i = 0; i < tema; i++) {
			aux = aux.getProximo();
		}
		if (aux == null) {
			return null;
		}
		return aux.getTema();
	}

	public void adicionarSalvarTema(Tema tema) {
		TemaNo no = new TemaNo(tema);
		if (this.inicio == null) {
			this.inicio = no;
		} else {
			TemaNo aux = this.inicio;
			while (aux.getProximo() != null) {
				aux = aux.getProximo();
			}
			aux.setProximo(no);
			no.setAnterior(aux);
		}
		ArquivosDiretorios arquivosDiretorios = new ArquivosDiretorios();
		try {
			arquivosDiretorios.salvarTema(tema);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void adicionarTema(Tema tema) {
		TemaNo no = new TemaNo(tema);
		if (this.inicio == null) {
			this.inicio = no;
		} else {
			TemaNo aux = this.inicio;
			while (aux.getProximo() != null) {
				aux = aux.getProximo();
			}
			aux.setProximo(no);
			no.setAnterior(aux);
		}
	}

	public void removerTemaInicio() {
		if (this.inicio == null) {
			JOptionPane.showMessageDialog(null, "N�o h� temas para excluir, a lista est� vazia!", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			this.inicio = this.inicio.getProximo();
			if (this.inicio != null) {
				this.inicio.setAnterior(null);
			}
		}
	}

	public void removerTemaFinal() {
		if (this.inicio == null) {
			JOptionPane.showMessageDialog(null, "N�o h� temas para excluir, a lista est� vazia!", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else if (this.inicio.getProximo() == null) {
			this.inicio = null;
		} else {
			TemaNo aux = this.inicio;
			while (aux.getProximo() != null) {
				aux = aux.getProximo();
			}
			aux = aux.getAnterior();
			aux.setProximo(null);
		}
	}

	public void removerTema(int posicao) {
		if (posicao == 1) {
			removerTemaInicio();
		} else if (posicao == tamanho() + 1) {
			removerTemaFinal();
		} else if (posicao <= tamanho() && posicao > 0) {
			TemaNo aux = this.inicio;
			for (int i = 0; i < posicao - 1; i++) {
				aux = aux.getProximo();
			}
			TemaNo aux2 = aux.getAnterior();
			aux = aux.getProximo();
			aux2.setProximo(aux);
			aux.setAnterior(aux2);
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao excluir tema", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void alterarTema() {

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

	public String mostraTema() {
		String mostra;
		if (this.inicio == null) {
			mostra = "N�o h� temas para mostrar, a lista est� vazia!";
		} else {
			StringBuffer buffer = new StringBuffer();
			TemaNo aux = this.inicio;
			while (aux != null) {
				buffer.append("Codigo: " + aux.getTema().getId() + " |Nome: " + aux.getTema().getNome()
						+ " |Descri��o: " + aux.getTema().getDescricao() + " |Valor Aluguel R$: "
						+ aux.getTema().getValor() + "\n");
				aux = aux.getProximo();
			}
			mostra = buffer.toString();
		}
		return mostra;
	}

//	private TemaNo getTemaNo(int temaNo) {
//		TemaNo aux = this.inicio;
//		for (int i = 0; i < temaNo; i++) {
//			aux = aux.getProximo();
//		}
//		if (aux == null) {
//			return null;
//		}
//		return aux;
//	}

	public int getIndex(int id) {
		TemaNo aux = this.inicio;
		boolean existe = false;
		int pos = 1;

		if (id == aux.getTema().getId()) {
			existe = true;
		}
		while (aux != null && id != aux.getTema().getId()) {
			aux = aux.getProximo();
			if (id == aux.getTema().getId()) {
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

	public Tema getUltimoElemento() {
		TemaNo aux = this.inicio;
		while (aux.getProximo() != null) {
			aux = aux.getProximo();
		}
		return aux.getTema();
	}

}
