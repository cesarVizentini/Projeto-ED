package model;

import javax.swing.table.AbstractTableModel;

import persistence.FestaDao;

public class FestaTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private String[] columns = { "Código", "Tema", "Cliente", "Data", "Horário de início", "Horário de término", "Endereço", "Valor Total (R$)", "Opções" };
	private FestaDao listar;
	public FestaTableModel(FestaDao listar) {
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
		case 0: return listar.getFesta(rowIndex).getId();
		case 1: return listar.getFesta(rowIndex).getTema();
		case 2: return listar.getFesta(rowIndex).getCliente();
		case 3: return listar.getFesta(rowIndex).getDataFesta();
		case 4: return listar.getFesta(rowIndex).getHorarioInicio();
		case 5: return listar.getFesta(rowIndex).getHorarioFinal();
		case 6: return listar.getFesta(rowIndex).getEndereco().toString();
		case 7: return listar.getFesta(rowIndex).getValorCobrado();
		}
		return null;
	}
	
	public void addRow() {
		this.fireTableDataChanged();
	}

}
