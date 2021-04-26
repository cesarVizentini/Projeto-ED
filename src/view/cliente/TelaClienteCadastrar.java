package view.cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class TelaClienteCadastrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaClienteCadastrar;
	private JTextField tfNome;
	private JFormattedTextField jftfDocumentoCPF;
	private JButton btnCadastrarCliente;
	private JButton btnVoltar;
	private JLabel lblDocumentoCPF;
	private JLabel lblTelefone;
	private JLabel lblNome;
	private JFormattedTextField jftfTelefone;
	private JLabel lblCadastrarCliente;

	public TelaClienteCadastrar() {
		setTitle("Cadastrar Cliente");
		setResizable(false);
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(iconeRafaelaBuffet);
		setIconImage(iconeRafaelaBuffet);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1024, 720);
		telaClienteCadastrar = new JPanel();
		telaClienteCadastrar.setBackground(new Color(173, 220, 253));
		telaClienteCadastrar.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaClienteCadastrar);
		telaClienteCadastrar.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(53, 65, 171));
		separator.setBounds(10, 11, 980, 2);
		telaClienteCadastrar.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(53, 65, 171));
		separator_1.setBounds(10, 656, 980, 2);
		telaClienteCadastrar.add(separator_1);

		lblCadastrarCliente = new JLabel("Cadastrar Cliente");
		lblCadastrarCliente.setForeground(new Color(53, 65, 171));
		lblCadastrarCliente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
		lblCadastrarCliente.setBounds(10, 11, 338, 69);
		telaClienteCadastrar.add(lblCadastrarCliente);

		lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(81, 107, 153));
		lblNome.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblNome.setBounds(10, 98, 62, 30);
		telaClienteCadastrar.add(lblNome);

		tfNome = new JTextField();
		tfNome.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		tfNome.setBounds(176, 98, 458, 30);
		telaClienteCadastrar.add(tfNome);
		tfNome.setColumns(10);

		MaskFormatter telefone = null;
		try {
			telefone = new MaskFormatter("(##) #####-####");
			telefone.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(new Color(81, 107, 153));
		lblTelefone.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblTelefone.setBounds(10, 192, 167, 30);
		telaClienteCadastrar.add(lblTelefone);
		
		jftfTelefone = new JFormattedTextField(telefone);
		jftfTelefone.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		jftfTelefone.setColumns(10);
		jftfTelefone.setBounds(176, 192, 296, 30);
		telaClienteCadastrar.add(jftfTelefone);

		lblDocumentoCPF = new JLabel("Documento CPF");
		lblDocumentoCPF.setForeground(new Color(81, 107, 153));
		lblDocumentoCPF.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblDocumentoCPF.setBounds(10, 289, 156, 30);
		telaClienteCadastrar.add(lblDocumentoCPF);
		
		MaskFormatter CPF = null;
		try {
			CPF = new MaskFormatter("###.###.###-##");
			CPF.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		jftfDocumentoCPF = new JFormattedTextField(CPF);
		jftfDocumentoCPF.setForeground(Color.BLACK);
		jftfDocumentoCPF.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		jftfDocumentoCPF.setBounds(176, 289, 296, 30);
		telaClienteCadastrar.add(jftfDocumentoCPF);
		jftfDocumentoCPF.setColumns(10);

		btnVoltar = new JButton("< Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaClientePrincipal telaClientePrincipal = new TelaClientePrincipal();
				telaClientePrincipal.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnVoltar.setBackground(new Color(255, 102, 102));
		btnVoltar.setBounds(10, 622, 106, 23);
		telaClienteCadastrar.add(btnVoltar);
		
		btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.setBackground(new Color(60, 179, 113));
		btnCadastrarCliente.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnCadastrarCliente.setBounds(792, 622, 198, 23);
		telaClienteCadastrar.add(btnCadastrarCliente);
		
		ClienteController clienteController = new ClienteController(tfNome, jftfTelefone, jftfDocumentoCPF);
		
		btnCadastrarCliente.addActionListener(clienteController);
	}
}
