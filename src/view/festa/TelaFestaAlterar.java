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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class TelaFestaAlterar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAlterarFesta;
	private JButton btnVoltar;
	private JLabel lblEscolherFesta;
	private JTable tableListFestas;

	public TelaFestaAlterar() {
		setTitle("Alterar Tema");
		setResizable(false);
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet  = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(iconeRafaelaBuffet);
		setIconImage(iconeRafaelaBuffet);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1024, 720);;
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
		separator_1.setBounds(10, 660, 980, 2);
		contentPane.add(separator_1);
		
		JLabel lblAlterarFesta = new JLabel("Alterar Festa");
		lblAlterarFesta.setForeground(new Color(53, 65, 171));
		lblAlterarFesta.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
		lblAlterarFesta.setBounds(10, 11, 244, 36);
		contentPane.add(lblAlterarFesta);
		
		btnAlterarFesta = new JButton("Alterar Festa");
		btnAlterarFesta.setBackground(new Color(60, 179, 113));
		btnAlterarFesta.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnAlterarFesta.setBounds(792, 626, 198, 23);
		contentPane.add(btnAlterarFesta);
		
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
		btnVoltar.setBounds(10, 626, 106, 23);
		contentPane.add(btnVoltar);
		
		lblEscolherFesta = new JLabel("Festa a alterar");
		lblEscolherFesta.setForeground(new Color(81, 107, 153));
		lblEscolherFesta.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblEscolherFesta.setBounds(10, 91, 187, 24);
		contentPane.add(lblEscolherFesta);
		
		tableListFestas = new JTable();
		tableListFestas.setBounds(10, 125, 425, 480);
		contentPane.add(tableListFestas);
		
	}

}
