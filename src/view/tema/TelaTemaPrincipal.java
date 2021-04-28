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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import controller.ArquivosDiretorios;
import model.TemaTableModel;
import persistence.TemaDao;
import view.TelaMenuPrincipal;

public class TelaTemaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaTemaPrincipal;
	private JTable tableListTemas;
	private TemaDao lista;

	public TelaTemaPrincipal() {
		lista = new TemaDao();
		ArquivosDiretorios arquivosDiretorios = new ArquivosDiretorios();
		try {
			lista = arquivosDiretorios.getTemas(lista);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		setTitle("Tema Principal");
		setResizable(false);
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet  = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(iconeRafaelaBuffet);
		setIconImage(iconeRafaelaBuffet);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1366, 720);
		telaTemaPrincipal = new JPanel();
		telaTemaPrincipal.setBackground(new Color(173, 220, 253));
		telaTemaPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaTemaPrincipal);
		telaTemaPrincipal.setLayout(null);
		
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
		btnVoltar.setBounds(10, 626, 89, 23);
		telaTemaPrincipal.add(btnVoltar);
		
		JButton btnCadastrarTema = new JButton("Cadastrar Tema");
		btnCadastrarTema.setBackground(Color.WHITE);
		btnCadastrarTema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTemaCadastrar telaTemaCadastrar = new TelaTemaCadastrar();
				telaTemaCadastrar.setVisible(true);
				dispose();
			}
		});
		btnCadastrarTema.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnCadastrarTema.setBounds(1100, 11, 208, 50);
		telaTemaPrincipal.add(btnCadastrarTema);
		
		JButton btnAlterarTema = new JButton("Alterar Tema");
		btnAlterarTema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTemaAlterar telaTemaAlterar = new TelaTemaAlterar();
				telaTemaAlterar.setVisible(true);
				dispose();
			}
		});
		btnAlterarTema.setBackground(Color.WHITE);
		btnAlterarTema.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnAlterarTema.setBounds(1100, 73, 208, 50);
		telaTemaPrincipal.add(btnAlterarTema);
		
		JButton btnDeletarTema = new JButton("Deletar Tema");
		btnDeletarTema.setBackground(Color.WHITE);
		btnDeletarTema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTemaDeletar telaTemaDeletar = new TelaTemaDeletar();
				telaTemaDeletar.setVisible(true);
				dispose();
			}
		});
		btnDeletarTema.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnDeletarTema.setBounds(1100, 135, 208, 50);
		telaTemaPrincipal.add(btnDeletarTema);
		
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
		telaTemaPrincipal.add(tableListTemas);
		JScrollPane scroll = new JScrollPane(tableListTemas);
		scroll.setBounds(10, 11, 1037, 595);
		telaTemaPrincipal.add(scroll);
	}
}
