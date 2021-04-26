package view.cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;

public class TelaClienteAlterar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaClienteAlterar;
	private JLabel lblNome;
	private JTextField tfNome;
	private JLabel lblTelefone;
	private JLabel lblDocumentoCPF;
	private JButton btnAlterarCliente;
	private JButton btnVoltar;
	private JLabel lblEscolherCliente;
	private JFormattedTextField jftfTelefone;
	private JFormattedTextField jftfDocumentoCPF;
	private JTable tableListClientes;
	private JLabel lblAlterarCliente;

	public TelaClienteAlterar() {
		setTitle("Alterar Cliente");
		setResizable(false);
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet  = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(iconeRafaelaBuffet);
		setIconImage(iconeRafaelaBuffet);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1024, 720);
		telaClienteAlterar = new JPanel();
		telaClienteAlterar.setBackground(new Color(173, 220, 253));
		telaClienteAlterar.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaClienteAlterar);
		telaClienteAlterar.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(53, 65, 171));
		separator.setBounds(10, 11, 980, 2);
		telaClienteAlterar.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(53, 65, 171));
		separator_1.setBounds(10, 666, 980, 2);
		telaClienteAlterar.add(separator_1);
		
		lblAlterarCliente = new JLabel("Alterar Cliente");
		lblAlterarCliente.setForeground(new Color(53, 65, 171));
		lblAlterarCliente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
		lblAlterarCliente.setBounds(10, 11, 338, 69);
		telaClienteAlterar.add(lblAlterarCliente);
		
		lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(81, 107, 153));
		lblNome.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblNome.setBounds(456, 88, 62, 30);
		telaClienteAlterar.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		tfNome.setBounds(619, 91, 371, 30);
		telaClienteAlterar.add(tfNome);
		tfNome.setColumns(10);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(new Color(81, 107, 153));
		lblTelefone.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblTelefone.setBounds(456, 195, 130, 30);
		telaClienteAlterar.add(lblTelefone);
		
		MaskFormatter telefone = null;
		try {
			telefone = new MaskFormatter("(##) #####-####");
			telefone.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		jftfTelefone = new JFormattedTextField(telefone);
		jftfTelefone.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		jftfTelefone.setColumns(10);
		jftfTelefone.setBounds(619, 198, 371, 30);
		telaClienteAlterar.add(jftfTelefone);

		lblDocumentoCPF = new JLabel("Documento CPF");
		lblDocumentoCPF.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDocumentoCPF.setForeground(new Color(81, 107, 153));
		lblDocumentoCPF.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblDocumentoCPF.setBounds(444, 303, 165, 30);
		telaClienteAlterar.add(lblDocumentoCPF);
		
		MaskFormatter CPF = null;
		try {
			CPF = new MaskFormatter("###.###.###-##");
			CPF.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		jftfDocumentoCPF = new JFormattedTextField(CPF);
		jftfDocumentoCPF.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		jftfDocumentoCPF.setColumns(10);
		jftfDocumentoCPF.setBounds(619, 303, 371, 30);
		telaClienteAlterar.add(jftfDocumentoCPF);
		
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
		btnVoltar.setBounds(10, 632, 106, 23);
		telaClienteAlterar.add(btnVoltar);
		
		lblEscolherCliente = new JLabel("Cliente a alterar");
		lblEscolherCliente.setForeground(new Color(81, 107, 153));
		lblEscolherCliente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblEscolherCliente.setBounds(10, 91, 224, 24);
		telaClienteAlterar.add(lblEscolherCliente);
		
		tableListClientes = new JTable();
		tableListClientes.setBounds(10, 125, 425, 480);
		telaClienteAlterar.add(tableListClientes);
		
		btnAlterarCliente = new JButton("Alterar Cliente");
		btnAlterarCliente.setBackground(new Color(60, 179, 113));
		btnAlterarCliente.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnAlterarCliente.setBounds(792, 632, 198, 23);
		telaClienteAlterar.add(btnAlterarCliente);
	}

}
