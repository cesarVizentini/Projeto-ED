package model;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import persistence.TemaDao;

public class TemaComboBoxModel extends AbstractListModel<Object> implements ComboBoxModel<Object> {

	private static final long serialVersionUID = 1L;
	private TemaDao listaTema;
	private Tema temaSelecionado;

	public TemaComboBoxModel(TemaDao listaTema) {
		this.listaTema = listaTema;
	}

	@Override
	public int getSize() {
		return listaTema.tamanho() + 1;
	}

	@Override
	public Object getElementAt(int index) {
		return this.listaTema.getTema(index);
	}

	@Override
	public void setSelectedItem(Object anItem) {
		if (anItem instanceof Tema) {
			this.temaSelecionado = (Tema) anItem;
			fireContentsChanged(this.listaTema, 0, this.listaTema.tamanho() + 1);
		}
	}

	@Override
	public Object getSelectedItem() {
		return this.temaSelecionado;
	}

}
