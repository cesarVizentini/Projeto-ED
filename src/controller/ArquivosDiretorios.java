package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import model.Cliente;
import model.Festa;
import model.Tema;
import persistence.ClienteDao;
import persistence.FestaDao;
import persistence.TemaDao;

public class ArquivosDiretorios {

	public ArquivosDiretorios() {
	}

	public void verificaDiretorio() throws IOException {
		String path = "C:\\DatabaseBuffetRafaela";
		File diretorio = new File(path);
		if (!diretorio.exists() || !diretorio.isDirectory()) {
			if (diretorio.mkdir()) {
				System.out.println(
						"O Diretorio DatabaseBuffetRafaela foi criado com sucesso! Caminho para acessar => C:\\DatabaseBuffetRafaela\\");
			} else {
				System.err.println("Erro ao criar diretorio");
			}
		}
	}

	public boolean verificarSeExistemDados(String database) throws IOException {
		String path = "C:\\DatabaseBuffetRafaela\\" + database + ".csv";
		File file = new File(path);
		return file.exists();
	}

	// ---------------------------------------------
	// -------------- CLIENTE DATABASE -------------
	// ---------------------------------------------
	public void salvarCliente(Cliente cliente) throws IOException {
		verificaDiretorio();
		String path = "C:\\DatabaseBuffetRafaela\\cliente.csv";
		File file = new File(path);
		if (verificarSeExistemDados("cliente")) {
			String salvar = cliente.getId() + ";" + cliente.getNome() + ";" + cliente.getDocumentoCPF() + ";"
					+ cliente.getTelefone() + ";" + cliente.getFestasAlugadas() + "\n";
			FileWriter writer = new FileWriter(file, true);
			PrintWriter printer = new PrintWriter(writer);
			printer.write(salvar);
			printer.flush();
			printer.close();
			writer.close();
		} else {
			String salvar = "Id;Nome;Documento CPF;Telefone;Sequencia de festas alugadas\n";
			salvar += cliente.getId() + ";" + cliente.getNome() + ";" + cliente.getDocumentoCPF() + ";"
					+ cliente.getTelefone() + ";" + cliente.getFestasAlugadas() + "\n";
			FileWriter writer = new FileWriter(file);
			PrintWriter printer = new PrintWriter(writer);
			printer.write(salvar);
			printer.flush();
			printer.close();
			writer.close();
		}
		System.out.println("Cliente salvo com sucesso!");
	}

	public ClienteDao getClientes(ClienteDao clienteDao) throws IOException {
		verificaDiretorio();
		Cliente cliente;
		String path = "C:\\DatabaseBuffetRafaela\\cliente.csv";
		File file = new File(path);
		if (verificarSeExistemDados("cliente")) {
			FileInputStream stream = new FileInputStream(file);
			InputStreamReader flow = new InputStreamReader(stream);
			BufferedReader reader = new BufferedReader(flow);
			String line = reader.readLine();
			line = reader.readLine();
			while (line != null) {
				String[] auxs = line.split(";");
				cliente = new Cliente(Integer.parseInt(auxs[0]), auxs[1], auxs[2], auxs[3], Integer.parseInt(auxs[4]));
				clienteDao.adicionarCliente(cliente);
				line = reader.readLine();
			}
			reader.close();
			flow.close();
			stream.close();
			return clienteDao;
		} else {
			System.err.println("Nao existem cadastros!");
			return null;
		}
	}

	public void removerCliente(ClienteDao clienteDao, int id) throws IOException {
		int indexCliente = clienteDao.getIndex(id);
		if (indexCliente != 0) {
			verificaDiretorio();
			String path = "C:\\DatabaseBuffetRafaela\\cliente.csv";
			File file = new File(path);
			clienteDao.removerCliente(indexCliente);
			if (clienteDao.getCliente(0) == null) {
				file.delete();
			} else {
				String salvar = "Id;Nome;Documento CPF;Telefone;Sequencia de festas alugadas\n";
				salvar += prepararCliente(clienteDao);
				FileWriter writer = new FileWriter(file);
				PrintWriter printer = new PrintWriter(writer);
				printer.write(salvar);
				printer.flush();
				printer.close();
				writer.close();
			}
			System.out.println("Cliente removido com sucesso!");
		} else {
			System.out.println("Cliente nao foi encontrado na base de dados");
		}
	}

