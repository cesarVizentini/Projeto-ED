package view.festa;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import view.TelaMenuPrincipal;

public class TelaFestaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableListFestas;

	public TelaFestaPrincipal() {
		setTitle("Festa Principal");
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
		
		tableListFestas = new JTable();
		tableListFestas.setBounds(10, 11, 760, 624);
		contentPane.add(tableListFestas);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuPrincipal telaMenuPrincipal = new TelaMenuPrincipal();
				telaMenuPrincipal.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBackground(Color.RED);
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		btnVoltar.setBounds(10, 646, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnCadastrarFesta = new JButton("Cadastrar Festa");
		btnCadastrarFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFestaCadastrar telaFestaCadastrar = new TelaFestaCadastrar();
				telaFestaCadastrar.setVisible(true);
				dispose();
			}
		});
		btnCadastrarFesta.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnCadastrarFesta.setBounds(801, 11, 182, 50);
		contentPane.add(btnCadastrarFesta);
		
		JButton btnAlterarFesta = new JButton("Alterar Festa");
		btnAlterarFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFestaAlterar telaFestaAlterar = new TelaFestaAlterar();
				telaFestaAlterar.setVisible(true);
				dispose();
			}
		});
		btnAlterarFesta.setBackground(Color.WHITE);
		btnAlterarFesta.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnAlterarFesta.setBounds(801, 73, 182, 50);
		contentPane.add(btnAlterarFesta);
		
		JButton btnDeletarFesta = new JButton("Deletar Festa");
		btnDeletarFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFestaDeletar telaFestaDeletar = new TelaFestaDeletar();
				telaFestaDeletar.setVisible(true);
				dispose();
			}
		});
		btnDeletarFesta.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnDeletarFesta.setBounds(801, 135, 182, 50);
		contentPane.add(btnDeletarFesta);
	}
}
