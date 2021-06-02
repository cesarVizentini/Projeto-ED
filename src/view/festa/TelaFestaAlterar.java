package view.festa;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.text.MaskFormatter;
import com.toedter.calendar.JDateChooser;
import controller.ArquivosDiretorios;
import model.ClienteComboBoxModel;
import model.Endereco;
import model.Festa;
import model.FestaTableModel;
import model.TemaComboBoxModel;
import persistence.ClienteDao;
import persistence.FestaDao;
import persistence.TemaDao;

public class TelaFestaAlterar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaFestaAlterar;
	private JButton btnAlterarFesta;
	private JButton btnVoltar;
	private JLabel lblEscolherFesta;
	private JTable tableListFestas;
	private FestaDao lista;
	private JButton btnSelecionarFesta;
	private JLabel lblAlterarFesta;
	private TemaDao listaTema;
	private ClienteDao listaCliente;
	private JLabel lblNomeOficial;
	private JLabel lblCliente;
	private JLabel lblTema;
	private JLabel lblData;
	private JLabel lblHorarioInicial;
	private JLabel lblHorarioFinal;
	private JLabel lblLogradouro;
	private JLabel lblNumero;
	private JLabel lblComplemento;
	private JLabel lblBairro;
	private JLabel lblCidade;
	private JLabel lblUF;
	private JLabel lblCEP;
	private JLabel lblValorCobrado;
	private JComboBox<Object> cbTema;
	private JComboBox<Object> cbCliente;
	private JDateChooser dcData;
	private JFormattedTextField tfHorarioInicial;
	private JFormattedTextField tfHorarioFinal;
	private JComboBox<String> cbLogradouro;
	private JTextField tfNomeOficial;
	private JTextField tfNumero;
	private JTextField tfComplemento;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JComboBox<String> cbUF;
	private JFormattedTextField tfCEP;
	private JTextField tfValorCobrado;

	public TelaFestaAlterar() {
		lista = new FestaDao();
		listaTema = new TemaDao();
		listaCliente = new ClienteDao();
		ArquivosDiretorios arquivosDiretorios = new ArquivosDiretorios();
		try {
			lista = arquivosDiretorios.getFestas(lista);
			listaTema = arquivosDiretorios.getTemas(listaTema);
			listaCliente = arquivosDiretorios.getClientes(listaCliente);
			if (lista != null) {
				lista.sort();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		setTitle("Alterar Tema");
		setResizable(false);
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(iconeRafaelaBuffet);
		setIconImage(iconeRafaelaBuffet);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1366, 720);
		telaFestaAlterar = new JPanel();
		telaFestaAlterar.setBackground(new Color(173, 220, 253));
		telaFestaAlterar.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaFestaAlterar);
		telaFestaAlterar.setLayout(null);

		lblAlterarFesta = new JLabel("Alterar Festa");
		lblAlterarFesta.setForeground(new Color(53, 65, 171));
		lblAlterarFesta.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
		lblAlterarFesta.setBounds(10, 11, 244, 36);
		telaFestaAlterar.add(lblAlterarFesta);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(53, 65, 171));
		separator.setBounds(10, 11, 1306, 2);
		telaFestaAlterar.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(53, 65, 171));
		separator_1.setBounds(10, 666, 1306, 2);
		telaFestaAlterar.add(separator_1);

		lblTema = new JLabel("Tema");
		lblTema.setForeground(new Color(81, 107, 153));
		lblTema.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblTema.setBounds(935, 161, 106, 24);
		telaFestaAlterar.add(lblTema);

		cbTema = new JComboBox<Object>();
		cbTema.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		cbTema.setBounds(935, 184, 381, 22);
		telaFestaAlterar.add(cbTema);

		TemaComboBoxModel temaComboBoxModel = new TemaComboBoxModel(listaTema);
		cbTema.setModel(temaComboBoxModel);

		lblCliente = new JLabel("Cliente");
		lblCliente.setForeground(new Color(81, 107, 153));
		lblCliente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblCliente.setBounds(935, 105, 106, 24);
		telaFestaAlterar.add(lblCliente);

		cbCliente = new JComboBox<Object>();
		cbCliente.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		cbCliente.setBounds(935, 128, 381, 22);
		telaFestaAlterar.add(cbCliente);

		ClienteComboBoxModel clienteComboBoxModel = new ClienteComboBoxModel(listaCliente);
		cbCliente.setModel(clienteComboBoxModel);

		lblData = new JLabel("Data");
		lblData.setForeground(new Color(81, 107, 153));
		lblData.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblData.setBounds(935, 216, 106, 24);
		telaFestaAlterar.add(lblData);

		dcData = new JDateChooser();
		dcData.getCalendarButton().setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		dcData.setBounds(935, 241, 150, 20);
		telaFestaAlterar.add(dcData);

		lblHorarioInicial = new JLabel("Hor\u00E1rio Inicial");
		lblHorarioInicial.setForeground(new Color(81, 107, 153));
		lblHorarioInicial.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblHorarioInicial.setBounds(1095, 218, 120, 20);
		telaFestaAlterar.add(lblHorarioInicial);

		MaskFormatter HorarioInicial = null;
		try {
			HorarioInicial = new MaskFormatter("##:##");
			HorarioInicial.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		tfHorarioInicial = new JFormattedTextField(HorarioInicial);
		tfHorarioInicial.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		tfHorarioInicial.setBounds(1095, 241, 63, 20);
		telaFestaAlterar.add(tfHorarioInicial);
		tfHorarioInicial.setColumns(10);

		lblHorarioFinal = new JLabel("Hor\u00E1rio Final");
		lblHorarioFinal.setForeground(new Color(81, 107, 153));
		lblHorarioFinal.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblHorarioFinal.setBounds(1224, 218, 106, 20);
		telaFestaAlterar.add(lblHorarioFinal);

		MaskFormatter HorarioFinal = null;
		try {
			HorarioFinal = new MaskFormatter("##:##");
			HorarioFinal.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		tfHorarioFinal = new JFormattedTextField(HorarioFinal);
		tfHorarioFinal.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		tfHorarioFinal.setColumns(10);
		tfHorarioFinal.setBounds(1224, 241, 63, 20);
		telaFestaAlterar.add(tfHorarioFinal);

		lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setForeground(new Color(81, 107, 153));
		lblLogradouro.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblLogradouro.setBounds(935, 272, 86, 23);
		telaFestaAlterar.add(lblLogradouro);

		// Logradouro é constituído pelo tipo de logradouro e pelo nome oficial.

		cbLogradouro = new JComboBox<String>();
		cbLogradouro.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		cbLogradouro.setBounds(935, 296, 150, 20);
		telaFestaAlterar.add(cbLogradouro);

		// No sistema de busca de CEP (Código de Endereçamento Postal)
		// disponibilizado pelos Correios, são reconhecidos os seguintes
		// tipos de logradouro:

		cbLogradouro.addItem("Aeroporto");
		cbLogradouro.addItem("Alameda");
		cbLogradouro.addItem("Área");
		cbLogradouro.addItem("Avenida");
		cbLogradouro.addItem("Campo");
		cbLogradouro.addItem("Chácara");
		cbLogradouro.addItem("Colônia");
		cbLogradouro.addItem("Condomínio");
		cbLogradouro.addItem("Conjunto");
		cbLogradouro.addItem("Distrito");
		cbLogradouro.addItem("Esplanada");
		cbLogradouro.addItem("Estação");
		cbLogradouro.addItem("Estrada");
		cbLogradouro.addItem("Favela");
		cbLogradouro.addItem("Fazenda");
		cbLogradouro.addItem("Feira");
		cbLogradouro.addItem("Jardim");
		cbLogradouro.addItem("Ladeira");
		cbLogradouro.addItem("Lago");
		cbLogradouro.addItem("Lagoa");
		cbLogradouro.addItem("Largo");
		cbLogradouro.addItem("Loteamento");
		cbLogradouro.addItem("Morro");
		cbLogradouro.addItem("Núcleo");
		cbLogradouro.addItem("Parque");
		cbLogradouro.addItem("Passarela");
		cbLogradouro.addItem("Pátio");
		cbLogradouro.addItem("Praça");
		cbLogradouro.addItem("Quadra");
		cbLogradouro.addItem("Recanto");
		cbLogradouro.addItem("Residencial");
		cbLogradouro.addItem("Rodovia");
		cbLogradouro.addItem("Rua");
		cbLogradouro.addItem("Setor");
		cbLogradouro.addItem("Sítio");
		cbLogradouro.addItem("Travessa");
		cbLogradouro.addItem("Trecho");
		cbLogradouro.addItem("Trevo");
		cbLogradouro.addItem("Vale");
		cbLogradouro.addItem("Vereda");
		cbLogradouro.addItem("Via");
		cbLogradouro.addItem("Viaduto");
		cbLogradouro.addItem("Viela");
		cbLogradouro.addItem("Vila");

		lblNomeOficial = new JLabel("Nome Oficial");
		lblNomeOficial.setForeground(new Color(81, 107, 153));
		lblNomeOficial.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblNomeOficial.setBounds(1095, 270, 106, 23);
		telaFestaAlterar.add(lblNomeOficial);

		tfNomeOficial = new JTextField();
		tfNomeOficial.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		tfNomeOficial.setBounds(1095, 295, 221, 20);
		telaFestaAlterar.add(tfNomeOficial);

		lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setForeground(new Color(81, 107, 153));
		lblNumero.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblNumero.setBounds(935, 329, 63, 13);
		telaFestaAlterar.add(lblNumero);

		tfNumero = new JTextField();
		tfNumero.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		tfNumero.setColumns(10);
		tfNumero.setBounds(935, 346, 59, 20);
		telaFestaAlterar.add(tfNumero);

		lblComplemento = new JLabel("Complemento");
		lblComplemento.setForeground(new Color(81, 107, 153));
		lblComplemento.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblComplemento.setBounds(1004, 327, 98, 17);
		telaFestaAlterar.add(lblComplemento);

		tfComplemento = new JTextField();
		tfComplemento.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		tfComplemento.setColumns(10);
		tfComplemento.setBounds(1004, 346, 150, 20);
		telaFestaAlterar.add(tfComplemento);

		lblBairro = new JLabel("Bairro");
		lblBairro.setForeground(new Color(81, 107, 153));
		lblBairro.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblBairro.setBounds(1166, 327, 54, 17);
		telaFestaAlterar.add(lblBairro);

		tfBairro = new JTextField();
		tfBairro.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		tfBairro.setColumns(10);
		tfBairro.setBounds(1164, 346, 152, 20);
		telaFestaAlterar.add(tfBairro);

		lblCidade = new JLabel("Cidade");
		lblCidade.setForeground(new Color(81, 107, 153));
		lblCidade.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblCidade.setBounds(935, 377, 54, 20);
		telaFestaAlterar.add(lblCidade);

		tfCidade = new JTextField();
		tfCidade.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		tfCidade.setColumns(10);
		tfCidade.setBounds(935, 397, 186, 20);
		telaFestaAlterar.add(tfCidade);

		lblUF = new JLabel("UF");
		lblUF.setForeground(new Color(81, 107, 153));
		lblUF.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblUF.setBounds(1131, 379, 24, 17);
		telaFestaAlterar.add(lblUF);

		cbUF = new JComboBox<String>();
		cbUF.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		cbUF.setBounds(1131, 397, 55, 20);
		telaFestaAlterar.add(cbUF);

		cbUF.addItem("AC");
		cbUF.addItem("AL");
		cbUF.addItem("AM");
		cbUF.addItem("AP");
		cbUF.addItem("BA");
		cbUF.addItem("CE");
		cbUF.addItem("DF");
		cbUF.addItem("ES");
		cbUF.addItem("GO");
		cbUF.addItem("MA");
		cbUF.addItem("MG");
		cbUF.addItem("MS");
		cbUF.addItem("MT");
		cbUF.addItem("PA");
		cbUF.addItem("PB");
		cbUF.addItem("PE");
		cbUF.addItem("PI");
		cbUF.addItem("PR");
		cbUF.addItem("RJ");
		cbUF.addItem("RN");
		cbUF.addItem("RO");
		cbUF.addItem("RR");
		cbUF.addItem("RS");
		cbUF.addItem("SC");
		cbUF.addItem("SE");
		cbUF.addItem("SP");
		cbUF.addItem("TO");

		lblCEP = new JLabel("CEP");
		lblCEP.setForeground(new Color(81, 107, 153));
		lblCEP.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblCEP.setBounds(1196, 379, 33, 17);
		telaFestaAlterar.add(lblCEP);

		MaskFormatter CEP = null;
		try {
			CEP = new MaskFormatter("#####-###");
			CEP.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		tfCEP = new JFormattedTextField(CEP);
		tfCEP.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		tfCEP.setColumns(10);
		tfCEP.setBounds(1196, 397, 120, 20);
		telaFestaAlterar.add(tfCEP);

		lblValorCobrado = new JLabel("Valor R$");
		lblValorCobrado.setForeground(new Color(81, 107, 153));
		lblValorCobrado.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblValorCobrado.setBounds(1236, 445, 64, 20);
		telaFestaAlterar.add(lblValorCobrado);

		tfValorCobrado = new JTextField();
		tfValorCobrado.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 12));
		// tfValorCobrado.setEditable(false);
		tfValorCobrado.setColumns(10);
		tfValorCobrado.setBounds(1236, 468, 80, 20);
		telaFestaAlterar.add(tfValorCobrado);

		btnVoltar = new JButton("< Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFestaPrincipal telaFestaPrincipal = new TelaFestaPrincipal();
				telaFestaPrincipal.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnVoltar.setBackground(new Color(255, 102, 102));
		btnVoltar.setBounds(10, 632, 106, 23);
		telaFestaAlterar.add(btnVoltar);

		lblEscolherFesta = new JLabel("Festa a alterar");
		lblEscolherFesta.setForeground(new Color(81, 107, 153));
		lblEscolherFesta.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblEscolherFesta.setBounds(10, 73, 224, 24);
		telaFestaAlterar.add(lblEscolherFesta);

		tableListFestas = new JTable();
		tableListFestas.setLocation(20, 33);
		tableListFestas.setShowVerticalLines(false);
		tableListFestas.setRowHeight(32);
		FestaTableModel festaTableModel = new FestaTableModel(lista);
		tableListFestas.setModel(festaTableModel);
		JTableHeader th = tableListFestas.getTableHeader();
		th.setPreferredSize(new Dimension(100, 40));
		tableListFestas.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableListFestas.getColumnModel().getColumn(1).setPreferredWidth(120);
		tableListFestas.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableListFestas.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				if (row % 2 == 0) {
					setBackground(Color.LIGHT_GRAY);
					setForeground(Color.BLACK);
				} else {
					setBackground(Color.WHITE);
					setForeground(Color.BLACK);
				}
				return this;
			}
		});
		telaFestaAlterar.add(tableListFestas);
		JScrollPane scroll = new JScrollPane(tableListFestas);
		scroll.setBounds(10, 105, 915, 497);
		telaFestaAlterar.add(scroll);

		btnSelecionarFesta = new JButton("Selecionar Cliente");
		btnSelecionarFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tableListFestas.isColumnSelected(8)) {

					String endereco = tableListFestas.getValueAt(tableListFestas.getSelectedRow(), 6).toString();

					String[] enderecoSeparado = endereco.split(",");
					String[] logradouro = enderecoSeparado[0].split(" ");
					String[] numero = enderecoSeparado[1].split(" ");
					String[] cidade = enderecoSeparado[2].split(" ");

					enderecoSeparado[3] = enderecoSeparado[3].replaceAll("\\D+","");

					cbLogradouro.setSelectedItem(logradouro[0]);
					tfNomeOficial.setText(logradouro[1]);
					tfNumero.setText(numero[1]);
					tfComplemento.setText(numero[3]);
					tfBairro.setText(numero[5]);
					tfCidade.setText(cidade[1]);
					cbUF.setSelectedItem(cidade[2]);
					tfCEP.setText(enderecoSeparado[3]);
					cbTema.setSelectedItem(tableListFestas.getValueAt(tableListFestas.getSelectedRow(), 1));
					cbCliente.setSelectedItem(
							tableListFestas.getValueAt(tableListFestas.getSelectedRow(), 2).toString());
					tfHorarioInicial
							.setText(tableListFestas.getValueAt(tableListFestas.getSelectedRow(), 4).toString());
					tfHorarioFinal.setText(tableListFestas.getValueAt(tableListFestas.getSelectedRow(), 5).toString());
					tfValorCobrado.setText(tableListFestas.getValueAt(tableListFestas.getSelectedRow(), 7).toString());

				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha na coluna opções", "Error", 0);
				}
			}
		});
		btnSelecionarFesta.setBackground(new Color(51, 153, 255));
		btnSelecionarFesta.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnSelecionarFesta.setBounds(727, 632, 198, 23);
		telaFestaAlterar.add(btnSelecionarFesta);

		btnAlterarFesta = new JButton("Alterar Festa");
		btnAlterarFesta.setBackground(new Color(60, 179, 113));
		btnAlterarFesta.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnAlterarFesta.setBounds(1118, 632, 198, 23);
		telaFestaAlterar.add(btnAlterarFesta);

		btnAlterarFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableListFestas.isColumnSelected(8)) {
					String s = tableListFestas.getValueAt(tableListFestas.getSelectedRow(), 0).toString();
					int id = Integer.parseInt(s);
					
					Date in = dcData.getDate();
					String formato = "dd/MM/yyyy";
					SimpleDateFormat formatter = new SimpleDateFormat(formato);

					try {
						Endereco endereco = new Endereco(cbLogradouro.getSelectedItem().toString(),
								tfNomeOficial.getText(), tfNumero.getText(), tfComplemento.getText(),
								tfBairro.getText(), tfCidade.getText(), cbUF.getSelectedItem().toString(),
								tfCEP.getText());
						endereco.setLogradouro(cbLogradouro.getSelectedItem().toString());
						endereco.setNomeOficial(tfNomeOficial.getText());
						endereco.setNumero(tfNumero.getText());
						endereco.setComplemento(tfComplemento.getText());
						endereco.setBairro(tfBairro.getText());
						endereco.setCidade(tfCidade.getText());
						endereco.setUf(cbUF.getSelectedItem().toString());
						endereco.setCep(tfCEP.getText());

						Festa festaAtt = new Festa(id, cbTema.getSelectedItem().toString(),
								cbCliente.getSelectedItem().toString(), dcData.getDate().toString(), tfHorarioInicial.getText(),
								tfHorarioFinal.getText(), endereco.toString(),
								Double.parseDouble(tfValorCobrado.getText()));
						festaAtt.setId(id);
						festaAtt.setTema(cbTema.getSelectedItem().toString());
						festaAtt.setCliente(cbCliente.getSelectedItem().toString());
						festaAtt.setDataFesta(formatter.format(in));
						festaAtt.setHorarioInicio(tfHorarioInicial.getText());
						festaAtt.setHorarioFinal(tfHorarioFinal.getText());
						festaAtt.setEndereco(endereco.toString());
						festaAtt.setValorCobrado(Double.parseDouble(tfValorCobrado.getText()));
						arquivosDiretorios.atualizarFesta(lista, festaAtt, id);

						cbLogradouro.setSelectedItem(null);
						tfNomeOficial.setText("");
						tfNumero.setText("");
						tfComplemento.setText("");
						tfBairro.setText("");
						tfCidade.setText("");
						cbUF.setSelectedItem(null);
						tfCEP.setText("");
						cbTema.setSelectedItem(null);
						cbCliente.setSelectedItem(null);
						dcData.setDate(null);
						tfHorarioInicial.setText("");
						tfHorarioFinal.setText("");
						tfValorCobrado.setText("");

						if (lista.getFesta(0) == null) {
							TelaFestaDeletar telaFestaDeletar = new TelaFestaDeletar();
							telaFestaDeletar.setVisible(true);
							dispose();
						} else {
							festaTableModel.addRow();
						}

					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha na coluna opções", "Error", 0);
				}
			}
		});
	}
}