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
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.text.MaskFormatter;

import controller.ArquivosDiretorios;
import controller.ClienteController;
import model.Cliente;
import model.ClienteTableModel;
import persistence.ClienteDao;

import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;

public class TelaClienteAlterar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaClienteAlterar;
	private JLabel lblNome;
	private JTextField tfNome;
	private JLabel lblTelefone;
	private JLabel lblDocumentoCPF;
	private JButton btnAlterarCliente;
	private JButton btnVoltar;
	private JLabel lblEscolherCliente;
	private JFormattedTextField jftfTelefone;
	private JFormattedTextField jftfDocumentoCPF;
	private JTable tableListClientes;
	private JLabel lblAlterarCliente;
	private ClienteDao lista;
	private JButton btnSelecionarCliente;
	public String nome;
	public String CPF;
	public String telefone;

	public TelaClienteAlterar() {
		lista = new ClienteDao();
		ArquivosDiretorios arquivosDiretorios = new ArquivosDiretorios();
		try {
			lista = arquivosDiretorios.getClientes(lista);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		setTitle("Alterar Cliente");
		setResizable(false);
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(iconeRafaelaBuffet);
		setIconImage(iconeRafaelaBuffet);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1366, 720);
		telaClienteAlterar = new JPanel();
		telaClienteAlterar.setBackground(new Color(173, 220, 253));
		telaClienteAlterar.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaClienteAlterar);
		telaClienteAlterar.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(53, 65, 171));
		separator.setBounds(10, 11, 1306, 2);
		telaClienteAlterar.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(53, 65, 171));
		separator_1.setBounds(10, 666, 1306, 2);
		telaClienteAlterar.add(separator_1);

		lblAlterarCliente = new JLabel("Alterar Cliente");
		lblAlterarCliente.setForeground(new Color(53, 65, 171));
		lblAlterarCliente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
		lblAlterarCliente.setBounds(10, 11, 338, 69);
		telaClienteAlterar.add(lblAlterarCliente);

		lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(81, 107, 153));
		lblNome.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblNome.setBounds(782, 105, 62, 30);
		telaClienteAlterar.add(lblNome);

		tfNome = new JTextField();
		tfNome.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		tfNome.setBounds(945, 108, 371, 30);
		telaClienteAlterar.add(tfNome);
		tfNome.setColumns(10);

		lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(new Color(81, 107, 153));
		lblTelefone.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblTelefone.setBounds(782, 212, 130, 30);
		telaClienteAlterar.add(lblTelefone);

		MaskFormatter telefone = null;
		try {
			telefone = new MaskFormatter("(##) #####-####");
			telefone.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		jftfTelefone = new JFormattedTextField(telefone);
		jftfTelefone.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		jftfTelefone.setColumns(10);
		jftfTelefone.setBounds(945, 215, 371, 30);
		telaClienteAlterar.add(jftfTelefone);

		lblDocumentoCPF = new JLabel("Documento CPF");
		lblDocumentoCPF.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDocumentoCPF.setForeground(new Color(81, 107, 153));
		lblDocumentoCPF.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblDocumentoCPF.setBounds(770, 320, 165, 30);
		telaClienteAlterar.add(lblDocumentoCPF);

		MaskFormatter CPF = null;
		try {
			CPF = new MaskFormatter("###.###.###-##");
			CPF.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		jftfDocumentoCPF = new JFormattedTextField(CPF);
		jftfDocumentoCPF.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		jftfDocumentoCPF.setColumns(10);
		jftfDocumentoCPF.setBounds(945, 320, 371, 30);
		telaClienteAlterar.add(jftfDocumentoCPF);

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
		btnVoltar.setBounds(10, 632, 106, 23);
		telaClienteAlterar.add(btnVoltar);

		lblEscolherCliente = new JLabel("Cliente a alterar");
		lblEscolherCliente.setForeground(new Color(81, 107, 153));
		lblEscolherCliente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblEscolherCliente.setBounds(10, 73, 224, 24);
		telaClienteAlterar.add(lblEscolherCliente);

		tableListClientes = new JTable();
		tableListClientes.setLocation(20, 33);
		tableListClientes.setShowVerticalLines(false);
		tableListClientes.setRowHeight(32);
		ClienteTableModel clienteTableModel = new ClienteTableModel(lista);
		tableListClientes.setModel(clienteTableModel);
		JTableHeader th = tableListClientes.getTableHeader();
		th.setPreferredSize(new Dimension(100, 40));
		tableListClientes.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableListClientes.getColumnModel().getColumn(1).setPreferredWidth(180);
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
		telaClienteAlterar.add(tableListClientes);
		JScrollPane scroll = new JScrollPane(tableListClientes);
		scroll.setBounds(10, 105, 750, 497);
		telaClienteAlterar.add(scroll);

		btnSelecionarCliente = new JButton("Selecionar Cliente");
		btnSelecionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableListClientes.isColumnSelected(4)) {
					tfNome.setText(tableListClientes.getValueAt(tableListClientes.getSelectedRow(), 1).toString());
					jftfDocumentoCPF.setText(tableListClientes.getValueAt(tableListClientes.getSelectedRow(), 2).toString());
					jftfTelefone.setText(tableListClientes.getValueAt(tableListClientes.getSelectedRow(), 3).toString());
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha na coluna opções", "Error", 0);
				}
			}
		});
		btnSelecionarCliente.setBackground(new Color(51, 153, 255));
		btnSelecionarCliente.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnSelecionarCliente.setBounds(559, 632, 198, 23);
		telaClienteAlterar.add(btnSelecionarCliente);

		btnAlterarCliente = new JButton("Alterar Cliente");
		btnAlterarCliente.setBackground(new Color(60, 179, 113));
		btnAlterarCliente.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnAlterarCliente.setBounds(1118, 632, 198, 23);
		telaClienteAlterar.add(btnAlterarCliente);

		btnAlterarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableListClientes.isColumnSelected(4)) {
					String s = tableListClientes.getValueAt(tableListClientes.getSelectedRow(), 0).toString();
					int id = Integer.parseInt(s);

					try {
						Cliente clienteAtt = new Cliente(id, tfNome.getText(), jftfDocumentoCPF.getText(),
								jftfTelefone.getText());
						arquivosDiretorios.atualizarCliente(lista, clienteAtt, id);

						tfNome.setText("");
						jftfTelefone.setText("");
						jftfDocumentoCPF.setText("");

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
	}

}
