package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Cliente;
import model.ClienteTableModel;
import persistence.ClienteDao;
import view.cliente.TelaClientePrincipal;

public class ClienteController implements ActionListener {

	private JTextField tfNome;
	private JFormattedTextField jftfTelefone;
	private JFormattedTextField jftfDocumentoCPF;
	private ClienteDao lista;

	public ClienteController(JTextField tfNome, JFormattedTextField jftfTelefone,
			JFormattedTextField jftfDocumentoCPF) {
		this.tfNome = tfNome;
		this.jftfTelefone = jftfTelefone;
		this.jftfDocumentoCPF = jftfDocumentoCPF;

		lista = new ClienteDao();
		ArquivosDiretorios arquivosDiretorios = new ArquivosDiretorios();
		try {
			lista = arquivosDiretorios.getClientes(lista);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean valido = validaTela();
		if (valido) {
			String cmd = e.getActionCommand();
			if (cmd.equals("Cadastrar Cliente")) {
				boolean newTable = false;
				if (lista == null) {
					newTable = true;
				}
				cadastrar(tfNome.getText(), jftfDocumentoCPF.getText(), jftfTelefone.getText());
				if (newTable) {
					TelaClientePrincipal telaClientePrincipal = new TelaClientePrincipal();
					telaClientePrincipal.setVisible(true);
					telaClientePrincipal.dispose();
				}
				ClienteTableModel clienteTableModel = new ClienteTableModel(lista);
				clienteTableModel.addRow();

			}
		}
	}
	
	private boolean validaTela() {
		boolean valida = true;
		if (tfNome.getText().trim().equals("") || jftfTelefone.getText().trim().equals("")
				|| jftfDocumentoCPF.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos acima para realizar o cadastro", "Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		}
		return valida;
	}

	private void cadastrar(String nome, String documentoCPF, String telefone) {
		Cliente ultimo;
		int id = 0;
		if (lista != null) {
			ultimo = lista.getUltimoElemento();
			id = ultimo.getId() + 1;
		} else {
			id = 1;
			lista = new ClienteDao();
		}
		Cliente cliente = new Cliente(id, nome, documentoCPF, telefone);
		cliente.setNome(nome);
		cliente.setDocumentoCPF(documentoCPF);
		cliente.setTelefone(telefone);

		lista.adicionarSalvarCliente(cliente);

		tfNome.setText("");
		jftfTelefone.setText("");
		jftfDocumentoCPF.setText("");
	}
}
