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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.text.MaskFormatter;
import controller.ArquivosDiretorios;
import controller.ClienteController;
import model.Cliente;
import model.ClienteTableModel;
import persistence.ClienteDao;

public class TelaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaCliente;
	private ClienteDao lista;
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
	private JTable tableListClientes;
	private JButton btnAlterarCliente;
	private JButton btnCadastrarCliente;
	private JButton btnDeletarCliente;
	private JLabel lblNome;
	private JTextField tfNome;
	private JLabel lblTelefone;
	private JFormattedTextField jftfTelefone;
	private JLabel lblDocumentoCPF;
	private JFormattedTextField jftfDocumentoCPF;
	private JButton btnSelecionarCliente;

//	private void pegarResolucao() {
//		Toolkit t = Toolkit.getDefaultToolkit();
//		Dimension dimensao = t.getScreenSize();
//		int larg = dimensao.width;
//		int alt = dimensao.height;
//		setBounds(0, 0, larg, alt);
//	}

	public TelaCliente() {
		lista = new ClienteDao();
		ArquivosDiretorios arquivosDiretorios = new ArquivosDiretorios();
		try {
			lista = arquivosDiretorios.getClientes(lista);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		setTitle("Cliente");
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet = Toolkit.getDefaultToolkit().getImage(url);
		setIconImage(iconeRafaelaBuffet);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		pegarResolucao();
		setBounds(0, 0, 1680, 1050);
		telaCliente = new JPanel();
		telaCliente.setBackground(new Color(135, 206, 235));
		telaCliente.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaCliente);
		telaCliente.setLayout(null);

		// INICIO SIDE-MENU
		sideMenu = new JPanel();
		sideMenu.setBackground(new Color(173, 220, 253));
		sideMenu.setBounds(0, 0, 240, 861);
		telaCliente.add(sideMenu);
		sideMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		SDLogo = new JLabel("");
		SDLogo.setIcon(new ImageIcon(TelaCliente.class.getResource("/view/assets/SDLogo.png")));
		SDLogo.setPreferredSize(new Dimension(240, 250));
		sideMenu.add(SDLogo);

		btnSMHome = new JButton("Home");
		btnSMHome.setPressedIcon(new ImageIcon(TelaCliente.class.getResource("/view/assets/pressed.png")));
		btnSMHome.setSelectedIcon(new ImageIcon(TelaCliente.class.getResource("/view/assets/selected.png")));
		btnSMHome.setRolloverIcon(new ImageIcon(TelaCliente.class.getResource("/view/assets/hover.png")));
		btnSMHome.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMHome.setIcon(new ImageIcon(TelaCliente.class.getResource("/view/assets/default.png")));
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
		btnSMTema.setPressedIcon(new ImageIcon(TelaCliente.class.getResource("/view/assets/pressed.png")));
		btnSMTema.setIcon(new ImageIcon(TelaCliente.class.getResource("/view/assets/default.png")));
		btnSMTema.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMTema.setRolloverIcon(new ImageIcon(TelaCliente.class.getResource("/view/assets/hover.png")));
		btnSMTema.setSelectedIcon(new ImageIcon(TelaCliente.class.getResource("/view/assets/selected.png")));
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
		btnSMCliente.setPressedIcon(new ImageIcon(TelaCliente.class.getResource("/view/assets/pressed.png")));
		btnSMCliente.setIcon(new ImageIcon(TelaCliente.class.getResource("/view/assets/default.png")));
		btnSMCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMCliente.setRolloverIcon(new ImageIcon(TelaCliente.class.getResource("/view/assets/hover.png")));
		btnSMCliente.setSelectedIcon(new ImageIcon(TelaCliente.class.getResource("/view/assets/selected.png")));
		btnSMCliente.setBackground(new Color(255, 255, 255));
		btnSMCliente.setPreferredSize(new Dimension(220, 40));
		btnSMCliente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		btnSMCliente.setSelected(true);
		sideMenu.add(btnSMCliente);

		lblEspaco3 = new JLabel("");
		lblEspaco3.setPreferredSize(new Dimension(20, 20));
		sideMenu.add(lblEspaco3);

		btnSMFesta = new JButton("Festa");
		btnSMFesta.setPressedIcon(new ImageIcon(TelaCliente.class.getResource("/view/assets/pressed.png")));
		btnSMFesta.setIcon(new ImageIcon(TelaCliente.class.getResource("/view/assets/default.png")));
		btnSMFesta.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMFesta.setRolloverIcon(new ImageIcon(TelaCliente.class.getResource("/view/assets/hover.png")));
		btnSMFesta.setSelectedIcon(new ImageIcon(TelaCliente.class.getResource("/view/assets/selected.png")));
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
		btnSMFinancas.setPressedIcon(new ImageIcon(TelaCliente.class.getResource("/view/assets/pressed.png")));
		btnSMFinancas.setIcon(new ImageIcon(TelaCliente.class.getResource("/view/assets/default.png")));
		btnSMFinancas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMFinancas.setRolloverIcon(new ImageIcon(TelaCliente.class.getResource("/view/assets/hover.png")));
		btnSMFinancas.setSelectedIcon(new ImageIcon(TelaCliente.class.getResource("/view/assets/selected.png")));
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

		// INICIO TABLE
		tableListClientes = new JTable();
		tableListClientes.setLocation(20, 33);
		tableListClientes.setShowVerticalLines(false);
		tableListClientes.setRowHeight(32);
		ClienteTableModel clienteTableModel = new ClienteTableModel(lista);
		tableListClientes.setModel(clienteTableModel);
		JTableHeader th = tableListClientes.getTableHeader();
		th.setPreferredSize(new Dimension(100, 40));
		tableListClientes.getColumnModel().getColumn(0).setPreferredWidth(5);
		tableListClientes.getColumnModel().getColumn(1).setPreferredWidth(180);
		tableListClientes.getColumnModel().getColumn(2).setPreferredWidth(30);
		tableListClientes.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
		telaCliente.add(tableListClientes);
		JScrollPane scroll = new JScrollPane(tableListClientes);
		scroll.setBounds(258, 11, 1141, 464);
		telaCliente.add(scroll);
		// FIM TABLE

		// INICIO FORMULARIO
		lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(81, 107, 153));
		lblNome.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblNome.setBounds(258, 486, 48, 25);
		telaCliente.add(lblNome);

		tfNome = new JTextField();
		tfNome.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		tfNome.setBounds(258, 511, 499, 25);
		telaCliente.add(tfNome);
		tfNome.setColumns(10);

		MaskFormatter telefone = null;
		try {
			telefone = new MaskFormatter("(##) #####-####");
			telefone.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(new Color(81, 107, 153));
		lblTelefone.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblTelefone.setBounds(258, 560, 111, 25);
		telaCliente.add(lblTelefone);

		jftfTelefone = new JFormattedTextField(telefone);
		jftfTelefone.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		jftfTelefone.setColumns(10);
		jftfTelefone.setBounds(258, 600, 166, 25);
		telaCliente.add(jftfTelefone);

		lblDocumentoCPF = new JLabel("Documento CPF");
		lblDocumentoCPF.setForeground(new Color(81, 107, 153));
		lblDocumentoCPF.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblDocumentoCPF.setBounds(258, 650, 176, 25);
		telaCliente.add(lblDocumentoCPF);

		MaskFormatter CPF = null;
		try {
			CPF = new MaskFormatter("###.###.###-##");
			CPF.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		jftfDocumentoCPF = new JFormattedTextField(CPF);
		jftfDocumentoCPF.setForeground(Color.BLACK);
		jftfDocumentoCPF.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		jftfDocumentoCPF.setBounds(258, 680, 145, 25);
		telaCliente.add(jftfDocumentoCPF);
		jftfDocumentoCPF.setColumns(10);
		// FIM FORMULARIO

		// INICIO BOTOES
		btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.setBackground(new Color(60, 179, 113));
		btnCadastrarCliente.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnCadastrarCliente.setBounds(1196, 486, 205, 27);
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean valido = validaTela();
				if (valido) {
					boolean newTable = false;
					if (lista == null) {
						newTable = true;
					}
					ClienteController clienteController = new ClienteController();
					clienteController.cadastrar(tfNome.getText(), jftfTelefone.getText(), jftfDocumentoCPF.getText());
					tfNome.setText("");
					jftfTelefone.setText("");
					jftfDocumentoCPF.setText("");
					if (newTable) {
						TelaCliente telaCliente = new TelaCliente();
						telaCliente.setVisible(true);
						dispose();
					}
					clienteTableModel.addRow();
					TelaCliente telaCliente = new TelaCliente();
					telaCliente.setVisible(true);
					dispose();
				}
			}
		});
		telaCliente.add(btnCadastrarCliente);

		btnSelecionarCliente = new JButton("Selecionar Cliente");
		btnSelecionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableListClientes.isColumnSelected(5)) {
					tfNome.setText(tableListClientes.getValueAt(tableListClientes.getSelectedRow(), 1).toString());
					jftfDocumentoCPF
							.setText(tableListClientes.getValueAt(tableListClientes.getSelectedRow(), 2).toString());
					jftfTelefone
							.setText(tableListClientes.getValueAt(tableListClientes.getSelectedRow(), 3).toString());
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha na coluna opções para alterar o cliente",
							"Error", 0);
				}
			}
		});
		btnSelecionarCliente.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnSelecionarCliente.setBackground(new Color(221, 160, 221));
		btnSelecionarCliente.setBounds(1194, 535, 205, 27);
		telaCliente.add(btnSelecionarCliente);

		btnAlterarCliente = new JButton("Alterar Cliente");
		btnAlterarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean valido = validaTela();
				if (valido) {
					
					if (tableListClientes.isColumnSelected(5)) {
						String s = tableListClientes.getValueAt(tableListClientes.getSelectedRow(), 0).toString();
						int id = Integer.parseInt(s);
						
						String sFestas = tableListClientes.getValueAt(tableListClientes.getSelectedRow(), 4).toString();
						int idFestas = Integer.parseInt(sFestas);
						
						try {
							Cliente clienteAtt = new Cliente(id, tfNome.getText(), jftfDocumentoCPF.getText(),
									jftfTelefone.getText(), idFestas);
							arquivosDiretorios.atualizarCliente(lista, clienteAtt, id);

							tfNome.setText("");
							jftfTelefone.setText("");
							jftfDocumentoCPF.setText("");

							if (lista.getCliente(0) == null) {
								TelaCliente telaCliente = new TelaCliente();
								telaCliente.setVisible(true);
								dispose();
							} else {
								ClienteTableModel clienteTableModel = new ClienteTableModel(lista);
								clienteTableModel.addRow();
								TelaCliente telaCliente = new TelaCliente();
								telaCliente.setVisible(true);
								dispose();
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Selecione uma linha na coluna opções para alterar o cliente", "Error", 0);
					}
					
				}
			}

			
		});
		btnAlterarCliente.setBackground(new Color(204, 255, 51));
		btnAlterarCliente.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnAlterarCliente.setBounds(1196, 580, 205, 27);
		telaCliente.add(btnAlterarCliente);

		btnDeletarCliente = new JButton("Deletar Cliente");
		btnDeletarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableListClientes.isColumnSelected(5)) {
					String s = tableListClientes.getValueAt(tableListClientes.getSelectedRow(), 0).toString();
					int id = Integer.parseInt(s);
					try {
						arquivosDiretorios.removerCliente(lista, id);
						if (lista.getCliente(0) == null) {
							TelaCliente telaCliente = new TelaCliente();
							telaCliente.setVisible(true);
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
		btnDeletarCliente.setBackground(new Color(255, 102, 102));
		btnDeletarCliente.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnDeletarCliente.setBounds(1196, 626, 205, 27);
		telaCliente.add(btnDeletarCliente);
		// FIM BOTOES
	}

	private boolean validaTela() {
		boolean valida = true;
		if (tfNome.getText().trim().equals("") && jftfTelefone.getText().trim().equals("(__) _____-____")
				&& jftfDocumentoCPF.getText().trim().equals("___.___.___-__")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos acima para realizar o cadastro",
					"Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (tfNome.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha o nome do cliente para realizar o cadastro",
					"Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (jftfDocumentoCPF.getText().trim().equals("___.___.___-__")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha o documento do cliente para realizar o cadastro",
					"Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (jftfTelefone.getText().trim().equals("(__) _____-____")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha o telefone do cliente para realizar o cadastro",
					"Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		}
		return valida;
	}
	
	
}
