package model;

import javax.swing.table.AbstractTableModel;

import persistence.ClienteDao;

public class ClienteTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private String[] columns = { "Código", "Nome", "Documento CPF", "Telefone", "Sequencia de festas alugadas", "Opções" };
	private ClienteDao listar;
	public ClienteTableModel(ClienteDao listar) {
		this.listar = listar;
	}
	
	@Override
	public String getColumnName(int column) {
		return columns[column];
	}

	@Override
	public int getColumnCount() {
		return this.columns.length;
	}

	@Override
	public int getRowCount() {
		if (listar != null)
			return listar.tamanho() + 1;
		else
			return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case 0: return listar.getCliente(rowIndex).getId();
		case 1: return listar.getCliente(rowIndex).getNome();
		case 2: return listar.getCliente(rowIndex).getDocumentoCPF();
		case 3: return listar.getCliente(rowIndex).getTelefone();
		case 4: return listar.getCliente(rowIndex).getFestasAlugadas();
		}
		return null;
	}
	
	public void addRow() {
		this.fireTableDataChanged();
	}

}
