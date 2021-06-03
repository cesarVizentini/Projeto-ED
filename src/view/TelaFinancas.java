package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import com.toedter.calendar.JDateChooser;
import controller.ArquivosDiretorios;
import model.FestaTableModel;
import persistence.FestaDao;
import persistence.FinancasDao;

public class TelaFinancas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaFinancas;
	private JLabel lblDataInicial;
	private JLabel lblDataFinal;
	private JLabel lblLucro;
	private JTextField tfLucro;
	private JButton btnCalcular;
	private JLabel lblEscolherData;
	private JTable tableListFestas;
	private static FestaDao lista;
	private JPanel sideMenu;
	private JButton btnSMHome;
	private JButton btnSMCliente;
	private JButton btnSMTema;
	private JButton btnSMFesta;
	private JButton btnSMFinancas;
	private JLabel SDLogo;
	private JLabel lblEspaco1;
	private JLabel lblEspaco2;
	private JLabel lblEspaco3;
	private JLabel lblEspaco4;
	
	public static FestaDao getLista() {
		return lista;
	}
	
	private void pegarResolucao() {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension dimensao = t.getScreenSize();
		int larg = dimensao.width;
		int alt = dimensao.height;
		setBounds(0, 0, larg, alt);
	}

	public TelaFinancas() {
		lista = new FestaDao();
		ArquivosDiretorios arquivosDiretorios = new ArquivosDiretorios();
		try {
			lista = arquivosDiretorios.getFestas(lista);
			if (lista != null) {
				lista.sort();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		setTitle("Finanças");
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet  = Toolkit.getDefaultToolkit().getImage(url);
		setIconImage(iconeRafaelaBuffet);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pegarResolucao();
		telaFinancas = new JPanel();
		telaFinancas.setBackground(new Color(135, 206, 235));
		telaFinancas.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaFinancas);
		telaFinancas.setLayout(null);
		
		// INICIO SIDE-MENU
		sideMenu = new JPanel();
		sideMenu.setBackground(new Color(173, 220, 253));
		sideMenu.setBounds(0, 0, 240, 861);
		telaFinancas.add(sideMenu);
		sideMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		SDLogo = new JLabel("");
		SDLogo.setIcon(new ImageIcon(TelaFinancas.class.getResource("/view/assets/SDLogo.png")));
		SDLogo.setPreferredSize(new Dimension(240, 250));
		sideMenu.add(SDLogo);

		btnSMHome = new JButton("Home");
		btnSMHome.setPressedIcon(new ImageIcon(TelaFinancas.class.getResource("/view/assets/pressed.png")));
		btnSMHome.setSelectedIcon(new ImageIcon(TelaFinancas.class.getResource("/view/assets/selected.png")));
		btnSMHome.setRolloverIcon(new ImageIcon(TelaFinancas.class.getResource("/view/assets/hover.png")));
		btnSMHome.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMHome.setIcon(new ImageIcon(TelaFinancas.class.getResource("/view/assets/default.png")));
		btnSMHome.setBackground(new Color(255, 255, 255));
		btnSMHome.setPreferredSize(new Dimension(220, 40));
		btnSMHome.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		btnSMHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDashboard telaDashboard = new TelaDashboard();
				telaDashboard.setVisible(true);
				btnSMHome.setSelected(true);
				dispose();
			}
		});
		sideMenu.add(btnSMHome);

		lblEspaco1 = new JLabel("");
		lblEspaco1.setPreferredSize(new Dimension(20, 20));
		sideMenu.add(lblEspaco1);

		btnSMTema = new JButton("Tema");
		btnSMTema.setPressedIcon(new ImageIcon(TelaFinancas.class.getResource("/view/assets/pressed.png")));
		btnSMTema.setIcon(new ImageIcon(TelaFinancas.class.getResource("/view/assets/default.png")));
		btnSMTema.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMTema.setRolloverIcon(new ImageIcon(TelaFinancas.class.getResource("/view/assets/hover.png")));
		btnSMTema.setSelectedIcon(new ImageIcon(TelaFinancas.class.getResource("/view/assets/selected.png")));
		btnSMTema.setBackground(new Color(255, 255, 255));
		btnSMTema.setPreferredSize(new Dimension(220, 40));
		btnSMTema.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		btnSMTema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTema telaTema = new TelaTema();
				telaTema.setVisible(true);
				btnSMTema.setSelected(true);
				dispose();
			}
		});
		sideMenu.add(btnSMTema);

		lblEspaco2 = new JLabel("");
		lblEspaco2.setPreferredSize(new Dimension(20, 20));
		sideMenu.add(lblEspaco2);

		btnSMCliente = new JButton("Cliente");
		btnSMCliente.setPressedIcon(new ImageIcon(TelaFinancas.class.getResource("/view/assets/pressed.png")));
		btnSMCliente.setIcon(new ImageIcon(TelaFinancas.class.getResource("/view/assets/default.png")));
		btnSMCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMCliente.setRolloverIcon(new ImageIcon(TelaFinancas.class.getResource("/view/assets/hover.png")));
		btnSMCliente.setSelectedIcon(new ImageIcon(TelaFinancas.class.getResource("/view/assets/selected.png")));
		btnSMCliente.setBackground(new Color(255, 255, 255));
		btnSMCliente.setPreferredSize(new Dimension(220, 40));
		btnSMCliente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		btnSMCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCliente telaCliente = new TelaCliente();
				telaCliente.setVisible(true);
				btnSMCliente.setSelected(true);
				dispose();
			}
		});
		sideMenu.add(btnSMCliente);

		lblEspaco3 = new JLabel("");
		lblEspaco3.setPreferredSize(new Dimension(20, 20));
		sideMenu.add(lblEspaco3);

		btnSMFesta = new JButton("Festa");
		btnSMFesta.setPressedIcon(new ImageIcon(TelaFinancas.class.getResource("/view/assets/pressed.png")));
		btnSMFesta.setIcon(new ImageIcon(TelaFinancas.class.getResource("/view/assets/default.png")));
		btnSMFesta.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMFesta.setRolloverIcon(new ImageIcon(TelaFinancas.class.getResource("/view/assets/hover.png")));
		btnSMFesta.setSelectedIcon(new ImageIcon(TelaFinancas.class.getResource("/view/assets/selected.png")));
		btnSMFesta.setBackground(new Color(255, 255, 255));
		btnSMFesta.setPreferredSize(new Dimension(220, 40));
		btnSMFesta.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		btnSMFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFesta telaFesta = new TelaFesta();
				telaFesta.setVisible(true);
				btnSMFesta.setSelected(true);
				dispose();
			}
		});
		sideMenu.add(btnSMFesta);

		lblEspaco4 = new JLabel("");
		lblEspaco4.setPreferredSize(new Dimension(20, 20));
		sideMenu.add(lblEspaco4);

		btnSMFinancas = new JButton("Finanças");
		btnSMFinancas.setPressedIcon(new ImageIcon(TelaFinancas.class.getResource("/view/assets/pressed.png")));
		btnSMFinancas.setIcon(new ImageIcon(TelaFinancas.class.getResource("/view/assets/default.png")));
		btnSMFinancas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMFinancas.setRolloverIcon(new ImageIcon(TelaFinancas.class.getResource("/view/assets/hover.png")));
		btnSMFinancas.setSelectedIcon(new ImageIcon(TelaFinancas.class.getResource("/view/assets/selected.png")));
		btnSMFinancas.setBackground(new Color(255, 255, 255));
		btnSMFinancas.setPreferredSize(new Dimension(220, 40));
		btnSMFinancas.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		btnSMFinancas.setSelected(true);
		sideMenu.add(btnSMFinancas);
		// FIM SIDE-MENU
		
		// INICIO TABLE
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
					setBackground(new Color(210, 228, 240));
					setForeground(Color.BLACK);
				} else {
					setBackground(new Color(181, 212, 230));
					setForeground(Color.BLACK);
				}
				return this;
			}
		});
		telaFinancas.add(tableListFestas);
		JScrollPane scroll = new JScrollPane(tableListFestas);
		scroll.setBounds(268, 11, 1141, 464);
		telaFinancas.add(scroll);
		// FIM TABLE
		
		// INICIO FORMULARIO
		JLabel lblFinancas = new JLabel("Finanças");
		lblFinancas.setForeground(new Color(53, 65, 171));
		lblFinancas.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
		lblFinancas.setBounds(268, 486, 160, 44);
		telaFinancas.add(lblFinancas);
		
		lblEscolherData = new JLabel("Escolha as datas e veja o lucro");
		lblEscolherData.setForeground(new Color(81, 107, 153));
		lblEscolherData.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
		lblEscolherData.setBounds(268, 535, 289, 24);
		telaFinancas.add(lblEscolherData);
		
		lblDataInicial = new JLabel("Data Inicial");
		lblDataInicial.setForeground(new Color(81, 107, 153));
		lblDataInicial.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblDataInicial.setBounds(268, 570, 106, 24);
		telaFinancas.add(lblDataInicial);
		
		JDateChooser dateChooserDataInicial = new JDateChooser();
		dateChooserDataInicial.getCalendarButton().setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		dateChooserDataInicial.setBounds(268, 601, 150, 20);
		telaFinancas.add(dateChooserDataInicial);
		
		lblDataFinal = new JLabel("Data Final");
		lblDataFinal.setForeground(new Color(81, 107, 153));
		lblDataFinal.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblDataFinal.setBounds(436, 567, 86, 30);
		telaFinancas.add(lblDataFinal);
		
		JDateChooser dateChooserDataFinal = new JDateChooser();
		dateChooserDataFinal.getCalendarButton().setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		dateChooserDataFinal.setBounds(436, 601, 150, 20);
		telaFinancas.add(dateChooserDataFinal);
		
		lblLucro = new JLabel("Seu lucro no per\u00EDodo escohido foi de:");
		lblLucro.setForeground(new Color(81, 107, 153));
		lblLucro.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		lblLucro.setBounds(268, 674, 314, 44);
		telaFinancas.add(lblLucro);
		
		JLabel lblR$ = new JLabel("R$");
		lblR$.setForeground(new Color(81, 107, 153));
		lblR$.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
		lblR$.setBounds(268, 729, 29, 44);
		telaFinancas.add(lblR$);
		
		tfLucro = new JTextField();
		tfLucro.setEditable(false);
		tfLucro.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		tfLucro.setBounds(293, 737, 96, 30);
		tfLucro.setColumns(10);
		telaFinancas.add(tfLucro);
		// FIM FORMULARIO
		
		// INICIO BOTOES
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FinancasDao financasDao = new FinancasDao();
				Date dataInicial = dateChooserDataInicial.getDate();
				Date dataFinal = dateChooserDataFinal.getDate();
				tfLucro.setText(financasDao.calculaFinancas(dataInicial, dataFinal));
			}
		});
		btnCalcular.setBackground(new Color(60, 179, 113));
		btnCalcular.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnCalcular.setBounds(330, 640, 198, 23);
		telaFinancas.add(btnCalcular);
		// FIM BOTOES
	}
}