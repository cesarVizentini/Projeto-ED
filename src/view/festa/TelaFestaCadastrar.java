package view.festa;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import com.toedter.calendar.JDateChooser;
import controller.ArquivosDiretorios;
import controller.FestaController;
import model.ClienteComboBoxModel;
import model.TemaComboBoxModel;
import persistence.ClienteDao;
import persistence.TemaDao;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class TelaFestaCadastrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaFestaCadastrar;
	private JLabel lblCadastrarFesta;
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
	private JButton btnCadastrarFesta;
	private JButton btnVoltar;
	private TemaDao listaTema;
	private ClienteDao listaCliente;

	public TelaFestaCadastrar() {
		listaTema = new TemaDao();
		listaCliente = new ClienteDao();
		ArquivosDiretorios arquivosDiretorios = new ArquivosDiretorios();
		try {
			listaTema = arquivosDiretorios.getTemas(listaTema);
			listaCliente = arquivosDiretorios.getClientes(listaCliente);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		setTitle("Cadastrar Festa");
		setResizable(false);
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(iconeRafaelaBuffet);
		setIconImage(iconeRafaelaBuffet);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 679, 470);
		telaFestaCadastrar = new JPanel();
		telaFestaCadastrar.setBackground(new Color(173, 220, 253));
		telaFestaCadastrar.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaFestaCadastrar);
		telaFestaCadastrar.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(53, 65, 171));
		separator.setBounds(10, 11, 650, 2);
		telaFestaCadastrar.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(53, 65, 171));
		separator_1.setBounds(10, 414, 650, 2);
		telaFestaCadastrar.add(separator_1);

		lblCadastrarFesta = new JLabel("Cadastrar Festa");
		lblCadastrarFesta.setForeground(new Color(53, 65, 171));
		lblCadastrarFesta.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
		lblCadastrarFesta.setBounds(10, 11, 338, 36);
		telaFestaCadastrar.add(lblCadastrarFesta);

		lblTema = new JLabel("Tema");
		lblTema.setForeground(new Color(81, 107, 153));
		lblTema.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblTema.setBounds(326, 58, 106, 24);
		telaFestaCadastrar.add(lblTema);
		
		cbTema = new JComboBox<Object>();
		cbTema.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		cbTema.setBounds(326, 81, 300, 22);
		telaFestaCadastrar.add(cbTema);

		TemaComboBoxModel temaComboBoxModel = new TemaComboBoxModel(listaTema);
		cbTema.setModel(temaComboBoxModel);
		
		lblCliente = new JLabel("Cliente");
		lblCliente.setForeground(new Color(81, 107, 153));
		lblCliente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblCliente.setBounds(10, 58, 106, 24);
		telaFestaCadastrar.add(lblCliente);
		
		cbCliente = new JComboBox<Object>();
		cbCliente.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		cbCliente.setBounds(10, 81, 300, 22);
		telaFestaCadastrar.add(cbCliente);
		
		ClienteComboBoxModel clienteComboBoxModel = new ClienteComboBoxModel(listaCliente);
		cbCliente.setModel(clienteComboBoxModel);

		lblData = new JLabel("Data");
		lblData.setForeground(new Color(81, 107, 153));
		lblData.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblData.setBounds(10, 114, 106, 24);
		telaFestaCadastrar.add(lblData);
		
		dcData = new JDateChooser();
		dcData.getCalendarButton().setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		dcData.setBounds(10, 139, 150, 20);
		telaFestaCadastrar.add(dcData);
		
		lblHorarioInicial = new JLabel("Hor\u00E1rio Inicial");
		lblHorarioInicial.setForeground(new Color(81, 107, 153));
		lblHorarioInicial.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblHorarioInicial.setBounds(254, 114, 127, 24);
		telaFestaCadastrar.add(lblHorarioInicial);
		
		MaskFormatter HorarioInicial = null;
		try {
			HorarioInicial = new MaskFormatter("##:##");
			HorarioInicial.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		tfHorarioInicial = new JFormattedTextField(HorarioInicial);
		tfHorarioInicial.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		tfHorarioInicial.setBounds(254, 139, 63, 20);
		telaFestaCadastrar.add(tfHorarioInicial);
		tfHorarioInicial.setColumns(10);

		lblHorarioFinal = new JLabel("Hor\u00E1rio Final");
		lblHorarioFinal.setForeground(new Color(81, 107, 153));
		lblHorarioFinal.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblHorarioFinal.setBounds(499, 111, 106, 30);
		telaFestaCadastrar.add(lblHorarioFinal);
		
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
		tfHorarioFinal.setBounds(499, 139, 63, 20);
		telaFestaCadastrar.add(tfHorarioFinal);
		
		lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setForeground(new Color(81, 107, 153));
		lblLogradouro.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblLogradouro.setBounds(10, 170, 86, 23);
		telaFestaCadastrar.add(lblLogradouro);

		// Logradouro é constituído pelo tipo de logradouro e pelo nome oficial.

		cbLogradouro = new JComboBox<String>();
		cbLogradouro.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		cbLogradouro.setBounds(10, 194, 185, 20);
		telaFestaCadastrar.add(cbLogradouro);

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
		tfNomeOficial.setBounds(205, 193, 318, 20);
		telaFestaCadastrar.add(tfNomeOficial);

		lblNomeOficial = new JLabel("Nome Oficial");
		lblNomeOficial.setForeground(new Color(81, 107, 153));
		lblNomeOficial.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblNomeOficial.setBounds(205, 170, 106, 23);
		telaFestaCadastrar.add(lblNomeOficial);

		lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setForeground(new Color(81, 107, 153));
		lblNumero.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblNumero.setBounds(546, 170, 63, 23);
		telaFestaCadastrar.add(lblNumero);
		
		tfNumero = new JTextField();
		tfNumero.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		tfNumero.setColumns(10);
		tfNumero.setBounds(546, 194, 80, 20);
		telaFestaCadastrar.add(tfNumero);

		lblComplemento = new JLabel("Complemento");
		lblComplemento.setForeground(new Color(81, 107, 153));
		lblComplemento.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblComplemento.setBounds(12, 235, 98, 17);
		telaFestaCadastrar.add(lblComplemento);
		
		tfComplemento = new JTextField();
		tfComplemento.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		tfComplemento.setColumns(10);
		tfComplemento.setBounds(10, 253, 150, 20);
		telaFestaCadastrar.add(tfComplemento);

		lblBairro = new JLabel("Bairro");
		lblBairro.setForeground(new Color(81, 107, 153));
		lblBairro.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblBairro.setBounds(172, 234, 54, 17);
		telaFestaCadastrar.add(lblBairro);

		tfBairro = new JTextField();
		tfBairro.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		tfBairro.setColumns(10);
		tfBairro.setBounds(170, 253, 263, 20);
		telaFestaCadastrar.add(tfBairro);

		lblCidade = new JLabel("Cidade");
		lblCidade.setForeground(new Color(81, 107, 153));
		lblCidade.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblCidade.setBounds(442, 233, 54, 20);
		telaFestaCadastrar.add(lblCidade);
		
		tfCidade = new JTextField();
		tfCidade.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		tfCidade.setColumns(10);
		tfCidade.setBounds(442, 253, 182, 20);
		telaFestaCadastrar.add(tfCidade);		
		
		lblUF = new JLabel("UF");
		lblUF.setForeground(new Color(81, 107, 153));
		lblUF.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblUF.setBounds(10, 296, 24, 17);
		telaFestaCadastrar.add(lblUF);

		cbUF = new JComboBox<String>();
		cbUF.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		cbUF.setBounds(10, 314, 170, 20);
		telaFestaCadastrar.add(cbUF);

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
		lblCEP.setBounds(190, 296, 33, 17);
		telaFestaCadastrar.add(lblCEP);
		
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
		tfCEP.setBounds(190, 314, 120, 20);
		telaFestaCadastrar.add(tfCEP);

		lblValorCobrado = new JLabel("Valor R$");
		lblValorCobrado.setForeground(new Color(81, 107, 153));
		lblValorCobrado.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblValorCobrado.setBounds(472, 314, 64, 20);
		telaFestaCadastrar.add(lblValorCobrado);

		tfValorCobrado = new JTextField();
		tfValorCobrado.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 12));
//		tfValorCobrado.setEditable(false);
		tfValorCobrado.setColumns(10);
		tfValorCobrado.setBounds(546, 314, 80, 20);
		telaFestaCadastrar.add(tfValorCobrado);

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
		btnVoltar.setBounds(10, 380, 106, 23);
		telaFestaCadastrar.add(btnVoltar);

		btnCadastrarFesta = new JButton("Cadastrar Festa");
		btnCadastrarFesta.setBackground(new Color(60, 179, 113));
		btnCadastrarFesta.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnCadastrarFesta.setBounds(428, 380, 198, 23);
		telaFestaCadastrar.add(btnCadastrarFesta);
		
		FestaController festaController = new FestaController(cbTema, cbCliente, dcData, tfHorarioInicial, tfHorarioFinal, cbLogradouro, tfNomeOficial, tfNumero, tfComplemento, tfBairro, tfCidade, cbUF, tfCEP, tfValorCobrado);
		
		btnCadastrarFesta.addActionListener(festaController);
	}
}
