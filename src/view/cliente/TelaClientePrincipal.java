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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import controller.ArquivosDiretorios;
import model.ClienteTableModel;
import persistence.ClienteDao;
import view.TelaMenuPrincipal;

public class TelaClientePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaClientePrincipal;
	private JTable tableListClientes;
	private ClienteDao lista;

	public TelaClientePrincipal() {
		lista = new ClienteDao();
		ArquivosDiretorios arquivosDiretorios = new ArquivosDiretorios();
		try {
			lista = arquivosDiretorios.getClientes(lista);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		setTitle("Cliente Principal");
		setResizable(false);
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(iconeRafaelaBuffet);
		setIconImage(iconeRafaelaBuffet);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1024, 720);
		telaClientePrincipal = new JPanel();
		telaClientePrincipal.setBackground(new Color(173, 220, 253));
		telaClientePrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaClientePrincipal);
		telaClientePrincipal.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuPrincipal telaMenuPrincipal = new TelaMenuPrincipal();
				telaMenuPrincipal.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBackground(Color.RED);
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		btnVoltar.setBounds(10, 617, 89, 23);
		telaClientePrincipal.add(btnVoltar);

		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.setBackground(Color.WHITE);
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaClienteCadastrar telaClienteCadastrar = new TelaClienteCadastrar();
				telaClienteCadastrar.setVisible(true);
				dispose();
			}
		});
		btnCadastrarCliente.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnCadastrarCliente.setBounds(780, 11, 208, 50);
		telaClientePrincipal.add(btnCadastrarCliente);

		JButton btnAlterarCliente = new JButton("Alterar Cliente");
		btnAlterarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaClienteAlterar telaClienteAlterar = new TelaClienteAlterar();
				telaClienteAlterar.setVisible(true);
				dispose();
			}
		});
		btnAlterarCliente.setBackground(Color.WHITE);
		btnAlterarCliente.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnAlterarCliente.setBounds(780, 73, 208, 50);
		telaClientePrincipal.add(btnAlterarCliente);

		JButton btnDeletarCliente = new JButton("Deletar Cliente");
		btnDeletarCliente.setBackground(Color.WHITE);
		btnDeletarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaClienteDeletar telaClienteDeletar = new TelaClienteDeletar();
				telaClienteDeletar.setVisible(true);
				dispose();
			}
		});
		btnDeletarCliente.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnDeletarCliente.setBounds(780, 135, 208, 50);
		telaClientePrincipal.add(btnDeletarCliente);
		
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
		telaClientePrincipal.add(tableListClientes);
		JScrollPane scroll = new JScrollPane(tableListClientes);
		scroll.setBounds(10, 11, 760, 595);
		telaClientePrincipal.add(scroll);
	}
}