	public void atualizarCliente(ClienteDao clienteDao, Cliente clienteAtt, int id) throws IOException {
		verificaDiretorio();
		String path = "C:\\DatabaseBuffetRafaela\\cliente.csv";
		File file = new File(path);
		String salvar = "Id;Nome;Documento CPF;Telefone;Sequencia de festas alugadas\n";
		salvar += prepararAttClienteAntes(clienteDao, id);
		salvar += clienteAtt.getId() + ";" + clienteAtt.getNome() + ";" + clienteAtt.getDocumentoCPF() + ";"
				+ clienteAtt.getTelefone() + ";" + clienteAtt.getFestasAlugadas() + "\n";
		salvar += prepararAttClienteDepois(clienteDao, id);
		FileWriter writer = new FileWriter(file);
		PrintWriter printer = new PrintWriter(writer);
		printer.write(salvar);
		printer.flush();
		printer.close();
		writer.close();
	}

	private String prepararAttClienteAntes(ClienteDao clienteDao, int id) {
		StringBuffer buffer = new StringBuffer();
		String preparo = "";
		int posicao = 0;
		Cliente cliente = clienteDao.getCliente(posicao);
		if (id > 1) {
			do {
				buffer.append(cliente.getId() + ";" + cliente.getNome() + ";" + cliente.getDocumentoCPF() + ";"
						+ cliente.getTelefone() + ";" + cliente.getFestasAlugadas());
				buffer.append("\n");
				posicao++;
				cliente = clienteDao.getCliente(posicao);
			} while (posicao <= id - 2);
			preparo = buffer.toString();
		}
		return preparo;
	}

	private String prepararAttClienteDepois(ClienteDao clienteDao, int id) {
		StringBuffer buffer = new StringBuffer();
		String preparo;
		int posicao = id;
		Cliente cliente = clienteDao.getCliente(posicao);
		if (cliente != null) {
			do {
				buffer.append(cliente.getId() + ";" + cliente.getNome() + ";" + cliente.getDocumentoCPF() + ";"
						+ cliente.getTelefone() + ";" + cliente.getFestasAlugadas());
				buffer.append("\n");
				posicao++;
				cliente = clienteDao.getCliente(posicao);
			} while (cliente != null);
		}
		preparo = buffer.toString();
		return preparo;
	}

	private String prepararCliente(ClienteDao clienteDao) {
		StringBuffer buffer = new StringBuffer();
		String preparo;
		int posicao = 0;
		Cliente cliente = clienteDao.getCliente(posicao);
		do {
			buffer.append(cliente.getId() + ";" + cliente.getNome() + ";" + cliente.getDocumentoCPF() + ";"
					+ cliente.getTelefone() + ";" + cliente.getFestasAlugadas());
			buffer.append("\n");
			posicao++;
			cliente = clienteDao.getCliente(posicao);
		} while (cliente != null);
		preparo = buffer.toString();
		return preparo;
	}

	// -------------------------------------------------
	// -------------- END CLIENTE DATABASE -------------
	// -------------------------------------------------

	// ----------------------------------------------
	// ---------------- TEMA DATABASE ---------------
	// ----------------------------------------------

