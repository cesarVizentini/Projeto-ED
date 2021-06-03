package controller;

import java.io.IOException;
import java.text.ParseException;

import model.Cliente;
import model.Endereco;
import model.Festa;
import model.Tema;
import persistence.ClienteDao;
import persistence.FestaDao;
import persistence.TemaDao;

public class FestaController {

	private FestaDao lista;
	private ClienteDao listaCliente;
	private TemaDao listaTema;

	public FestaController() {
		lista = new FestaDao();
		ArquivosDiretorios arquivosDiretorios = new ArquivosDiretorios();
		listaCliente = new ClienteDao();
		listaTema = new TemaDao();
		try {
			listaCliente = arquivosDiretorios.getClientes(listaCliente);
			lista = arquivosDiretorios.getFestas(lista);
			listaTema = arquivosDiretorios.getTemas(listaTema);
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
		atualizar(cliente);
	}

	public String calcularValor(String tema, String cliente) {

		Cliente clienteSel = listaCliente.getByName(cliente);
		Tema valorTema;
		Double valorCalculado = 0.0;
		valorTema = listaTema.getByName(tema);
		if (clienteSel.getFestasAlugadas() >= 4) {
			valorCalculado = valorTema.getValor() * 0.4;
		} else {
			valorCalculado = valorTema.getValor();
		}
		return Double.toString(valorCalculado);
	}

	public void atualizar(String cliente) {
		ArquivosDiretorios arquivosDiretorios = new ArquivosDiretorios();

		Cliente clienteAtt = listaCliente.getByName(cliente);
		clienteAtt.setFestasAlugadas(clienteAtt.getFestasAlugadas() + 1);
		try {
			arquivosDiretorios.atualizarCliente(listaCliente, clienteAtt, clienteAtt.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
