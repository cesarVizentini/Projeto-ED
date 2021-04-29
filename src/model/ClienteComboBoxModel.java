package model;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import persistence.ClienteDao;

public class ClienteComboBoxModel extends AbstractListModel<Object> implements ComboBoxModel<Object>  {

	private static final long serialVersionUID = 1L;
	private ClienteDao listaCliente;
	private Cliente clienteSelecionado;
	
	public ClienteComboBoxModel(ClienteDao listaCliente) {
		this.listaCliente = listaCliente;
	}

	@Override
	public int getSize() {
		return listaCliente.tamanho() + 1;
	}

	@Override
	public Object getElementAt(int index) {
		return this.listaCliente.getCliente(index);
	}

	@Override
	public void setSelectedItem(Object anItem) {
		if (anItem instanceof Cliente) {
			this.clienteSelecionado = (Cliente) anItem;
			fireContentsChanged(this.listaCliente, 0, this.listaCliente.tamanho() + 1);
		}
	}

	@Override
	public Object getSelectedItem() {
		return this.clienteSelecionado;
	}

}
