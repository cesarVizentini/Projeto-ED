package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.Tema;
import model.TemaTableModel;
import persistence.TemaDao;
import view.tema.TelaTemaPrincipal;

public class TemaController implements ActionListener {

	private JTextField tfNome;
	private JTextArea taDescricao;
	private JFormattedTextField jftfPreco;
	private TemaDao lista;

	public TemaController(JTextField tfNome, JTextArea taDescricao, JFormattedTextField jftfPreco) {
		this.tfNome = tfNome;
		this.taDescricao = taDescricao;
		this.jftfPreco = jftfPreco;

		lista = new TemaDao();
		ArquivosDiretorios arquivosDiretorios = new ArquivosDiretorios();
		try {
			lista = arquivosDiretorios.getTemas(lista);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean valido = validaTela();
		if (valido) {
			String cmd = e.getActionCommand();
			if (cmd.equals("Cadastrar Tema")) {
				boolean newTable = false;
				if (lista == null) {
					newTable = true;
				}
				cadastrar(tfNome.getText(), taDescricao.getText(), Double.parseDouble(jftfPreco.getText()));
				if (newTable) {
					TelaTemaPrincipal telaTemaPrincipal = new TelaTemaPrincipal();
					telaTemaPrincipal.setVisible(true);
					telaTemaPrincipal.dispose();
				}
				TemaTableModel temaTableModel = new TemaTableModel(lista);
				temaTableModel.addRow();
				TelaTemaPrincipal telaTemaPrincipal = new TelaTemaPrincipal();
				telaTemaPrincipal.setVisible(true);
				telaTemaPrincipal.dispose();
			}
		}
	}

	private boolean validaTela() {
		boolean valida = true;
		if (tfNome.getText().trim().equals("") && taDescricao.getText().trim().equals("")
				&& jftfPreco.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos acima para realizar o cadastro", "Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (tfNome.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha o nome do tema para realizar o cadastro", "Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (taDescricao.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha a descrição do tema para realizar o cadastro", "Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (jftfPreco.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha o preço do tema para realizar o cadastro", "Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		}
		return valida;
	}

	private void cadastrar(String nome, String descricao, double preco) {
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
//		try {
//			tema.setValor(preco);
//		} catch (NumberFormatException e) {
//			JOptionPane.showMessageDialog(null, "O valor do tema deve ser númerico com duas casas decimais", "ERRO",
//					JOptionPane.ERROR_MESSAGE);
//		}

		lista.adicionarSalvarTema(tema);

		tfNome.setText("");
		taDescricao.setText("");
		jftfPreco.setText("");
	}

}
