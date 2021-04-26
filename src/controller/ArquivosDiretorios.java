package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import model.Cliente;
import model.Tema;
import persistence.ClienteDao;
import persistence.TemaDao;

public class ArquivosDiretorios {

	public ArquivosDiretorios() {
	}

	public void verificaDiretorio() throws IOException {
		String path = "C:\\DatabaseBuffetRafaela";
		File diretorio = new File(path);
		if (!diretorio.exists() || !diretorio.isDirectory()) {
			if (diretorio.mkdir()) {
				System.out.println("O Diretório DatabaseBuffetRafaela foi criado com sucesso! Caminho para acessar => C:\\DatabaseBuffetRafaela\\");
			} else {
				System.err.println("Erro ao criar diretório");
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
					+ cliente.getTelefone() + "\n";
			FileWriter writer = new FileWriter(file, true);
			PrintWriter printer = new PrintWriter(writer);
			printer.write(salvar);
			printer.flush();
			printer.close();
			writer.close();
		} else {
			String salvar = "Id;Nome;Documento CPF;Telefone\n";
			salvar += cliente.getId() + ";" + cliente.getNome() + ";" + cliente.getDocumentoCPF() + ";"
					+ cliente.getTelefone() + "\n";
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
				cliente = new Cliente(Integer.parseInt(auxs[0]), auxs[1], auxs[2], auxs[3]);
				clienteDao.adicionarCliente(cliente);
				line = reader.readLine();
			}
			reader.close();
			flow.close();
			stream.close();
			return clienteDao;
		} else {
			System.err.println("Não existem cadastros!");
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
				String salvar = "Id;Nome;Documento CPF;Telefone\n";
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
			System.out.println("Cliente não foi encontrado na base de dados");
		}
	}

	public void atualizarCliente(ClienteDao clienteDao) throws IOException {
		verificaDiretorio();
		String path = "C:\\DatabaseBuffetRafaela\\cliente.csv";
		File file = new File(path);
		String salvar = "Id;Nome;Documento CPF;Telefone\n";
		salvar += prepararCliente(clienteDao);
		FileWriter writer = new FileWriter(file);
		PrintWriter printer = new PrintWriter(writer);
		printer.write(salvar);
		printer.flush();
		printer.close();
		writer.close();
	}

	private String prepararCliente(ClienteDao clienteDao) {
		StringBuffer buffer = new StringBuffer();
		String preparo;
		int posicao = 0;
		Cliente cliente = clienteDao.getCliente(posicao);
		do {
			buffer.append(cliente.getId() + ";" + cliente.getNome() + ";" + cliente.getDocumentoCPF() + ";"
					+ cliente.getTelefone());
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
			String salvar = tema.getId() + ";" + tema.getNome() + ";" + tema.getDescricao() + ";"
					+ tema.getValor() + "\n";
			FileWriter writer = new FileWriter(file, true);
			PrintWriter printer = new PrintWriter(writer);
			printer.write(salvar);
			printer.flush();
			printer.close();
			writer.close();
		} else {
			String salvar = "Id;Nome;Descrição;Valor Aluguel (R$)\n";
			salvar += tema.getId() + ";" + tema.getNome() + ";" + tema.getDescricao() + ";"
					+ tema.getValor() + "\n";
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
			System.err.println("Não existem cadastros!");
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
				String salvar = "Id;Nome;Descrição;Valor Aluguel (R$)\n";
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
			System.out.println("Tema não foi encontrado na base de dados");
		}
	}

	public void atualizarTema(TemaDao temaDao) throws IOException {
		verificaDiretorio();
		String path = "C:\\DatabaseBuffetRafaela\\tema.csv";
		File file = new File(path);
		String salvar = "Id;Nome;Descrição;Valor Aluguel (R$)\n";
		salvar += prepararTema(temaDao);
		FileWriter writer = new FileWriter(file);
		PrintWriter printer = new PrintWriter(writer);
		printer.write(salvar);
		printer.flush();
		printer.close();
		writer.close();
	}

	private String prepararTema(TemaDao temaDao) {
		StringBuffer buffer = new StringBuffer();
		String preparo;
		int posicao = 0;
		Tema tema = temaDao.getTema(posicao);
		do {
			buffer.append(tema.getId() + ";" + tema.getNome() + ";" + tema.getDescricao() + ";"
					+ tema.getValor());
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

	// --------------------------------------------------
	// ---------------- END FESTA DATABASE --------------
	// --------------------------------------------------

	// --------------------------------------------------
	// ---------------- FINANCAS DATABASE ---------------
	// --------------------------------------------------

	// -----------------------------------------------------
	// ---------------- END FINANCAS DATABASE --------------
	// -----------------------------------------------------

}
