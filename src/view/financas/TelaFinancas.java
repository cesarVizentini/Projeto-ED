package view.financas;

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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

import view.TelaMenuPrincipal;

public class TelaFinancas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblDataInicial;
	private JLabel lblDataFinal;
	private JLabel lblLucro;
	private JTextField tfLucro;
	private JButton btnCalcular;
	private JButton btnVoltar;
	private JLabel lblEscolherData;
	private JTable tableListFestas;

	public TelaFinancas() {
		setTitle("Finanças");
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
		separator_1.setBounds(10, 667, 980, 2);
		contentPane.add(separator_1);
		
		JLabel lblFinancas = new JLabel("Finanças");
		lblFinancas.setForeground(new Color(53, 65, 171));
		lblFinancas.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
		lblFinancas.setBounds(672, 24, 289, 44);
		contentPane.add(lblFinancas);
		
		lblEscolherData = new JLabel("Escolha as datas e veja o lucro");
		lblEscolherData.setForeground(new Color(81, 107, 153));
		lblEscolherData.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
		lblEscolherData.setBounds(672, 73, 289, 24);
		contentPane.add(lblEscolherData);
		
		lblDataInicial = new JLabel("Data Inicial");
		lblDataInicial.setForeground(new Color(81, 107, 153));
		lblDataInicial.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblDataInicial.setBounds(672, 108, 106, 24);
		contentPane.add(lblDataInicial);
		
		JDateChooser dateChooserDataInicial = new JDateChooser();
		dateChooserDataInicial.getCalendarButton().setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		dateChooserDataInicial.setBounds(672, 139, 150, 20);
		contentPane.add(dateChooserDataInicial);
		
		lblDataFinal = new JLabel("Data Final");
		lblDataFinal.setForeground(new Color(81, 107, 153));
		lblDataFinal.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblDataFinal.setBounds(840, 105, 86, 30);
		contentPane.add(lblDataFinal);
		
		JDateChooser dateChooserDataFinal = new JDateChooser();
		dateChooserDataFinal.getCalendarButton().setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		dateChooserDataFinal.setBounds(840, 139, 150, 20);
		contentPane.add(dateChooserDataFinal);
		
		lblLucro = new JLabel("Seu lucro no per\u00EDodo escohido foi de:");
		lblLucro.setForeground(new Color(81, 107, 153));
		lblLucro.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		lblLucro.setBounds(672, 212, 314, 44);
		contentPane.add(lblLucro);
		
		JLabel lblR$ = new JLabel("R$");
		lblR$.setForeground(new Color(81, 107, 153));
		lblR$.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
		lblR$.setBounds(672, 267, 29, 44);
		contentPane.add(lblR$);
		
		tfLucro = new JTextField();
		tfLucro.setEditable(false);
		tfLucro.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		tfLucro.setBounds(697, 275, 96, 30);
		tfLucro.setColumns(10);
		contentPane.add(tfLucro);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBackground(new Color(60, 179, 113));
		btnCalcular.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnCalcular.setBounds(734, 178, 198, 23);
		contentPane.add(btnCalcular);
		
		btnVoltar = new JButton("< Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuPrincipal telaMenuPrincipal = new TelaMenuPrincipal();
				telaMenuPrincipal.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnVoltar.setBackground(new Color(255, 102, 102));
		btnVoltar.setBounds(10, 633, 106, 23);
		contentPane.add(btnVoltar);
		
		tableListFestas = new JTable();
		tableListFestas.setBounds(10, 24, 629, 599);
		contentPane.add(tableListFestas);
	}
}
