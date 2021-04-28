package view.financas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import controller.ArquivosDiretorios;
import model.FestaTableModel;
import persistence.FestaDao;
import view.TelaMenuPrincipal;

public class TelaFinancas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaFinancas;
	private JLabel lblDataInicial;
	private JLabel lblDataFinal;
	private JLabel lblLucro;
	private JTextField tfLucro;
	private JButton btnCalcular;
	private JButton btnVoltar;
	private JLabel lblEscolherData;
	private JTable tableListFestas;
	private FestaDao lista;

	public TelaFinancas() {
		lista = new FestaDao();
		ArquivosDiretorios arquivosDiretorios = new ArquivosDiretorios();
		try {
			lista = arquivosDiretorios.getFestas(lista);
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		setTitle("Finanças");
		setResizable(false);
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet  = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(iconeRafaelaBuffet);
		setIconImage(iconeRafaelaBuffet);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1366, 720);
		telaFinancas = new JPanel();
		telaFinancas.setBackground(new Color(173, 220, 253));
		telaFinancas.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaFinancas);
		telaFinancas.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(53, 65, 171));
		separator.setBounds(10, 11, 1312, 2);
		telaFinancas.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(53, 65, 171));
		separator_1.setBounds(10, 667, 1312, 2);
		telaFinancas.add(separator_1);
		
		JLabel lblFinancas = new JLabel("Finanças");
		lblFinancas.setForeground(new Color(53, 65, 171));
		lblFinancas.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
		lblFinancas.setBounds(1102, 24, 160, 44);
		telaFinancas.add(lblFinancas);
		
		lblEscolherData = new JLabel("Escolha as datas e veja o lucro");
		lblEscolherData.setForeground(new Color(81, 107, 153));
		lblEscolherData.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
		lblEscolherData.setBounds(994, 73, 289, 24);
		telaFinancas.add(lblEscolherData);
		
		lblDataInicial = new JLabel("Data Inicial");
		lblDataInicial.setForeground(new Color(81, 107, 153));
		lblDataInicial.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblDataInicial.setBounds(994, 108, 106, 24);
		telaFinancas.add(lblDataInicial);
		
		JDateChooser dateChooserDataInicial = new JDateChooser();
		dateChooserDataInicial.getCalendarButton().setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		dateChooserDataInicial.setBounds(994, 139, 150, 20);
		telaFinancas.add(dateChooserDataInicial);
		
		lblDataFinal = new JLabel("Data Final");
		lblDataFinal.setForeground(new Color(81, 107, 153));
		lblDataFinal.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblDataFinal.setBounds(1162, 105, 86, 30);
		telaFinancas.add(lblDataFinal);
		
		JDateChooser dateChooserDataFinal = new JDateChooser();
		dateChooserDataFinal.getCalendarButton().setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		dateChooserDataFinal.setBounds(1162, 139, 150, 20);
		telaFinancas.add(dateChooserDataFinal);
		
		lblLucro = new JLabel("Seu lucro no per\u00EDodo escohido foi de:");
		lblLucro.setForeground(new Color(81, 107, 153));
		lblLucro.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		lblLucro.setBounds(994, 212, 314, 44);
		telaFinancas.add(lblLucro);
		
		JLabel lblR$ = new JLabel("R$");
		lblR$.setForeground(new Color(81, 107, 153));
		lblR$.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
		lblR$.setBounds(994, 267, 29, 44);
		telaFinancas.add(lblR$);
		
		tfLucro = new JTextField();
		tfLucro.setEditable(false);
		tfLucro.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		tfLucro.setBounds(1019, 275, 96, 30);
		tfLucro.setColumns(10);
		telaFinancas.add(tfLucro);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBackground(new Color(60, 179, 113));
		btnCalcular.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnCalcular.setBounds(1056, 178, 198, 23);
		telaFinancas.add(btnCalcular);
		
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
		telaFinancas.add(btnVoltar);
		
		tableListFestas = new JTable();
		tableListFestas.setLocation(20, 33);
		tableListFestas.setShowVerticalLines(false);
		tableListFestas.setRowHeight(32);
		FestaTableModel festaTableModel = new FestaTableModel(lista);
		tableListFestas.setModel(festaTableModel);
		JTableHeader th = tableListFestas.getTableHeader();
		th.setPreferredSize(new Dimension(100, 40));
		tableListFestas.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableListFestas.getColumnModel().getColumn(1).setPreferredWidth(120);
		tableListFestas.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableListFestas.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				if (row % 2 == 0) {
					setBackground(Color.LIGHT_GRAY);
					setForeground(Color.BLACK);
				} else {
					setBackground(Color.WHITE);
					setForeground(Color.BLACK);
				}
				return this;
			}
		});
		telaFinancas.add(tableListFestas);
		JScrollPane scroll = new JScrollPane(tableListFestas);
		scroll.setBounds(10, 24, 950, 584);
		telaFinancas.add(scroll);
	}
}
