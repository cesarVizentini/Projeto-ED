package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class TelaDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblProximasFestas;
	private JTable tableListFestas;

	public TelaDashboard() {
		setTitle("Dashboard");
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

		JButton btnMenuPrincipal = new JButton("+");
		btnMenuPrincipal.setVerticalAlignment(SwingConstants.TOP);
		btnMenuPrincipal.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 48));
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuPrincipal telaMenuPrincipal = new TelaMenuPrincipal();
				telaMenuPrincipal.setVisible(true);
				dispose();
			}
		});
		btnMenuPrincipal.setBounds(915, 585, 80, 80);
		contentPane.add(btnMenuPrincipal);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBackground(Color.RED);
		btnSair.setForeground(Color.BLACK);
		btnSair.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		btnSair.setBounds(10, 646, 89, 23);
		contentPane.add(btnSair);

		lblProximasFestas = new JLabel("Pr\u00F3ximas Festas:");
		lblProximasFestas.setForeground(new Color(81, 107, 153));
		lblProximasFestas.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblProximasFestas.setBounds(10, 10, 213, 34);
		contentPane.add(lblProximasFestas);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(790, 10, 205, 153);
		contentPane.add(calendar);
		
		tableListFestas = new JTable();
		tableListFestas.setBounds(10, 45, 760, 590);
		contentPane.add(tableListFestas);
		
	}
}
