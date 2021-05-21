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

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
		setResizable(false);
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet  = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(iconeRafaelaBuffet);
		setIconImage(iconeRafaelaBuffet);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1366, 720);
		telaDashboard = new JPanel();
		telaDashboard.setBackground(new Color(173, 220, 253));
		telaDashboard.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaDashboard);
		telaDashboard.setLayout(null);

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
		btnMenuPrincipal.setBounds(1217, 555, 80, 80);
		telaDashboard.add(btnMenuPrincipal);

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
		telaDashboard.add(btnSair);

		lblProximasFestas = new JLabel("Pr\u00F3ximas Festas:");
		lblProximasFestas.setForeground(new Color(81, 107, 153));
		lblProximasFestas.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblProximasFestas.setBounds(10, 10, 213, 34);
		telaDashboard.add(lblProximasFestas);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(1092, 51, 205, 153);
		telaDashboard.add(calendar);
		
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
		telaDashboard.add(tableListFestas);
		JScrollPane scroll = new JScrollPane(tableListFestas);
		scroll.setBounds(10, 51, 1025, 584);
		telaDashboard.add(scroll);
	}
}
