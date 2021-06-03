package controller;

import java.io.IOException;

import model.Tema;
import persistence.TemaDao;

public class TemaController {

	private TemaDao lista;

	public TemaController() {
		lista = new TemaDao();
		ArquivosDiretorios arquivosDiretorios = new ArquivosDiretorios();
		try {
			lista = arquivosDiretorios.getTemas(lista);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void cadastrar(String nome, String descricao, double preco) {
		Tema ultimo;
		int id = 0;
		if (lista != null) {
			ultimo = lista.getUltimoElemento();
			id = ultimo.getId() + 1;
		} else {
			id = 1;
			lista = new TemaDao();
		}
		Tema tema = new Tema(id, nome, descricao, preco);
		tema.setNome(nome);
		tema.setDescricao(descricao);
		tema.setValor(preco);

		lista.adicionarSalvarTema(tema);
	}

}
