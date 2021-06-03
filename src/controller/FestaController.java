package controller;

import java.io.IOException;
import java.text.ParseException;

import model.Endereco;
import model.Festa;
import persistence.FestaDao;

public class FestaController {
	
	private FestaDao lista;

	public FestaController() {
		lista = new FestaDao();
		ArquivosDiretorios arquivosDiretorios = new ArquivosDiretorios();
		try {
			lista = arquivosDiretorios.getFestas(lista);
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void cadastrar(String tema, String cliente, String dataFesta, String horarioInicio, String horarioFinal,
			String cbLogradouro, String tfNomeOficial, String tfNumero, String tfComplemento, String tfBairro,
			String tfCidade, String cbUF, String tfCEP, double valorCobrado) {
		Festa ultimo;
		int id = 0;
		if (lista != null) {
			ultimo = lista.getUltimoElemento();
			id = ultimo.getId() + 1;
		} else {
			id = 1;
			lista = new FestaDao();
		}
		Endereco endereco = new Endereco(cbLogradouro, tfNomeOficial, tfNumero, tfComplemento, tfBairro, tfCidade, cbUF,
				tfCEP);
		endereco.setLogradouro(cbLogradouro);
		endereco.setNomeOficial(tfNomeOficial);
		endereco.setNumero(tfNumero);
		endereco.setComplemento(tfComplemento);
		endereco.setBairro(tfBairro);
		endereco.setCidade(tfCidade);
		endereco.setUf(cbUF);
		endereco.setCep(tfCEP);
		Festa festa = new Festa(id, tema, cliente, dataFesta, horarioInicio, horarioFinal, endereco.toString(),
				valorCobrado);
		festa.setTema(tema);
		festa.setCliente(cliente);
		festa.setDataFesta(dataFesta);
		festa.setHorarioInicio(horarioInicio);
		festa.setHorarioFinal(horarioFinal);
		festa.setEndereco(endereco.toString());
		festa.setValorCobrado(valorCobrado);

		lista.adicionarSalvarFesta(festa);
	}

}
