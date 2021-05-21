package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import model.Endereco;
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
		this.tfBairro = tfBairro;
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
			if (cmd.equals("Cadastrar Festa")) {
				boolean newTable = false;
				if (lista == null) {
					newTable = true;
				}
				cadastrar(cbTema.getSelectedItem().toString(), cbCliente.getSelectedItem().toString(),
						converterData(dcData.getDate()), tfHorarioInicial.getText(), tfHorarioFinal.getText(),
						cbLogradouro.getSelectedItem().toString(), tfNomeOficial.getText(), tfNumero.getText(),
						tfComplemento.getText(), tfBairro.getText(), tfCidade.getText(),
						cbUF.getSelectedItem().toString(), tfCEP.getText(),
						Double.parseDouble(tfValorCobrado.getText()));
				if (newTable) {
					TelaFestaPrincipal telaFestaPrincipal = new TelaFestaPrincipal();
					telaFestaPrincipal.setVisible(false);
					telaFestaPrincipal.dispose();
				} else {
					try {
						lista.sort();
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
				FestaTableModel festaTableModel = new FestaTableModel(lista);
				festaTableModel.addRow();
			}
		}
	}

	public String converterData(Date date) {
		Date in = date;
		String formato = "dd/MM/yyyy";
		SimpleDateFormat formatter = new SimpleDateFormat(formato);
	    return formatter.format(in);
	}

	private boolean validaTela() {
		boolean valida = true;
		if (cbTema.getSelectedItem().toString().trim().equals("")
				&& cbCliente.getSelectedItem().toString().trim().equals("")
				&& dcData.getDate().toString().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos acima para realizar o cadastro",
					"Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (cbTema.getSelectedItem().toString().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione um tema para realizar o cadastro", "Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (cbCliente.getSelectedItem().toString().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione um cliente para realizar o cadastro", "Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (dcData.getDate().toString().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha a data da festa para realizar o cadastro", "Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} 
		return valida;
	}

	private void cadastrar(String tema, String cliente, String dataFesta, String horarioInicio, String horarioFinal,
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
		
//		cbLogradouro.setText("");
//		tfNomeOficial.setText("");
//		tfNumero.setText("");
//		tfComplemento.setText("");
//		tfBairro.setText("");
//		tfCidade.setText("");
//		cbUF.setText("");
//		tfCEP.setText("");
//		tema.setText("");
//		cliente.setText("");
//		dataFesta.setText("");
//		valorCobrado.setText("");
		tfHorarioInicial.setText("");
		tfHorarioFinal.setText("");
		tfValorCobrado.setText("");
	}

}
