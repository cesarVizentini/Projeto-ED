package view.tema;

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
import model.TemaTableModel;
import persistence.TemaDao;
import view.cliente.TelaClienteDeletar;

public class TelaTemaDeletar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaTemaDeletar;
	private JButton btnDeletarTema;
	private JButton btnVoltar;
	private JLabel lblDeletarTema;
	private JLabel lblEscolherTema;
	private JTable tableListTemas;
	private TemaDao lista;

	public TelaTemaDeletar()  {
		lista = new TemaDao();
		ArquivosDiretorios arquivosDiretorios = new ArquivosDiretorios();
		try {
			lista = arquivosDiretorios.getTemas(lista);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		setTitle("Deletar Tema");
		setResizable(false);
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet  = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(iconeRafaelaBuffet);
		setIconImage(iconeRafaelaBuffet);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1366, 720);
		telaTemaDeletar = new JPanel();
		telaTemaDeletar.setBackground(new Color(173, 220, 253));
		telaTemaDeletar.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaTemaDeletar);
		telaTemaDeletar.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(53, 65, 171));
		separator.setBounds(10, 11, 1306, 2);
		telaTemaDeletar.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(53, 65, 171));
		separator_1.setBounds(10, 659, 1306, 2);
		telaTemaDeletar.add(separator_1);
		
		lblDeletarTema = new JLabel("Deletar Tema");
		lblDeletarTema.setForeground(new Color(53, 65, 171));
		lblDeletarTema.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
		lblDeletarTema.setBounds(10, 11, 222, 36);
		telaTemaDeletar.add(lblDeletarTema);
		
		btnVoltar = new JButton("< Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTemaPrincipal telaTemaPrincipal = new TelaTemaPrincipal();
				telaTemaPrincipal.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnVoltar.setBackground(new Color(255, 102, 102));
		btnVoltar.setBounds(10, 631, 106, 23);
		telaTemaDeletar.add(btnVoltar);
		
		lblEscolherTema = new JLabel("Selecione um tema clicando na linha da coluna op\u00E7\u00F5es");
		lblEscolherTema.setForeground(new Color(81, 107, 153));
		lblEscolherTema.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblEscolherTema.setBounds(359, 74, 634, 24);
		telaTemaDeletar.add(lblEscolherTema);
		
		tableListTemas = new JTable();
		tableListTemas.setLocation(20, 33);
		tableListTemas.setShowVerticalLines(false);
		tableListTemas.setRowHeight(32);
		TemaTableModel temaTableModel = new TemaTableModel(lista);
		tableListTemas.setModel(temaTableModel);
		JTableHeader th = tableListTemas.getTableHeader();
		th.setPreferredSize(new Dimension(100, 40));
		tableListTemas.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableListTemas.getColumnModel().getColumn(1).setPreferredWidth(120);
		tableListTemas.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableListTemas.getColumnModel().getColumn(4).setPreferredWidth(20);
		tableListTemas.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
		telaTemaDeletar.add(tableListTemas);
		JScrollPane scroll = new JScrollPane(tableListTemas);
		scroll.setBounds(175, 109, 1002, 497);
		telaTemaDeletar.add(scroll);
		
		btnDeletarTema = new JButton("Deletar Tema");
		btnDeletarTema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableListTemas.isColumnSelected(4)) {
					String s = tableListTemas.getValueAt(tableListTemas.getSelectedRow(), 0).toString();
					int id = Integer.parseInt(s);
					try {
						arquivosDiretorios.removerTema(lista, id);
						if (lista.getTema(0) == null) {
							TelaClienteDeletar telaClienteDeletar = new TelaClienteDeletar();
							telaClienteDeletar.setVisible(true);
							dispose();
						} else {
							temaTableModel.addRow();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha na coluna opções", "Error", 0);
				}
			}
		});
		btnDeletarTema.setBackground(new Color(60, 179, 113));
		btnDeletarTema.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnDeletarTema.setBounds(1118, 625, 198, 23);
		telaTemaDeletar.add(btnDeletarTema);
	}

}
