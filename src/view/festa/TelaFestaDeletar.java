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

public class TelaFestaDeletar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnDeletarFesta;
	private JButton btnVoltar;
	private JLabel lblEscolherFesta;
	private JTable tableListFestas;

	public TelaFestaDeletar()  {
		setTitle("Deletar Tema");
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
		separator_1.setBounds(10, 660, 980, 2);
		contentPane.add(separator_1);
		
		JLabel lblDeletarFesta = new JLabel("Deletar Festa");
		lblDeletarFesta.setForeground(new Color(53, 65, 171));
		lblDeletarFesta.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
		lblDeletarFesta.setBounds(10, 11, 338, 69);
		contentPane.add(lblDeletarFesta);
		
		btnDeletarFesta = new JButton("Deletar Festa");
		btnDeletarFesta.setBackground(new Color(60, 179, 113));
		btnDeletarFesta.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnDeletarFesta.setBounds(792, 626, 198, 23);
		contentPane.add(btnDeletarFesta);
		
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
		
		lblEscolherFesta = new JLabel("Festa a deletar");
		lblEscolherFesta.setForeground(new Color(81, 107, 153));
		lblEscolherFesta.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblEscolherFesta.setBounds(413, 72, 187, 24);
		contentPane.add(lblEscolherFesta);
		
		tableListFestas = new JTable();
		tableListFestas.setBounds(293, 107, 425, 510);
		contentPane.add(tableListFestas);
	}

}
