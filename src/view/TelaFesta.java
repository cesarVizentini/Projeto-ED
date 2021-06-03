package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.text.MaskFormatter;
import com.toedter.calendar.JDateChooser;
import controller.ArquivosDiretorios;
import controller.FestaController;
import model.ClienteComboBoxModel;
import model.Endereco;
import model.Festa;
import model.FestaTableModel;
import model.Tema;
import model.TemaComboBoxModel;
import persistence.ClienteDao;
import persistence.FestaDao;
import persistence.TemaDao;

public class TelaFesta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaFesta;
	private FestaDao lista;
	private TemaDao listaTema;
	private ClienteDao listaCliente;
	private JPanel sideMenu;
	private JButton btnSMHome;
	private JButton btnSMCliente;
	private JButton btnSMTema;
	private JButton btnSMFesta;
	private JButton btnSMFinancas;
	private JLabel SDLogo;
	private JLabel lblEspaco1;
	private JLabel lblEspaco2;
	private JLabel lblEspaco3;
	private JLabel lblEspaco4;
	private JTable tableListFestas;
	private JButton btnCadastrarFesta;
	private JButton btnAlterarFesta;
	private JButton btnDeletarFesta;
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
	private JButton btnSelecionarFesta;
	private JButton btnCalcularPreco;

	private void pegarResolucao() {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension dimensao = t.getScreenSize();
		int larg = dimensao.width;
		int alt = dimensao.height;
		setBounds(0, 0, larg, alt);
	}

	public TelaFesta() {
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

		setTitle("Festa");
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet = Toolkit.getDefaultToolkit().getImage(url);
		setIconImage(iconeRafaelaBuffet);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pegarResolucao();
		telaFesta = new JPanel();
		telaFesta.setBackground(new Color(135, 206, 235));
		telaFesta.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaFesta);
		telaFesta.setLayout(null);

		// INICIO SIDE-MENU
		sideMenu = new JPanel();
		sideMenu.setBackground(new Color(173, 220, 253));
		sideMenu.setBounds(0, 0, 240, 861);
		telaFesta.add(sideMenu);
		sideMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		SDLogo = new JLabel("");
		SDLogo.setIcon(new ImageIcon(TelaFesta.class.getResource("/view/assets/SDLogo.png")));
		SDLogo.setPreferredSize(new Dimension(240, 250));
		sideMenu.add(SDLogo);

		btnSMHome = new JButton("Home");
		btnSMHome.setPressedIcon(new ImageIcon(TelaFesta.class.getResource("/view/assets/pressed.png")));
		btnSMHome.setSelectedIcon(new ImageIcon(TelaFesta.class.getResource("/view/assets/selected.png")));
		btnSMHome.setRolloverIcon(new ImageIcon(TelaFesta.class.getResource("/view/assets/hover.png")));
		btnSMHome.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMHome.setIcon(new ImageIcon(TelaFesta.class.getResource("/view/assets/default.png")));
		btnSMHome.setBackground(new Color(255, 255, 255));
		btnSMHome.setPreferredSize(new Dimension(220, 40));
		btnSMHome.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		btnSMHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDashboard telaDashboard = new TelaDashboard();
				telaDashboard.setVisible(true);
				btnSMHome.setSelected(true);
				dispose();
			}
		});
		sideMenu.add(btnSMHome);

		lblEspaco1 = new JLabel("");
		lblEspaco1.setPreferredSize(new Dimension(20, 20));
		sideMenu.add(lblEspaco1);

		btnSMTema = new JButton("Tema");
		btnSMTema.setPressedIcon(new ImageIcon(TelaFesta.class.getResource("/view/assets/pressed.png")));
		btnSMTema.setIcon(new ImageIcon(TelaFesta.class.getResource("/view/assets/default.png")));
		btnSMTema.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMTema.setRolloverIcon(new ImageIcon(TelaFesta.class.getResource("/view/assets/hover.png")));
		btnSMTema.setSelectedIcon(new ImageIcon(TelaFesta.class.getResource("/view/assets/selected.png")));
		btnSMTema.setBackground(new Color(255, 255, 255));
		btnSMTema.setPreferredSize(new Dimension(220, 40));
		btnSMTema.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		btnSMTema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTema telaTema = new TelaTema();
				telaTema.setVisible(true);
				btnSMTema.setSelected(true);
				dispose();
			}
		});
		sideMenu.add(btnSMTema);

		lblEspaco2 = new JLabel("");
		lblEspaco2.setPreferredSize(new Dimension(20, 20));
		sideMenu.add(lblEspaco2);

		btnSMCliente = new JButton("Cliente");
		btnSMCliente.setPressedIcon(new ImageIcon(TelaFesta.class.getResource("/view/assets/pressed.png")));
		btnSMCliente.setIcon(new ImageIcon(TelaFesta.class.getResource("/view/assets/default.png")));
		btnSMCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMCliente.setRolloverIcon(new ImageIcon(TelaFesta.class.getResource("/view/assets/hover.png")));
		btnSMCliente.setSelectedIcon(new ImageIcon(TelaFesta.class.getResource("/view/assets/selected.png")));
		btnSMCliente.setBackground(new Color(255, 255, 255));
		btnSMCliente.setPreferredSize(new Dimension(220, 40));
		btnSMCliente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		btnSMCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCliente telaCliente = new TelaCliente();
				telaCliente.setVisible(true);
				btnSMCliente.setSelected(true);
				dispose();
			}
		});
		sideMenu.add(btnSMCliente);

		lblEspaco3 = new JLabel("");
		lblEspaco3.setPreferredSize(new Dimension(20, 20));
		sideMenu.add(lblEspaco3);

		btnSMFesta = new JButton("Festa");
		btnSMFesta.setPressedIcon(new ImageIcon(TelaFesta.class.getResource("/view/assets/pressed.png")));
		btnSMFesta.setIcon(new ImageIcon(TelaFesta.class.getResource("/view/assets/default.png")));
		btnSMFesta.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMFesta.setRolloverIcon(new ImageIcon(TelaFesta.class.getResource("/view/assets/hover.png")));
		btnSMFesta.setSelectedIcon(new ImageIcon(TelaFesta.class.getResource("/view/assets/selected.png")));
		btnSMFesta.setBackground(new Color(255, 255, 255));
		btnSMFesta.setPreferredSize(new Dimension(220, 40));
		btnSMFesta.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		btnSMFesta.setSelected(true);
		sideMenu.add(btnSMFesta);

		lblEspaco4 = new JLabel("");
		lblEspaco4.setPreferredSize(new Dimension(20, 20));
		sideMenu.add(lblEspaco4);

		btnSMFinancas = new JButton("Finanças");
		btnSMFinancas.setPressedIcon(new ImageIcon(TelaFesta.class.getResource("/view/assets/pressed.png")));
		btnSMFinancas.setIcon(new ImageIcon(TelaFesta.class.getResource("/view/assets/default.png")));
		btnSMFinancas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMFinancas.setRolloverIcon(new ImageIcon(TelaFesta.class.getResource("/view/assets/hover.png")));
		btnSMFinancas.setSelectedIcon(new ImageIcon(TelaFesta.class.getResource("/view/assets/selected.png")));
		btnSMFinancas.setBackground(new Color(255, 255, 255));
		btnSMFinancas.setPreferredSize(new Dimension(220, 40));
		btnSMFinancas.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		btnSMFinancas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFinancas telaFinancas = new TelaFinancas();
				telaFinancas.setVisible(true);
				btnSMFinancas.setSelected(true);
				dispose();
			}
		});
		sideMenu.add(btnSMFinancas);
		// FIM SIDE-MENU

		// INICIO TABLE
		tableListFestas = new JTable();
		tableListFestas.setLocation(20, 33);
		tableListFestas.setShowVerticalLines(false);
		tableListFestas.setRowHeight(32);
		FestaTableModel festaTableModel = new FestaTableModel(lista);
		tableListFestas.setModel(festaTableModel);
		JTableHeader th = tableListFestas.getTableHeader();
		th.setPreferredSize(new Dimension(100, 40));
		tableListFestas.getColumnModel().getColumn(0).setPreferredWidth(5);
		tableListFestas.getColumnModel().getColumn(1).setPreferredWidth(120);
		tableListFestas.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableListFestas.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				if (row % 2 == 0) {
					setBackground(new Color(210, 228, 240));
					setForeground(Color.BLACK);
				} else {
					setBackground(new Color(181, 212, 230));
					setForeground(Color.BLACK);
				}
				return this;
			}
		});
		telaFesta.add(tableListFestas);
		JScrollPane scroll = new JScrollPane(tableListFestas);
		scroll.setBounds(258, 11, 1141, 464);
		telaFesta.add(scroll);
		// FIM TABLE

		// INICIO FORMULARIO
		lblTema = new JLabel("Tema");
		lblTema.setForeground(new Color(81, 107, 153));
		lblTema.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblTema.setBounds(282, 485, 32, 16);
		telaFesta.add(lblTema);

		cbTema = new JComboBox<Object>();
		cbTema.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		cbTema.setBounds(282, 510, 210, 21);
		telaFesta.add(cbTema);

		TemaComboBoxModel temaComboBoxModel = new TemaComboBoxModel(listaTema);
		cbTema.setModel(temaComboBoxModel);

		lblCliente = new JLabel("Cliente");
		lblCliente.setForeground(new Color(81, 107, 153));
		lblCliente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblCliente.setBounds(525, 485, 56, 16);
		telaFesta.add(lblCliente);

		cbCliente = new JComboBox<Object>();
		cbCliente.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		cbCliente.setBounds(524, 510, 302, 21);
		telaFesta.add(cbCliente);

		ClienteComboBoxModel clienteComboBoxModel = new ClienteComboBoxModel(listaCliente);
		cbCliente.setModel(clienteComboBoxModel);

		lblData = new JLabel("Data");
		lblData.setForeground(new Color(81, 107, 153));
		lblData.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblData.setBounds(282, 553, 32, 16);
		telaFesta.add(lblData);

		dcData = new JDateChooser();
		dcData.getCalendarButton().setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		dcData.setBounds(282, 580, 180, 20);
		telaFesta.add(dcData);

		lblHorarioInicial = new JLabel("Hor\u00E1rio Inicial");
		lblHorarioInicial.setForeground(new Color(81, 107, 153));
		lblHorarioInicial.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblHorarioInicial.setBounds(545, 553, 120, 16);
		telaFesta.add(lblHorarioInicial);

		MaskFormatter HorarioInicial = null;
		try {
			HorarioInicial = new MaskFormatter("##:##");
			HorarioInicial.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		tfHorarioInicial = new JFormattedTextField(HorarioInicial);
		tfHorarioInicial.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		tfHorarioInicial.setBounds(545, 579, 76, 21);
		telaFesta.add(tfHorarioInicial);
		tfHorarioInicial.setColumns(10);

		lblHorarioFinal = new JLabel("Hor\u00E1rio Final");
		lblHorarioFinal.setForeground(new Color(81, 107, 153));
		lblHorarioFinal.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblHorarioFinal.setBounds(722, 553, 104, 16);
		telaFesta.add(lblHorarioFinal);

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
		tfHorarioFinal.setBounds(722, 579, 76, 21);
		telaFesta.add(tfHorarioFinal);

		lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setForeground(new Color(81, 107, 153));
		lblLogradouro.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblLogradouro.setBounds(282, 611, 80, 16);
		telaFesta.add(lblLogradouro);

		// Logradouro é constituído pelo tipo de logradouro e pelo nome oficial.

		cbLogradouro = new JComboBox<String>();
		cbLogradouro.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		cbLogradouro.setBounds(282, 638, 160, 23);
		telaFesta.add(cbLogradouro);

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

		tfNomeOficial = new JTextField();
		tfNomeOficial.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		tfNomeOficial.setBounds(469, 639, 269, 21);
		telaFesta.add(tfNomeOficial);

		lblNomeOficial = new JLabel("Nome Oficial");
		lblNomeOficial.setForeground(new Color(81, 107, 153));
		lblNomeOficial.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblNomeOficial.setBounds(469, 611, 96, 16);
		telaFesta.add(lblNomeOficial);

		lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setForeground(new Color(81, 107, 153));
		lblNumero.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblNumero.setBounds(750, 611, 48, 16);
		telaFesta.add(lblNumero);

		tfNumero = new JTextField();
		tfNumero.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		tfNumero.setColumns(10);
		tfNumero.setBounds(750, 640, 76, 20);
		telaFesta.add(tfNumero);

		lblComplemento = new JLabel("Complemento");
		lblComplemento.setForeground(new Color(81, 107, 153));
		lblComplemento.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblComplemento.setBounds(282, 677, 88, 16);
		telaFesta.add(lblComplemento);

		tfComplemento = new JTextField();
		tfComplemento.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		tfComplemento.setColumns(10);
		tfComplemento.setBounds(282, 704, 183, 21);
		telaFesta.add(tfComplemento);

		lblBairro = new JLabel("Bairro");
		lblBairro.setForeground(new Color(81, 107, 153));
		lblBairro.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblBairro.setBounds(483, 677, 48, 16);
		telaFesta.add(lblBairro);

		tfBairro = new JTextField();
		tfBairro.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		tfBairro.setColumns(10);
		tfBairro.setBounds(483, 704, 182, 21);
		telaFesta.add(tfBairro);

		lblCidade = new JLabel("Cidade");
		lblCidade.setForeground(new Color(81, 107, 153));
		lblCidade.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblCidade.setBounds(694, 677, 48, 16);
		telaFesta.add(lblCidade);

		tfCidade = new JTextField();
		tfCidade.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		tfCidade.setColumns(10);
		tfCidade.setBounds(694, 704, 132, 21);
		telaFesta.add(tfCidade);

		lblUF = new JLabel("UF");
		lblUF.setForeground(new Color(81, 107, 153));
		lblUF.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblUF.setBounds(282, 736, 16, 16);
		telaFesta.add(lblUF);

		cbUF = new JComboBox<String>();
		cbUF.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		cbUF.setBounds(282, 760, 76, 23);
		telaFesta.add(cbUF);

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
		lblCEP.setBounds(386, 736, 24, 16);
		telaFesta.add(lblCEP);

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
		tfCEP.setBounds(386, 762, 96, 21);
		telaFesta.add(tfCEP);

		lblValorCobrado = new JLabel("Valor R$");
		lblValorCobrado.setForeground(new Color(81, 107, 153));
		lblValorCobrado.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblValorCobrado.setBounds(674, 763, 64, 16);
		telaFesta.add(lblValorCobrado);
		//#########################################################################################################################
		tfValorCobrado = new JTextField();
		tfValorCobrado.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 12));
		tfValorCobrado.setEditable(false);
		tfValorCobrado.setColumns(10);
		tfValorCobrado.setBounds(750, 762, 76, 21);
		telaFesta.add(tfValorCobrado);
		// FIM FORMULARIO

		// INICIO BOTOES
		btnCadastrarFesta = new JButton("Cadastrar Festa");
		btnCadastrarFesta.setBackground(new Color(60, 179, 113));
		btnCadastrarFesta.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnCadastrarFesta.setBounds(1196, 486, 205, 27);
		btnCadastrarFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCliente telaCliente = new TelaCliente();
				boolean valido = validaTela();
				if (valido) {
					boolean newTable = false;
					if (lista == null) {
						newTable = true;
					}
					FestaController festaController = new FestaController();
//					telaCliente.atualizar(cbCliente.getSelectedItem().toString());
					
					festaController.cadastrar(cbTema.getSelectedItem().toString(),
							cbCliente.getSelectedItem().toString(), converterData(dcData.getDate()),
							tfHorarioInicial.getText(), tfHorarioFinal.getText(),
							cbLogradouro.getSelectedItem().toString(), tfNomeOficial.getText(), tfNumero.getText(),
							tfComplemento.getText(), tfBairro.getText(), tfCidade.getText(),
							cbUF.getSelectedItem().toString(), tfCEP.getText(),
							Double.parseDouble(tfValorCobrado.getText()));
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
					if (newTable) {
						TelaFesta telaFesta = new TelaFesta();
						telaFesta.setVisible(false);
						telaFesta.dispose();
					} else {
						FestaTableModel festaTableModel = new FestaTableModel(lista);
						festaTableModel.addRow();
						TelaFesta telaFesta = new TelaFesta();
						telaFesta.setVisible(true);
						dispose();
						try {
							lista.sort();
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		telaFesta.add(btnCadastrarFesta);

		btnSelecionarFesta = new JButton("Selecionar Festa");
		btnSelecionarFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tableListFestas.isColumnSelected(8)) {

					String endereco = tableListFestas.getValueAt(tableListFestas.getSelectedRow(), 6).toString();

					String[] enderecoSeparado = endereco.split(",");
					String[] logradouro = enderecoSeparado[0].split(" ");
					String[] numero = enderecoSeparado[1].split(" ");
					String[] cidade = enderecoSeparado[2].split(" ");

					enderecoSeparado[3] = enderecoSeparado[3].replaceAll("\\D+", "");

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
		btnSelecionarFesta.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnSelecionarFesta.setBackground(new Color(221, 160, 221));
		btnSelecionarFesta.setBounds(1194, 535, 205, 27);
		telaFesta.add(btnSelecionarFesta);

		btnAlterarFesta = new JButton("Alterar Festa");
		btnAlterarFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean valido = validaTela();
				if (valido) {
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
									cbCliente.getSelectedItem().toString(), dcData.getDate().toString(),
									tfHorarioInicial.getText(), tfHorarioFinal.getText(), endereco.toString(), Double.parseDouble(tfValorCobrado.getText()));
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
								TelaFesta telaFesta = new TelaFesta();
								telaFesta.setVisible(true);
								dispose();
							} else {
								festaTableModel.addRow();
								TelaFesta telaFesta = new TelaFesta();
								telaFesta.setVisible(true);
								dispose();
							}

						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Selecione uma linha na coluna opções", "Error", 0);
					}
				}
			}
		});
		btnAlterarFesta.setBackground(new Color(204, 255, 51));
		btnAlterarFesta.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnAlterarFesta.setBounds(1196, 580, 205, 27);
		telaFesta.add(btnAlterarFesta);

		btnDeletarFesta = new JButton("Deletar Festa");
		btnDeletarFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableListFestas.isColumnSelected(8)) {
					String s = tableListFestas.getValueAt(tableListFestas.getSelectedRow(), 0).toString();
					int id = Integer.parseInt(s);
					try {
						arquivosDiretorios.removerFesta(lista, id);
						if (lista.getFesta(0) == null) {
							TelaFesta telaFesta = new TelaFesta();
							telaFesta.setVisible(true);
							dispose();
						} else {
							festaTableModel.addRow();
							TelaFesta telaFesta = new TelaFesta();
							telaFesta.setVisible(true);
							dispose();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha na coluna opções", "Error", 0);
				}
			}
		});
		btnDeletarFesta.setBackground(new Color(255, 102, 102));
		btnDeletarFesta.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnDeletarFesta.setBounds(1196, 626, 205, 27);
		telaFesta.add(btnDeletarFesta);
		
		btnCalcularPreco = new JButton("Calcular Valor");
		btnCalcularPreco.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnCalcularPreco.setBackground(new Color(60, 179, 113));
		btnCalcularPreco.setBounds(1194, 675, 205, 27);
		//#####################################################################################################################################
		btnCalcularPreco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FestaController festaController = new FestaController();
				tfValorCobrado.setText(festaController.calcularValor(cbTema.getSelectedItem().toString(),
						cbCliente.getSelectedItem().toString()));
			}
		});
		
		telaFesta.add(btnCalcularPreco);
		// FIM BOTOES
	}

	public String converterData(Date date) {
		Date in = date;
		String formato = "dd/MM/yyyy";
		SimpleDateFormat formatter = new SimpleDateFormat(formato);
		return formatter.format(in);
	}

	private boolean validaTela() {
		boolean valida = true;
		if (cbTema.getSelectedItem() == null && cbCliente.getSelectedItem() == null && dcData.getDate() == null
				&& tfHorarioInicial.getText().trim().equals("") && tfHorarioFinal.getText().trim().equals("")
				&& cbLogradouro == null && tfNomeOficial.getText().trim().equals("")
				&& tfNumero.getText().trim().equals("") && tfComplemento.getText().trim().equals("")
				&& tfBairro.getText().trim().equals("") && tfCidade.getText().trim().equals("")
				&& cbUF.getSelectedItem() == null && tfCEP.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos acima para realizar o cadastro",
					"Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (cbTema.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione um tema para realizar o cadastro", "Informação",
					JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (cbCliente.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione um cliente para realizar o cadastro",
					"Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (dcData.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha a data da festa para realizar o cadastro",
					"Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (tfHorarioInicial.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Por favor, preencha o horário inicial da festa para realizar o cadastro", "Informação",
					JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (tfHorarioFinal.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha o horário final da festa para realizar o cadastro",
					"Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (cbLogradouro.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione um logradouro para realizar o cadastro",
					"Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (tfNomeOficial.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha o nome oficial para realizar o cadastro",
					"Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (tfNumero.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha o número para realizar o cadastro", "Informação",
					JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (tfComplemento.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha o complemento para realizar o cadastro",
					"Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (tfBairro.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha o bairro para realizar o cadastro", "Informação",
					JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (tfCidade.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha a cidade para realizar o cadastro", "Informação",
					JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (cbUF.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione um UF para realizar o cadastro", "Informação",
					JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (tfCEP.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha o CEP para realizar o cadastro", "Informação",
					JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		}
		return valida;
	}
	
}
