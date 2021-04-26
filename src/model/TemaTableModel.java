package model;

import javax.swing.table.AbstractTableModel;

import persistence.TemaDao;

public class TemaTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private String[] columns = { "Código", "Nome", "Descrição", "Valor Aluguel (R$)", "Opções" };
	private TemaDao listar;
	public TemaTableModel(TemaDao listar) {
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
		case 0: return listar.getTema(rowIndex).getId();
		case 1: return listar.getTema(rowIndex).getNome();
		case 2: return listar.getTema(rowIndex).getDescricao();
		case 3: return listar.getTema(rowIndex).getValor();
		}
		return null;
	}
	
	public void addRow() {
		this.fireTableDataChanged();
	}

}
