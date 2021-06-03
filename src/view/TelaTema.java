package view;

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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import controller.ArquivosDiretorios;
import controller.TemaController;
import model.Tema;
import model.TemaTableModel;
import persistence.TemaDao;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class TelaTema extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaTema;
	private JTable tableListTemas;
	private TemaDao lista;
	private JButton btnDeletarTema;
	private JTextField tfNome;
	private JLabel lblPreco;
	private JTextArea taDescricao;
	private JLabel lblDescricao;
	private JLabel lblNome;
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
	private JButton btnCadastrarTema;
	private JButton btnAlterarTema;
	private JTextField tfPreco;
	private JButton btnSelecionarTema;

	private void pegarResolucao() {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension dimensao = t.getScreenSize();
		int larg = dimensao.width;
		int alt = dimensao.height;
		setBounds(0, 0, larg, alt);
	}

	public TelaTema() {
		lista = new TemaDao();
		ArquivosDiretorios arquivosDiretorios = new ArquivosDiretorios();
		try {
			lista = arquivosDiretorios.getTemas(lista);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		setTitle("Tema");
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet = Toolkit.getDefaultToolkit().getImage(url);
		setIconImage(iconeRafaelaBuffet);
        setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pegarResolucao();
		telaTema = new JPanel();
		telaTema.setBackground(new Color(135, 206, 235));
		telaTema.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaTema);
		telaTema.setLayout(null);

		// INICIO SIDE-MENU
		sideMenu = new JPanel();
		sideMenu.setBackground(new Color(173, 220, 253));
		sideMenu.setBounds(0, 0, 240, 861);
		telaTema.add(sideMenu);
		sideMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		SDLogo = new JLabel("");
		SDLogo.setIcon(new ImageIcon(TelaTema.class.getResource("/view/assets/SDLogo.png")));
		SDLogo.setPreferredSize(new Dimension(240, 250));
		sideMenu.add(SDLogo);

		btnSMHome = new JButton("Home");
		btnSMHome.setPressedIcon(new ImageIcon(TelaTema.class.getResource("/view/assets/pressed.png")));
		btnSMHome.setSelectedIcon(new ImageIcon(TelaTema.class.getResource("/view/assets/selected.png")));
		btnSMHome.setRolloverIcon(new ImageIcon(TelaTema.class.getResource("/view/assets/hover.png")));
		btnSMHome.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMHome.setIcon(new ImageIcon(TelaTema.class.getResource("/view/assets/default.png")));
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
		btnSMTema.setPressedIcon(new ImageIcon(TelaTema.class.getResource("/view/assets/pressed.png")));
		btnSMTema.setIcon(new ImageIcon(TelaTema.class.getResource("/view/assets/default.png")));
		btnSMTema.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMTema.setRolloverIcon(new ImageIcon(TelaTema.class.getResource("/view/assets/hover.png")));
		btnSMTema.setSelectedIcon(new ImageIcon(TelaTema.class.getResource("/view/assets/selected.png")));
		btnSMTema.setBackground(new Color(255, 255, 255));
		btnSMTema.setPreferredSize(new Dimension(220, 40));
		btnSMTema.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		btnSMTema.setSelected(true);
		sideMenu.add(btnSMTema);

		lblEspaco2 = new JLabel("");
		lblEspaco2.setPreferredSize(new Dimension(20, 20));
		sideMenu.add(lblEspaco2);

		btnSMCliente = new JButton("Cliente");
		btnSMCliente.setPressedIcon(new ImageIcon(TelaTema.class.getResource("/view/assets/pressed.png")));
		btnSMCliente.setIcon(new ImageIcon(TelaTema.class.getResource("/view/assets/default.png")));
		btnSMCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMCliente.setRolloverIcon(new ImageIcon(TelaTema.class.getResource("/view/assets/hover.png")));
		btnSMCliente.setSelectedIcon(new ImageIcon(TelaTema.class.getResource("/view/assets/selected.png")));
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
		btnSMFesta.setPressedIcon(new ImageIcon(TelaTema.class.getResource("/view/assets/pressed.png")));
		btnSMFesta.setIcon(new ImageIcon(TelaTema.class.getResource("/view/assets/default.png")));
		btnSMFesta.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMFesta.setRolloverIcon(new ImageIcon(TelaTema.class.getResource("/view/assets/hover.png")));
		btnSMFesta.setSelectedIcon(new ImageIcon(TelaTema.class.getResource("/view/assets/selected.png")));
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
		btnSMFinancas.setPressedIcon(new ImageIcon(TelaTema.class.getResource("/view/assets/pressed.png")));
		btnSMFinancas.setIcon(new ImageIcon(TelaTema.class.getResource("/view/assets/default.png")));
		btnSMFinancas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSMFinancas.setRolloverIcon(new ImageIcon(TelaTema.class.getResource("/view/assets/hover.png")));
		btnSMFinancas.setSelectedIcon(new ImageIcon(TelaTema.class.getResource("/view/assets/selected.png")));
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
		tableListTemas = new JTable();
		tableListTemas.setSize(1122, 449);
		tableListTemas.setLocation(1, 26);
		tableListTemas.setShowVerticalLines(false);
		tableListTemas.setRowHeight(32);
		TemaTableModel temaTableModel = new TemaTableModel(lista);
		tableListTemas.setModel(temaTableModel);
		JTableHeader th = tableListTemas.getTableHeader();
		th.setPreferredSize(new Dimension(100, 40));
		tableListTemas.getColumnModel().getColumn(0).setPreferredWidth(5);
		tableListTemas.getColumnModel().getColumn(1).setPreferredWidth(120);
		tableListTemas.getColumnModel().getColumn(2).setPreferredWidth(40);
		tableListTemas.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
		telaTema.add(tableListTemas);
		JScrollPane scroll = new JScrollPane(tableListTemas);
		scroll.setBounds(258, 11, 1141, 464);
		telaTema.add(scroll);
		// FIM TABLE

		// INICIO FORMULARIO
		lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(81, 107, 153));
		lblNome.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblNome.setBounds(258, 486, 48, 25);
		telaTema.add(lblNome);

		tfNome = new JTextField();
		tfNome.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		tfNome.setBounds(258, 511, 499, 25);
		telaTema.add(tfNome);

		lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setForeground(new Color(81, 107, 153));
		lblDescricao.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblDescricao.setBounds(258, 560, 108, 27);
		telaTema.add(lblDescricao);

		taDescricao = new JTextArea();
		taDescricao.setLineWrap(true);
		taDescricao.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		taDescricao.setBounds(142, 156, 492, 107);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(258, 589, 499, 110);
		telaTema.add(scrollPane);
		scrollPane.setViewportView(taDescricao);

		lblPreco = new JLabel("Pre\u00E7o R$");
		lblPreco.setForeground(new Color(81, 107, 153));
		lblPreco.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblPreco.setBounds(258, 710, 96, 25);
		telaTema.add(lblPreco);

		tfPreco = new JTextField();
		tfPreco.setForeground(Color.BLACK);
		tfPreco.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		tfPreco.setBounds(258, 746, 79, 25);
		telaTema.add(tfPreco);
		// FIM FORMULARIO

		// INICIO BOTOES
		btnCadastrarTema = new JButton("Cadastrar Tema");
		btnCadastrarTema.setBackground(new Color(60, 179, 113));
		btnCadastrarTema.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnCadastrarTema.setBounds(1196, 486, 205, 27);
		btnCadastrarTema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean valido = validaTela();
				if (valido) {
					boolean newTable = false;
					if (lista == null) {
						newTable = true;
					}
					TemaController temaController = new TemaController();
					temaController.cadastrar(tfNome.getText(), taDescricao.getText(),
							Double.parseDouble(tfPreco.getText()));
					tfNome.setText("");
					taDescricao.setText("");
					tfPreco.setText("");
					if (newTable) {
						TelaTema telaTema = new TelaTema();
						telaTema.setVisible(true);
						dispose();
					}
					temaTableModel.addRow();
					TelaTema telaTema = new TelaTema();
					telaTema.setVisible(true);
					dispose();
				}
			}
		});
		telaTema.add(btnCadastrarTema);
		
		btnSelecionarTema = new JButton("Selecionar Tema");
		btnSelecionarTema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableListTemas.isColumnSelected(4)) {
					tfNome.setText(tableListTemas.getValueAt(tableListTemas.getSelectedRow(), 1).toString());
					taDescricao.setText(tableListTemas.getValueAt(tableListTemas.getSelectedRow(), 2).toString());
					tfPreco.setText(tableListTemas.getValueAt(tableListTemas.getSelectedRow(), 3).toString());

				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha na coluna opções para alterar o tema", "Error", 0);
				}
			}
		});
		btnSelecionarTema.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnSelecionarTema.setBackground(new Color(221, 160, 221));
		btnSelecionarTema.setBounds(1194, 535, 205, 27);
		telaTema.add(btnSelecionarTema);

		btnAlterarTema = new JButton("Alterar Tema");
		btnAlterarTema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableListTemas.isColumnSelected(4)) {
					String s = tableListTemas.getValueAt(tableListTemas.getSelectedRow(), 0).toString();
					int id = Integer.parseInt(s);

					try {
						Tema temaAtt = new Tema(id, tfNome.getText(), taDescricao.getText(),
								Double.parseDouble(tfPreco.getText()));
						arquivosDiretorios.atualizarTema(lista, temaAtt, id);

						tfNome.setText("");
						taDescricao.setText("");
						tfPreco.setText("");

						if (lista.getTema(0) == null) {
							TelaTema telaTema = new TelaTema();
							telaTema.setVisible(true);
							dispose();
						} else {
							temaTableModel.addRow();
							TelaTema telaTema = new TelaTema();
							telaTema.setVisible(true);
							dispose();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha na coluna opções", "Error", 0);
				}
			}
		});
		btnAlterarTema.setBackground(new Color(204, 255, 51));
		btnAlterarTema.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnAlterarTema.setBounds(1196, 588, 205, 27);
		telaTema.add(btnAlterarTema);

		btnDeletarTema = new JButton("Deletar Tema");
		btnDeletarTema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableListTemas.isColumnSelected(4)) {
					String s = tableListTemas.getValueAt(tableListTemas.getSelectedRow(), 0).toString();
					int id = Integer.parseInt(s);
					try {
						arquivosDiretorios.removerTema(lista, id);
						if (lista.getTema(0) == null) {
							TelaTema telaTema = new TelaTema();
							telaTema.setVisible(true);
							dispose();
						} else {
							temaTableModel.addRow();
							TelaTema telaTema = new TelaTema();
							telaTema.setVisible(true);
							dispose();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha na coluna opções", "Error", 0);
				}
			}
		});
		btnDeletarTema.setBackground(new Color(255, 102, 102));
		btnDeletarTema.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnDeletarTema.setBounds(1194, 634, 205, 27);
		telaTema.add(btnDeletarTema);
		// FIM BOTOES
	}

	private boolean validaTela() {
		boolean valida = true;
		if (tfNome.getText().trim().equals("") && taDescricao.getText().trim().equals("")
				&& tfPreco.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos acima para realizar o cadastro",
					"Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (tfNome.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha o nome do tema para realizar o cadastro",
					"Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (taDescricao.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha a descrição do tema para realizar o cadastro",
					"Informação", JOptionPane.INFORMATION_MESSAGE);
			valida = false;
		} else if (tfPreco.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha o preço do tema para realizar o cadastro",
					"Informação", JOptionPane.INFORMATION_MESSAGE);
			try {
				Double.parseDouble(tfPreco.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Preço deve ser númerico com duas casas decimais", "ERRO",
						JOptionPane.ERROR_MESSAGE);
			}
			valida = false;
		}
		return valida;
	}
}
