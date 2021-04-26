package view.cliente;

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
import model.ClienteTableModel;
import persistence.ClienteDao;

public class TelaClienteDeletar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaClienteDeletar;
	private JButton btnDeletarCliente;
	private JButton btnVoltar;
	private JLabel lblEscolherCliente;
	private JTable tableListClientes;
	private JLabel lblDeletarCliente;
	private ClienteDao lista;

	public TelaClienteDeletar() {
		lista = new ClienteDao();
		ArquivosDiretorios arquivosDiretorios = new ArquivosDiretorios();
		try {
			lista = arquivosDiretorios.getClientes(lista);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		setTitle("Deletar Cliente");
		setResizable(false);
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(iconeRafaelaBuffet);
		setIconImage(iconeRafaelaBuffet);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1024, 720);
		telaClienteDeletar = new JPanel();
		telaClienteDeletar.setBackground(new Color(173, 220, 253));
		telaClienteDeletar.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaClienteDeletar);
		telaClienteDeletar.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(53, 65, 171));
		separator.setBounds(10, 11, 980, 2);
		telaClienteDeletar.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(53, 65, 171));
		separator_1.setBounds(10, 659, 980, 2);
		telaClienteDeletar.add(separator_1);

		lblDeletarCliente = new JLabel("Deletar Cliente");
		lblDeletarCliente.setForeground(new Color(53, 65, 171));
		lblDeletarCliente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
		lblDeletarCliente.setBounds(10, 11, 338, 69);
		telaClienteDeletar.add(lblDeletarCliente);

		btnVoltar = new JButton("< Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaClientePrincipal telaClientePrincipal = new TelaClientePrincipal();
				telaClientePrincipal.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnVoltar.setBackground(new Color(255, 102, 102));
		btnVoltar.setBounds(10, 625, 106, 23);
		telaClienteDeletar.add(btnVoltar);

		lblEscolherCliente = new JLabel("Selecione um cliente clicando na linha da coluna op\u00E7\u00F5es");
		lblEscolherCliente.setForeground(new Color(81, 107, 153));
		lblEscolherCliente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblEscolherCliente.setBounds(148, 72, 743, 24);
		telaClienteDeletar.add(lblEscolherCliente);

		tableListClientes = new JTable();
		tableListClientes.setLocation(20, 33);
		tableListClientes.setShowVerticalLines(false);
		tableListClientes.setRowHeight(32);
		ClienteTableModel clienteTableModel = new ClienteTableModel(lista);
		tableListClientes.setModel(clienteTableModel);
		JTableHeader th = tableListClientes.getTableHeader();
		th.setPreferredSize(new Dimension(100, 40));
		tableListClientes.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableListClientes.getColumnModel().getColumn(2).setPreferredWidth(180);
		tableListClientes.getColumnModel().getColumn(4).setPreferredWidth(30);
		tableListClientes.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
		telaClienteDeletar.add(tableListClientes);
		JScrollPane scroll = new JScrollPane(tableListClientes);
		scroll.setBounds(117, 109, 774, 497);
		telaClienteDeletar.add(scroll);

		btnDeletarCliente = new JButton("Deletar Cliente");
		btnDeletarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableListClientes.isColumnSelected(4)) {
					String s = tableListClientes.getValueAt(tableListClientes.getSelectedRow(), 0).toString();
					int id = Integer.parseInt(s);
					try {
						arquivosDiretorios.removerCliente(lista, id);
						if (lista.getCliente(0) == null) {
							TelaClienteDeletar telaClienteDeletar = new TelaClienteDeletar();
							telaClienteDeletar.setVisible(true);
							dispose();
						} else {
							clienteTableModel.addRow();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha na coluna opções", "Error", 0);
				}
			}
		});
		btnDeletarCliente.setBackground(new Color(60, 179, 113));
		btnDeletarCliente.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnDeletarCliente.setBounds(792, 625, 198, 23);
		telaClienteDeletar.add(btnDeletarCliente);
	}

}
