package view.tema;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.TemaController;


public class TelaTemaAlterar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaTemaAlterar;
	private JLabel lblNome;
	private JTextField tfNome;
	private JLabel lblDescricao;
	private JTextArea taDescricao;
	private JLabel lblPreco;
	private JButton btnAlterarTema;
	private JButton btnVoltar;
	private JLabel lblEscolherTema;
	private JTable tableListTemas;
	private JLabel lblAlterarTema;
	private JFormattedTextField jftfPreco;

	public TelaTemaAlterar() {
		setTitle("Alterar Tema");
		setResizable(false);
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet  = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(iconeRafaelaBuffet);
		setIconImage(iconeRafaelaBuffet);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1024, 720);
		telaTemaAlterar = new JPanel();
		telaTemaAlterar.setBackground(new Color(173, 220, 253));
		telaTemaAlterar.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaTemaAlterar);
		telaTemaAlterar.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(53, 65, 171));
		separator.setBounds(10, 11, 980, 2);
		telaTemaAlterar.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(53, 65, 171));
		separator_1.setBounds(10, 660, 980, 2);
		telaTemaAlterar.add(separator_1);
		
		lblAlterarTema = new JLabel("Alterar Tema");
		lblAlterarTema.setForeground(new Color(53, 65, 171));
		lblAlterarTema.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
		lblAlterarTema.setBounds(10, 11, 338, 69);
		telaTemaAlterar.add(lblAlterarTema);
		
		lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(81, 107, 153));
		lblNome.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblNome.setBounds(454, 91, 62, 24);
		telaTemaAlterar.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		tfNome.setBounds(594, 95, 396, 20);
		telaTemaAlterar.add(tfNome);
		tfNome.setColumns(10);
		
		lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setForeground(new Color(81, 107, 153));
		lblDescricao.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblDescricao.setBounds(454, 244, 130, 30);
		telaTemaAlterar.add(lblDescricao);
		
		taDescricao = new JTextArea();
		taDescricao.setLineWrap(true);
		taDescricao.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		taDescricao.setBounds(142, 156, 492, 107);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(594, 248, 396, 107);
		telaTemaAlterar.add(scrollPane);
		scrollPane.setViewportView(taDescricao);
		
		lblPreco = new JLabel("Pre\u00E7o");
		lblPreco.setForeground(new Color(81, 107, 153));
		lblPreco.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblPreco.setBounds(454, 470, 62, 24);
		telaTemaAlterar.add(lblPreco);
		
		MaskFormatter valor = null;

		try {
			valor = new MaskFormatter("R$ ##.###,##");
			valor.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		jftfPreco = new JFormattedTextField(valor);
		jftfPreco.setForeground(Color.BLACK);
		jftfPreco.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		jftfPreco.setBounds(594, 474, 141, 20);
		telaTemaAlterar.add(jftfPreco);
		
		lblEscolherTema = new JLabel("Tema a alterar");
		lblEscolherTema.setForeground(new Color(81, 107, 153));
		lblEscolherTema.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblEscolherTema.setBounds(10, 91, 187, 24);
		telaTemaAlterar.add(lblEscolherTema);
		
		tableListTemas = new JTable();
		tableListTemas.setBounds(10, 125, 425, 480);
		telaTemaAlterar.add(tableListTemas);
		
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
		btnVoltar.setBounds(10, 626, 106, 23);
		telaTemaAlterar.add(btnVoltar);
	
		btnAlterarTema = new JButton("Alterar Tema");
		btnAlterarTema.setBackground(new Color(60, 179, 113));
		btnAlterarTema.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnAlterarTema.setBounds(792, 626, 198, 23);
		telaTemaAlterar.add(btnAlterarTema);
		
		TemaController temaController = new TemaController(tfNome, taDescricao, jftfPreco);
		
		btnAlterarTema.addActionListener(temaController);
	}

}