	public void salvarTema(Tema tema) throws IOException {
		verificaDiretorio();
		String path = "C:\\DatabaseBuffetRafaela\\tema.csv";
		File file = new File(path);
		if (verificarSeExistemDados("tema")) {
			String salvar = tema.getId() + ";" + tema.getNome() + ";" + tema.getDescricao() + ";" + tema.getValor()
					+ "\n";
			FileWriter writer = new FileWriter(file, true);
			PrintWriter printer = new PrintWriter(writer);
			printer.write(salvar);
			printer.flush();
			printer.close();
			writer.close();
		} else {
			String salvar = "Id;Nome;Descricao;Valor Aluguel (R$)\n";
			salvar += tema.getId() + ";" + tema.getNome() + ";" + tema.getDescricao() + ";" + tema.getValor() + "\n";
			FileWriter writer = new FileWriter(file);
			PrintWriter printer = new PrintWriter(writer);
			printer.write(salvar);
			printer.flush();
			printer.close();
			writer.close();
		}
		System.out.println("Tema salvo com sucesso!");
	}

	public TemaDao getTemas(TemaDao temaDao) throws IOException {
		verificaDiretorio();
		Tema tema;
		String path = "C:\\DatabaseBuffetRafaela\\tema.csv";
		File file = new File(path);
		if (verificarSeExistemDados("tema")) {
			FileInputStream stream = new FileInputStream(file);
			InputStreamReader flow = new InputStreamReader(stream);
			BufferedReader reader = new BufferedReader(flow);
			String line = reader.readLine();
			line = reader.readLine();
			while (line != null) {
				String[] auxs = line.split(";");
				tema = new Tema(Integer.parseInt(auxs[0]), auxs[1], auxs[2], Double.parseDouble(auxs[3]));
				temaDao.adicionarTema(tema);
				line = reader.readLine();
			}
			reader.close();
			flow.close();
			stream.close();
			return temaDao;
		} else {
			System.err.println("Nao existem cadastros!");
			return null;
		}
	}

	public void removerTema(TemaDao temaDao, int id) throws IOException {
		int indexTema = temaDao.getIndex(id);
		if (indexTema != 0) {
			verificaDiretorio();
			String path = "C:\\DatabaseBuffetRafaela\\tema.csv";
			File file = new File(path);
			temaDao.removerTema(indexTema);
			if (temaDao.getTema(0) == null) {
				file.delete();
			} else {
				String salvar = "Id;Nome;Descriï¿½ï¿½o;Valor Aluguel (R$)\n";
				salvar += prepararTema(temaDao);
				FileWriter writer = new FileWriter(file);
				PrintWriter printer = new PrintWriter(writer);
				printer.write(salvar);
				printer.flush();
				printer.close();
				writer.close();
			}
			System.out.println("Tema removido com sucesso!");
		} else {
			System.out.println("Tema nao foi encontrado na base de dados");
		}
	}

	public void atualizarTema(TemaDao temaDao, Tema temaAtt, int id) throws IOException {
		verificaDiretorio();
		String path = "C:\\DatabaseBuffetRafaela\\tema.csv";
		File file = new File(path);
		String salvar = "Id;Nome;Documento CPF;Telefone\n";
		salvar += prepararAttTemaAntes(temaDao, id);
		salvar += temaAtt.getId() + ";" + temaAtt.getNome() + ";" + temaAtt.getDescricao() + ";" + temaAtt.getValor()
				+ "\n";
		salvar += prepararAttTemaDepois(temaDao, id);
		FileWriter writer = new FileWriter(file);
		PrintWriter printer = new PrintWriter(writer);
		printer.write(salvar);
		printer.flush();
		printer.close();
		writer.close();
	}

	private String prepararAttTemaAntes(TemaDao temaDao, int id) {
		StringBuffer buffer = new StringBuffer();
		String preparo = "";
		int posicao = 0;
		Tema temaAtt = temaDao.getTema(posicao);
		if (id > 1) {
			do {
				buffer.append(temaAtt.getId() + ";" + temaAtt.getNome() + ";" + temaAtt.getDescricao() + ";"
						+ temaAtt.getValor());
				buffer.append("\n");
				posicao++;
				temaAtt = temaDao.getTema(posicao);
			} while (posicao <= id - 2);
			preparo = buffer.toString();
		}
		return preparo;
	}

