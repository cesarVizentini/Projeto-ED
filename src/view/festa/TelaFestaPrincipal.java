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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import controller.ArquivosDiretorios;
import model.FestaTableModel;
import persistence.FestaDao;
import view.TelaMenuPrincipal;

public class TelaFestaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel telaFestaPrincipal;
	private JTable tableListFestas;
	private FestaDao lista;

	public TelaFestaPrincipal() {
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
		
		setTitle("Festa Principal");
		setResizable(false);
		URL url = this.getClass().getResource("/view/assets/icon.png");
		Image iconeRafaelaBuffet  = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(iconeRafaelaBuffet);
		setIconImage(iconeRafaelaBuffet);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1366, 720);
		telaFestaPrincipal = new JPanel();
		telaFestaPrincipal.setBackground(new Color(173, 220, 253));
		telaFestaPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaFestaPrincipal);
		telaFestaPrincipal.setLayout(null);
		
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
		telaFestaPrincipal.add(btnVoltar);
		
		JButton btnCadastrarFesta = new JButton("Cadastrar Festa");
		btnCadastrarFesta.setBackground(Color.WHITE);
		btnCadastrarFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFestaCadastrar telaFestaCadastrar = new TelaFestaCadastrar();
				telaFestaCadastrar.setVisible(true);
				dispose();
			}
		});
		btnCadastrarFesta.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnCadastrarFesta.setBounds(1100, 11, 208, 50);
		telaFestaPrincipal.add(btnCadastrarFesta);
		
		JButton btnAlterarFesta = new JButton("Alterar Festa");
		btnAlterarFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFestaAlterar telaFestaAlterar = new TelaFestaAlterar();
				telaFestaAlterar.setVisible(true);
				dispose();
			}
		});
		btnAlterarFesta.setBackground(Color.WHITE);
		btnAlterarFesta.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnAlterarFesta.setBounds(1100, 73, 208, 50);
		telaFestaPrincipal.add(btnAlterarFesta);
		
		JButton btnDeletarFesta = new JButton("Deletar Festa");
		btnDeletarFesta.setBackground(Color.WHITE);
		btnDeletarFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFestaDeletar telaFestaDeletar = new TelaFestaDeletar();
				telaFestaDeletar.setVisible(true);
				dispose();
			}
		});
		btnDeletarFesta.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		btnDeletarFesta.setBounds(1100, 135, 208, 50);
		telaFestaPrincipal.add(btnDeletarFesta);
		
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
		telaFestaPrincipal.add(tableListFestas);
		JScrollPane scroll = new JScrollPane(tableListFestas);
		scroll.setBounds(10, 11, 1037, 595);
		telaFestaPrincipal.add(scroll);
	}
}
