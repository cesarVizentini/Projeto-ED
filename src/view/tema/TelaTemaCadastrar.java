package view.tema;

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
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.TemaController;

import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class TelaTemaCadastrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaTemaCadastrar;
	private JTextField tfNome;
	private JButton btnCadastrarTema;
	private JButton btnVoltar;
	private JLabel lblPreco;
	private JTextArea taDescricao;
	private JLabel lblDescricao;
	private JLabel lblNome;
	private JLabel lblCadastrarTema;
	private JFormattedTextField jftfPreco;

	public TelaTemaCadastrar() {
		setTitle("Cadastrar Tema");
		setResizable(false);
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(iconeRafaelaBuffet);
		setIconImage(iconeRafaelaBuffet);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 700, 530);
		telaTemaCadastrar = new JPanel();
		telaTemaCadastrar.setBackground(new Color(173, 220, 253));
		telaTemaCadastrar.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaTemaCadastrar);
		telaTemaCadastrar.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(53, 65, 171));
		separator.setBounds(10, 11, 658, 2);
		telaTemaCadastrar.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(53, 65, 171));
		separator_1.setBounds(10, 477, 658, 2);
		telaTemaCadastrar.add(separator_1);

		lblCadastrarTema = new JLabel("Cadastrar Tema");
		lblCadastrarTema.setForeground(new Color(53, 65, 171));
		lblCadastrarTema.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
		lblCadastrarTema.setBounds(10, 11, 338, 69);
		telaTemaCadastrar.add(lblCadastrarTema);

		lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(81, 107, 153));
		lblNome.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblNome.setBounds(10, 94, 62, 24);
		telaTemaCadastrar.add(lblNome);

		tfNome = new JTextField();
		tfNome.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		tfNome.setBounds(142, 98, 492, 30);
		telaTemaCadastrar.add(tfNome);
		tfNome.setColumns(10);

		lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setForeground(new Color(81, 107, 153));
		lblDescricao.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblDescricao.setBounds(10, 154, 112, 24);
		telaTemaCadastrar.add(lblDescricao);

		taDescricao = new JTextArea();
		taDescricao.setLineWrap(true);
		taDescricao.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		taDescricao.setBounds(142, 156, 492, 107);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(142, 156, 492, 107);
		telaTemaCadastrar.add(scrollPane);
		scrollPane.setViewportView(taDescricao);

		lblPreco = new JLabel("Pre\u00E7o R$");
		lblPreco.setForeground(new Color(81, 107, 153));
		lblPreco.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblPreco.setBounds(10, 298, 96, 30);
		telaTemaCadastrar.add(lblPreco);

		MaskFormatter valor = null;

		try {
			valor = new MaskFormatter("#####.##");
			valor.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		jftfPreco = new JFormattedTextField(valor);
		jftfPreco.setForeground(Color.BLACK);
		jftfPreco.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		jftfPreco.setBounds(142, 294, 178, 30);
		telaTemaCadastrar.add(jftfPreco);

		btnVoltar = new JButton("< Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTemaPrincipal telaTemaPrincipal = new TelaTemaPrincipal();
				telaTemaPrincipal.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnVoltar.setBackground(new Color(255, 102, 102));
		btnVoltar.setBounds(10, 435, 106, 24);
		telaTemaCadastrar.add(btnVoltar);

		btnCadastrarTema = new JButton("Cadastrar Tema");
		btnCadastrarTema.setBackground(new Color(60, 179, 113));
		btnCadastrarTema.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnCadastrarTema.setBounds(436, 436, 198, 23);
		telaTemaCadastrar.add(btnCadastrarTema);
		
		TemaController temaController = new TemaController(tfNome, taDescricao, jftfPreco);
		
		btnCadastrarTema.addActionListener(temaController);
	}
}
