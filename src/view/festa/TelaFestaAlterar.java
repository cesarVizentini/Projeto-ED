package view.festa;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import controller.ArquivosDiretorios;
import model.FestaTableModel;
import persistence.FestaDao;

public class TelaFestaAlterar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaFestaAlterar;
	private JButton btnAlterarFesta;
	private JButton btnVoltar;
	private JLabel lblEscolherFesta;
	private JTable tableListFestas;
	private FestaDao lista;
	private JButton btnSelecionarFesta;

	public TelaFestaAlterar() {
		lista = new FestaDao();
		ArquivosDiretorios arquivosDiretorios = new ArquivosDiretorios();
		try {
			lista = arquivosDiretorios.getFestas(lista);
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		setTitle("Alterar Tema");
		setResizable(false);
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet  = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(iconeRafaelaBuffet);
		setIconImage(iconeRafaelaBuffet);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1366, 720);
		telaFestaAlterar = new JPanel();
		telaFestaAlterar.setBackground(new Color(173, 220, 253));
		telaFestaAlterar.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaFestaAlterar);
		telaFestaAlterar.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(53, 65, 171));
		separator.setBounds(10, 11, 1306, 2);
		telaFestaAlterar.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(53, 65, 171));
		separator_1.setBounds(10, 666, 1306, 2);
		telaFestaAlterar.add(separator_1);
		
		JLabel lblAlterarFesta = new JLabel("Alterar Festa");
		lblAlterarFesta.setForeground(new Color(53, 65, 171));
		lblAlterarFesta.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
		lblAlterarFesta.setBounds(10, 11, 244, 36);
		telaFestaAlterar.add(lblAlterarFesta);
		
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
		btnVoltar.setBounds(10, 632, 106, 23);
		telaFestaAlterar.add(btnVoltar);
		
		lblEscolherFesta = new JLabel("Festa a alterar");
		lblEscolherFesta.setForeground(new Color(81, 107, 153));
		lblEscolherFesta.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblEscolherFesta.setBounds(10, 73, 224, 24);
		telaFestaAlterar.add(lblEscolherFesta);
		
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
		telaFestaAlterar.add(tableListFestas);
		JScrollPane scroll = new JScrollPane(tableListFestas);
		scroll.setBounds(10, 105, 915, 497);
		telaFestaAlterar.add(scroll);
		
		btnSelecionarFesta = new JButton("Selecionar Cliente");
		btnSelecionarFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableListFestas.isColumnSelected(4)) {
//					String s = tableListClientes.getValueAt(tableListClientes.getSelectedRow(), 0).toString();
//					int id = Integer.parseInt(s);
//					try {
//						arquivosDiretorios.removerCliente(lista, id);
//						if (lista.getCliente(0) == null) {
//							TelaClienteDeletar telaClienteDeletar = new TelaClienteDeletar();
//							telaClienteDeletar.setVisible(true);
//							dispose();
//						} else {
//							temaTableModel.addRow();
//						}
//					} catch (IOException e1) {
//						e1.printStackTrace();
//					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha na coluna opções", "Error", 0);
				}
			}
		});
		btnSelecionarFesta.setBackground(new Color(51, 153, 255));
		btnSelecionarFesta.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnSelecionarFesta.setBounds(727, 632, 198, 23);
		telaFestaAlterar.add(btnSelecionarFesta);
		
		btnAlterarFesta = new JButton("Alterar Festa");
		btnAlterarFesta.setBackground(new Color(60, 179, 113));
		btnAlterarFesta.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnAlterarFesta.setBounds(1118, 632, 198, 23);
		telaFestaAlterar.add(btnAlterarFesta);
	}

}
