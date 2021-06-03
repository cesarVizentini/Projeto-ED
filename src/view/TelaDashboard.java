package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JCalendar;

import controller.ArquivosDiretorios;
import model.FestaTableModel;
import persistence.FestaDao;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class TelaDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaDashboard;
	private JLabel lblProximasFestas;
	private JTable tableListFestas;
	private FestaDao lista;
	private JPanel sideMenu;
	private JLabel SDLogo;
	private JButton btnSMHome;
	private JLabel lblEspaco1;
	private JButton btnSMTema;
	private JLabel lblEspaco2;
	private JButton btnSMCliente;
	private JLabel lblEspaco3;
	private JButton btnSMFesta;
	private JLabel lblEspaco4;
	private JButton btnSMFinancas;

	private void pegarResolucao() {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension dimensao = t.getScreenSize();
		int larg = dimensao.width;
		int alt = dimensao.height;
		setBounds(0, 0, larg, alt);
	}

	public TelaDashboard() {
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

		setTitle("Dashboard");
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet = Toolkit.getDefaultToolkit().getImage(url);
		setIconImage(iconeRafaelaBuffet);
        setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pegarResolucao();
		telaDashboard = new JPanel();
		telaDashboard.setBackground(new Color(135, 206, 235));
		telaDashboard.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaDashboard);
		telaDashboard.setLayout(null);

		// INICIO SIDE-MENU
		sideMenu = new JPanel();
		sideMenu.setBackground(new Color(173, 220, 253));
		sideMenu.setBounds(0, 0, 240, 861);
		telaDashboard.add(sideMenu);
		sideMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		SDLogo = new JLabel("");
		SDLogo.setIcon(new ImageIcon(TelaDashboard.class.getResource("/view/assets/SDLogo.png")));
		SDLogo.setPreferredSize(new Dimension(240, 250));
		sideMenu.add(SDLogo);

		btnSMHome = new JButton("Home");
		btnSMHome.setPressedIcon(new ImageIcon(TelaDashboard.class.getResource("/view/assets/pressed.png")));
		btnSMHome.setSelectedIcon(new ImageIcon(TelaDashboard.class.getResource("/view/assets/selected.png")));
		btnSMHome.setRolloverIcon(new ImageIcon(TelaDashboard.class.getResource("/view/assets/hover.png")));
		btnSMHome.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMHome.setIcon(new ImageIcon(TelaDashboard.class.getResource("/view/assets/default.png")));
		btnSMHome.setBackground(new Color(255, 255, 255));
		btnSMHome.setPreferredSize(new Dimension(220, 40));
		btnSMHome.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		btnSMHome.setSelected(true);
		sideMenu.add(btnSMHome);

		lblEspaco1 = new JLabel("");
		lblEspaco1.setPreferredSize(new Dimension(20, 20));
		sideMenu.add(lblEspaco1);

		btnSMTema = new JButton("Tema");
		btnSMTema.setPressedIcon(new ImageIcon(TelaDashboard.class.getResource("/view/assets/pressed.png")));
		btnSMTema.setIcon(new ImageIcon(TelaDashboard.class.getResource("/view/assets/default.png")));
		btnSMTema.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMTema.setRolloverIcon(new ImageIcon(TelaDashboard.class.getResource("/view/assets/hover.png")));
		btnSMTema.setSelectedIcon(new ImageIcon(TelaDashboard.class.getResource("/view/assets/selected.png")));
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
		btnSMCliente.setPressedIcon(new ImageIcon(TelaDashboard.class.getResource("/view/assets/pressed.png")));
		btnSMCliente.setIcon(new ImageIcon(TelaDashboard.class.getResource("/view/assets/default.png")));
		btnSMCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMCliente.setRolloverIcon(new ImageIcon(TelaDashboard.class.getResource("/view/assets/hover.png")));
		btnSMCliente.setSelectedIcon(new ImageIcon(TelaDashboard.class.getResource("/view/assets/selected.png")));
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
		btnSMFesta.setPressedIcon(new ImageIcon(TelaDashboard.class.getResource("/view/assets/pressed.png")));
		btnSMFesta.setIcon(new ImageIcon(TelaDashboard.class.getResource("/view/assets/default.png")));
		btnSMFesta.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMFesta.setRolloverIcon(new ImageIcon(TelaDashboard.class.getResource("/view/assets/hover.png")));
		btnSMFesta.setSelectedIcon(new ImageIcon(TelaDashboard.class.getResource("/view/assets/selected.png")));
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
		btnSMFinancas.setPressedIcon(new ImageIcon(TelaDashboard.class.getResource("/view/assets/pressed.png")));
		btnSMFinancas.setIcon(new ImageIcon(TelaDashboard.class.getResource("/view/assets/default.png")));
		btnSMFinancas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMFinancas.setRolloverIcon(new ImageIcon(TelaDashboard.class.getResource("/view/assets/hover.png")));
		btnSMFinancas.setSelectedIcon(new ImageIcon(TelaDashboard.class.getResource("/view/assets/selected.png")));
		btnSMFinancas.setBackground(new Color(255, 255, 255));
		btnSMFinancas.setPreferredSize(new Dimension(220, 40));
		btnSMFinancas.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		btnSMFinancas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFinancas telaFinancas = new TelaFinancas();
				telaFinancas.setVisible(true);
				btnSMFinancas.setSelected(true);
				dispose();
			}
		});
		sideMenu.add(btnSMFinancas);
		// FIM SIDE-MENU

		// INICIO TABELA
		lblProximasFestas = new JLabel("Pr\u00F3ximas Festas:");
		lblProximasFestas.setForeground(new Color(81, 107, 153));
		lblProximasFestas.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblProximasFestas.setBounds(266, 11, 213, 34);
		telaDashboard.add(lblProximasFestas);

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
		telaDashboard.add(tableListFestas);
		JScrollPane scroll = new JScrollPane(tableListFestas);
		scroll.setBounds(263, 56, 1121, 595);
		telaDashboard.add(scroll);
		// FIM TABELA

		// INICIO CALENDARIO
		JCalendar calendar = new JCalendar();
		calendar.setBounds(1179, 662, 205, 124);
		telaDashboard.add(calendar);
		// FIM CALENDARIO
	}
}