	private String prepararAttTemaDepois(TemaDao temaDao, int id) {
		StringBuffer buffer = new StringBuffer();
		String preparo;
		int posicao = id;
		Tema temaAtt = temaDao.getTema(posicao);
		if (temaAtt != null) {
			do {
				buffer.append(temaAtt.getId() + ";" + temaAtt.getNome() + ";" + temaAtt.getDescricao() + ";"
						+ temaAtt.getValor());
				buffer.append("\n");
				posicao++;
				temaAtt = temaDao.getTema(posicao);
			} while (temaAtt != null);
		}
		preparo = buffer.toString();
		return preparo;
	}

	private String prepararTema(TemaDao temaDao) {
		StringBuffer buffer = new StringBuffer();
		String preparo;
		int posicao = 0;
		Tema tema = temaDao.getTema(posicao);
		do {
			buffer.append(tema.getId() + ";" + tema.getNome() + ";" + tema.getDescricao() + ";" + tema.getValor());
			buffer.append("\n");
			posicao++;
			tema = temaDao.getTema(posicao);
		} while (tema != null);
		preparo = buffer.toString();
		return preparo;
	}

	// --------------------------------------------------
	// ---------------- END TEMA DATABASE ---------------
	// --------------------------------------------------

	// ----------------------------------------------
	// ---------------- FESTA DATABASE ---------------
	// ----------------------------------------------
	public void salvarFesta(Festa festa) throws IOException {
		verificaDiretorio();
		String path = "C:\\DatabaseBuffetRafaela\\festa.csv";
		File file = new File(path);
		if (verificarSeExistemDados("festa")) {
			String salvar = festa.getId() + ";" + festa.getTema() + ";" + festa.getCliente() + ";"
					+ festa.getDataFesta() + ";" + festa.getHorarioInicio() + ";" + festa.getHorarioFinal() + ";"
					+ festa.getEndereco().toString() + ";" + festa.getValorCobrado() + "\n";
			
			FileWriter writer = new FileWriter(file, true);
			PrintWriter printer = new PrintWriter(writer);
			printer.write(salvar);
			printer.flush();
			printer.close();
			writer.close();
		} else {
			String salvar = "Id;Tema;Cliente;Data;Horário de início;Horário de término;Endereço;Valor Total (R$)\n";
			salvar += festa.getId() + ";" + festa.getTema() + ";" + festa.getCliente() + ";" + festa.getDataFesta()
					+ ";" + festa.getHorarioInicio() + ";" + festa.getHorarioFinal() + ";"
					+ festa.getEndereco().toString() + ";" + festa.getValorCobrado() + "\n";
			FileWriter writer = new FileWriter(file);
			PrintWriter printer = new PrintWriter(writer);
			printer.write(salvar);
			printer.flush();
			printer.close();
			writer.close();
		}
		System.out.println("Festa salva com sucesso!");
	}

	public FestaDao getFestas(FestaDao festaDao) throws IOException, ParseException {
		verificaDiretorio();
		Festa festa;
		String path = "C:\\DatabaseBuffetRafaela\\festa.csv";
		File file = new File(path);
		if (verificarSeExistemDados("festa")) {
			FileInputStream stream = new FileInputStream(file);
			InputStreamReader flow = new InputStreamReader(stream);
			BufferedReader reader = new BufferedReader(flow);
			String line = reader.readLine();
			line = reader.readLine();
			while (line != null) {
				String[] auxs = line.split(";");
				festa = new Festa(Integer.parseInt(auxs[0]), auxs[1], auxs[2], auxs[3], auxs[4], auxs[5], auxs[6],
						Double.parseDouble(auxs[7]));
				festaDao.adicionarFesta(festa);
				line = reader.readLine();
			}
			reader.close();
			flow.close();
			stream.close();
			return festaDao;
		} else {
			System.err.println("Não existem cadastros!");
			return null;
		}
	}

