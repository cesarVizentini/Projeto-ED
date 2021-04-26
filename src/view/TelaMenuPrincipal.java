package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import view.cliente.TelaClientePrincipal;
import view.festa.TelaFestaPrincipal;
import view.financas.TelaFinancas;
import view.tema.TelaTemaPrincipal;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

public class TelaMenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public TelaMenuPrincipal() {
		setTitle("Menu Principal");
		setResizable(false);
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet  = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(iconeRafaelaBuffet);
		setIconImage(iconeRafaelaBuffet);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 220, 253));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 20));
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaClientePrincipal telaClientePrincipal = new TelaClientePrincipal();
				telaClientePrincipal.setVisible(true);
				dispose();
			}
		});
		btnCliente.setBackground(Color.WHITE);
		btnCliente.setForeground(Color.BLACK);
		btnCliente.setBounds(100, 193, 250, 80);
		contentPane.add(btnCliente);
		
		JButton btnFinancas = new JButton("Finan\u00E7as");
		btnFinancas.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 20));
		btnFinancas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFinancas telaFinancas = new TelaFinancas();
				telaFinancas.setVisible(true);
				dispose();
			}
		});
		btnFinancas.setBackground(Color.WHITE);
		btnFinancas.setForeground(Color.BLACK);
		btnFinancas.setBounds(100, 11, 250, 80);
		contentPane.add(btnFinancas);
		
		JButton btnTema = new JButton("Tema");
		btnTema.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 20));
		btnTema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTemaPrincipal telaTemaPrincipal = new TelaTemaPrincipal();
				telaTemaPrincipal.setVisible(true);
				dispose();
			}
		});
		btnTema.setBackground(Color.WHITE);
		btnTema.setForeground(Color.BLACK);
		btnTema.setBounds(100, 102, 250, 80);
		contentPane.add(btnTema);
		
		JButton btnFesta = new JButton("Festa");
		btnFesta.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 20));
		btnFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFestaPrincipal telaFestaPrincipal = new TelaFestaPrincipal();
				telaFestaPrincipal.setVisible(true);
				dispose();
			}
		});
		btnFesta.setBackground(Color.WHITE);
		btnFesta.setForeground(Color.BLACK);
		btnFesta.setBounds(100, 284, 250, 80);
		contentPane.add(btnFesta);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDashboard telaDashboard = new TelaDashboard();
				telaDashboard.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBackground(Color.RED);
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		btnVoltar.setBounds(184, 375, 89, 23);
		contentPane.add(btnVoltar);
	}

}
