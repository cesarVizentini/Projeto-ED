package view.festa;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class TelaFestaCadastrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCadastrarFesta;
	private JButton btnVoltar;
	private JLabel lblHorarioInicial;
	private JLabel lblHorarioFinal;
	private JTextField textFieldHorarioInicial;
	private JTextField textFieldHorarioFinal;
	private JTextField textFieldLogradouro;
	private JTextField textFieldNumero;
	private JTextField textFieldCEP;
	private JTextField textFieldComplemento;
	private JTextField textFieldBairro;
	private JTextField textFieldCidade;
	private JTextField textFieldValorCobrado;

	public TelaFestaCadastrar() {
		setTitle("Cadastrar Festa");
		setResizable(false);
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet  = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(iconeRafaelaBuffet);
		setIconImage(iconeRafaelaBuffet);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1024, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 220, 253));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(53, 65, 171));
		separator.setBounds(10, 11, 980, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(53, 65, 171));
		separator_1.setBounds(10, 655, 980, 2);
		contentPane.add(separator_1);
		
		JLabel lblCadastrarFesta = new JLabel("Cadastrar Festa");
		lblCadastrarFesta.setForeground(new Color(53, 65, 171));
		lblCadastrarFesta.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
		lblCadastrarFesta.setBounds(10, 11, 338, 36);
		contentPane.add(lblCadastrarFesta);
		
		btnCadastrarFesta = new JButton("Cadastrar Festa");
		btnCadastrarFesta.setBackground(new Color(60, 179, 113));
		btnCadastrarFesta.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnCadastrarFesta.setBounds(792, 621, 198, 23);
		contentPane.add(btnCadastrarFesta);
		
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
		btnVoltar.setBounds(10, 621, 106, 23);
		contentPane.add(btnVoltar);
		
		lblHorarioInicial = new JLabel("Hor\u00E1rio Inicial");
		lblHorarioInicial.setForeground(new Color(81, 107, 153));
		lblHorarioInicial.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblHorarioInicial.setBounds(254, 114, 127, 24);
		contentPane.add(lblHorarioInicial);
		
		JDateChooser dateChooserData = new JDateChooser();
		dateChooserData.getCalendarButton().setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		dateChooserData.setBounds(10, 139, 150, 20);
		contentPane.add(dateChooserData);
		
		lblHorarioFinal = new JLabel("Hor\u00E1rio Final");
		lblHorarioFinal.setForeground(new Color(81, 107, 153));
		lblHorarioFinal.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblHorarioFinal.setBounds(499, 111, 106, 30);
		contentPane.add(lblHorarioFinal);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setForeground(new Color(81, 107, 153));
		lblCliente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblCliente.setBounds(10, 58, 106, 24);
		contentPane.add(lblCliente);
		
		JLabel lblTema = new JLabel("Tema");
		lblTema.setForeground(new Color(81, 107, 153));
		lblTema.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblTema.setBounds(326, 58, 106, 24);
		contentPane.add(lblTema);
		
		JLabel lblData = new JLabel("Data");
		lblData.setForeground(new Color(81, 107, 153));
		lblData.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblData.setBounds(10, 114, 106, 24);
		contentPane.add(lblData);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setForeground(new Color(81, 107, 153));
		lblLogradouro.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblLogradouro.setBounds(10, 170, 86, 23);
		contentPane.add(lblLogradouro);
		
		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setForeground(new Color(81, 107, 153));
		lblNumero.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblNumero.setBounds(213, 170, 63, 23);
		contentPane.add(lblNumero);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setForeground(new Color(81, 107, 153));
		lblComplemento.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblComplemento.setBounds(10, 225, 98, 30);
		contentPane.add(lblComplemento);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setForeground(new Color(81, 107, 153));
		lblBairro.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblBairro.setBounds(234, 225, 54, 30);
		contentPane.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setForeground(new Color(81, 107, 153));
		lblCidade.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblCidade.setBounds(452, 225, 86, 30);
		contentPane.add(lblCidade);
		
		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setForeground(new Color(81, 107, 153));
		lblCEP.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblCEP.setBounds(368, 166, 33, 30);
		contentPane.add(lblCEP);
		
		JLabel lblUF = new JLabel("UF");
		lblUF.setForeground(new Color(81, 107, 153));
		lblUF.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblUF.setBounds(546, 170, 33, 20);
		contentPane.add(lblUF);
		
		JLabel lblValorCobrado = new JLabel("Valor R$");
		lblValorCobrado.setForeground(new Color(81, 107, 153));
		lblValorCobrado.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblValorCobrado.setBounds(10, 296, 64, 30);
		contentPane.add(lblValorCobrado);
		
		JComboBox comboBoxCliente = new JComboBox();
		comboBoxCliente.setBounds(10, 81, 300, 22);
		contentPane.add(comboBoxCliente);
		
		JComboBox comboBoxTema = new JComboBox();
		comboBoxTema.setBounds(326, 81, 300, 22);
		contentPane.add(comboBoxTema);
		
		textFieldHorarioInicial = new JTextField();
		textFieldHorarioInicial.setBounds(254, 139, 127, 20);
		contentPane.add(textFieldHorarioInicial);
		textFieldHorarioInicial.setColumns(10);
		
		textFieldHorarioFinal = new JTextField();
		textFieldHorarioFinal.setColumns(10);
		textFieldHorarioFinal.setBounds(499, 139, 127, 20);
		contentPane.add(textFieldHorarioFinal);
		
		textFieldLogradouro = new JTextField();
		textFieldLogradouro.setColumns(10);
		textFieldLogradouro.setBounds(10, 194, 150, 20);
		contentPane.add(textFieldLogradouro);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(213, 194, 80, 20);
		contentPane.add(textFieldNumero);
		
		textFieldCEP = new JTextField();
		textFieldCEP.setColumns(10);
		textFieldCEP.setBounds(368, 194, 120, 20);
		contentPane.add(textFieldCEP);
		
		JComboBox comboBoxUF = new JComboBox();
		comboBoxUF.setBounds(546, 191, 80, 22);
		contentPane.add(comboBoxUF);
		
		textFieldComplemento = new JTextField();
		textFieldComplemento.setColumns(10);
		textFieldComplemento.setBounds(10, 253, 185, 20);
		contentPane.add(textFieldComplemento);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(234, 253, 185, 20);
		contentPane.add(textFieldBairro);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(452, 253, 182, 20);
		contentPane.add(textFieldCidade);
		
		textFieldValorCobrado = new JTextField();
		textFieldValorCobrado.setColumns(10);
		textFieldValorCobrado.setBounds(80, 302, 80, 20);
		contentPane.add(textFieldValorCobrado);
	}
}