	public void removerFesta(FestaDao festaDao, int id) throws IOException {
		int indexFesta = festaDao.getIndex(id);
		if (indexFesta != 0) {
			verificaDiretorio();
			String path = "C:\\DatabaseBuffetRafaela\\festa.csv";
			File file = new File(path);
			festaDao.removerFesta(indexFesta);
			if (festaDao.getFesta(0) == null) {
				file.delete();
			} else {
				String salvar = "Id;Tema;Cliente;Data;Horário de início;Horário de término;Endereço;Valor Total (R$)\n";
				salvar += prepararFesta(festaDao);
				FileWriter writer = new FileWriter(file);
				PrintWriter printer = new PrintWriter(writer);
				printer.write(salvar);
				printer.flush();
				printer.close();
				writer.close();
			}
			System.out.println("Festa removida com sucesso!");
		} else {
			System.out.println("Festa não foi encontrada na base de dados");
		}
	}

	public void atualizarFesta(FestaDao festaDao, Festa festa, int id) throws IOException {
		verificaDiretorio();
		String path = "C:\\DatabaseBuffetRafaela\\festa.csv";
		File file = new File(path);
		String salvar = "Id;Tema;Cliente;Data;Horário de início;Horário de término;Endereço;Valor Total (R$)\n";
		salvar += prepararAttFestaAntes(festaDao, id);
		salvar += id + ";" + festa.getTema() + ";" + festa.getCliente() + ";" + festa.getDataFesta() + ";"
				+ festa.getHorarioInicio() + ";" + festa.getHorarioFinal() + ";" + festa.getEndereco() + ";"
				+ festa.getValorCobrado() + "\n";
		salvar += prepararAttFestaDepois(festaDao, id);
		FileWriter writer = new FileWriter(file);
		PrintWriter printer = new PrintWriter(writer);
		printer.write(salvar);
		printer.flush();
		printer.close();
		writer.close();
	}

	private String prepararAttFestaAntes(FestaDao festaDao, int id) {
		StringBuffer buffer = new StringBuffer();
		String preparo = "";
		int posicao = 0;
		Festa festa = festaDao.getFesta(posicao);
		if (id > 1) {
			do {
				buffer.append(festa.getId() + festa.getTema() + ";" + festa.getCliente() + ";" + festa.getDataFesta()
						+ festa.getHorarioInicio() + ";" + festa.getHorarioFinal() + ";" + festa.getEndereco() + ";"
						+ festa.getValorCobrado());
				buffer.append("\n");
				posicao++;
				festa = festaDao.getFesta(posicao);
			} while (posicao <= id - 2);
			preparo = buffer.toString();
		}
		return preparo;
	}

	private String prepararAttFestaDepois(FestaDao festaDao, int id) {
		StringBuffer buffer = new StringBuffer();
		String preparo;
		int posicao = id;
		Festa festa = festaDao.getFesta(posicao);
		if (festa != null) {
			do {
				buffer.append(festa.getId() + festa.getTema() + ";" + festa.getCliente() + ";" + festa.getDataFesta()
						+ festa.getHorarioInicio() + ";" + festa.getHorarioFinal() + ";" + festa.getEndereco() + ";"
						+ festa.getValorCobrado());
				buffer.append("\n");
				posicao++;
				festa = festaDao.getFesta(posicao);
			} while (festa != null);
		}
		preparo = buffer.toString();
		return preparo;
	}

	private String prepararFesta(FestaDao festaDao) {
		StringBuffer buffer = new StringBuffer();
		String preparo;
		int posicao = 0;
		Festa festa = festaDao.getFesta(posicao);
		do {
			buffer.append(festa.getId() + ";" + festa.getTema() + ";" + festa.getCliente() + ";" + festa.getDataFesta()
					+ ";" + festa.getHorarioInicio() + ";" + festa.getHorarioFinal() + ";"
					+ festa.getEndereco().toString() + ";" + festa.getValorCobrado());
			buffer.append("\n");
			posicao++;
			festa = festaDao.getFesta(posicao);
		} while (festa != null);
		preparo = buffer.toString();
		return preparo;
	}
	// --------------------------------------------------
	// ---------------- END FESTA DATABASE --------------
	// --------------------------------------------------
}