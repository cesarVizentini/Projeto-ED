package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import model.Festa;
import model.FestaTableModel;
import persistence.FestaDao;
import view.festa.TelaFestaPrincipal;

public class FestaController implements ActionListener {

	private JComboBox<Object> cbTema;
	private JComboBox<Object> cbCliente;
	private JDateChooser dcData;
	private JTextField tfHorarioInicial;
	private JTextField tfHorarioFinal;
	private JComboBox<String> cbLogradouro;
	private JTextField tfNomeOficial;
	private JTextField tfNumero;
	private JTextField tfComplemento;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JComboBox<String> cbUF;
	private JTextField tfCEP;
	private JTextField tfValorCobrado;
	private FestaDao lista;
	private String endereco;

	public FestaController(JComboBox<Object> cbTema, JComboBox<Object> cbCliente, JDateChooser dcData,
			JTextField tfHorarioInicial, JTextField tfHorarioFinal, JComboBox<String> cbLogradouro,
			JTextField tfNomeOficial, JTextField tfNumero, JTextField tfComplemento, JTextField tfBairro,
			JTextField tfCidade, JComboBox<String> cbUF, JTextField tfCEP, JTextField tfValorCobrado) {
		this.cbTema = cbTema;
		this.cbCliente = cbCliente;
		this.dcData = dcData;
		this.tfHorarioInicial = tfHorarioInicial;
		this.tfHorarioFinal = tfHorarioFinal;
		this.cbLogradouro = cbLogradouro;
		this.tfNomeOficial = tfNomeOficial;
		this.tfNumero = tfNumero;
		this.tfComplemento = tfComplemento;
		this.tfBairro = tfComplemento;
		this.tfCidade = tfCidade;
		this.cbUF = cbUF;
		this.tfCEP = tfCEP;
		this.tfValorCobrado = tfValorCobrado;

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
				cadastrar(cbTema.getSelectedItem().toString(), cbCliente.getSelectedItem().toString(),
						dcData.getDate().toString(), tfHorarioInicial.getText(), tfHorarioFinal.getText(),
						cbLogradouro.getSelectedItem().toString(), tfNomeOficial.getText(), tfNumero.getText(),
						tfComplemento.getText(), tfBairro.getText(), tfCidade.getText(),
						cbUF.getSelectedItem().toString(), tfCEP.getText(),
						Double.parseDouble(tfValorCobrado.getText()));
				if (newTable) {
					TelaFestaPrincipal telaFestaPrincipal = new TelaFestaPrincipal();
					telaFestaPrincipal.setVisible(true);
					telaFestaPrincipal.dispose();
				}
				FestaTableModel festaTableModel = new FestaTableModel(lista);
				festaTableModel.addRow();
			}
		}
	}

	private boolean validaTela() {
		boolean valida = true;
		if (cbTema.getSelectedItem().toString().trim().equals("") || cbCliente.getSelectedItem().toString().trim().equals("")
				|| dcData.getDate().toString().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos acima para realizar o cadastro",
					"Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		}
		return valida;
	}

	private void cadastrar(String tema, String cliente, String dataFesta, String horarioInicio, String horarioFinal,
			String cbLogradouro, String tfNomeOficial, String tfNumero, String tfComplemento, String tfBairro, String tfCidade, String cbUF,
			String tfCEP, double valorCobrado) {
		Festa ultimo;
		int id = 0;
		if (lista != null) {
			ultimo = lista.getUltimoElemento();
			id = ultimo.getId() + 1;
		} else {
			id = 1;
			lista = new FestaDao();
		}
		Festa festa = new Festa(id, tema, cliente, dataFesta, horarioInicio, horarioFinal, endereco , valorCobrado);
		festa.setTema(tema);
		festa.setCliente(cliente);
		festa.setDataFesta(dataFesta);
		festa.setHorarioInicio(horarioInicio);
		festa.setHorarioFinal(horarioFinal);
		festa.toString();
		festa.setValorCobrado(valorCobrado);
	
		lista.adicionarSalvarFesta(festa);

		tfHorarioInicial.setText("");
		tfHorarioFinal.setText("");
		tfValorCobrado.setText("");
	}

}
