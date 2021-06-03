package persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.FestaNo;
import view.TelaFinancas;

public class FinancasDao {
	
	FestaDao lista = TelaFinancas.getLista();
	private FestaNo primeiro = lista.getPrimeiroElemento();
	private FestaNo ultimo = lista.getPrimeiroElemento();
	Date primeiraData = null;
	Date ultimaData = null;
	private double valor;
	int i = 0;
	
	public String calculaFinancas(Date dataInicial, Date dataFinal) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		try {
			primeiraData = formatter.parse(primeiro.getFesta().getDataFesta());
			ultimaData = formatter.parse(ultimo.getFesta().getDataFesta());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if (primeiraData.before(dataInicial)) {
			primeiro = primeiro.getProximo();
			calculaFinancas(dataInicial, dataFinal);
		}
		
		if (ultimaData.before(dataFinal) && ultimo.getProximo() != null) {
			ultimo = ultimo.getProximo();
			calculaFinancas(dataInicial, dataFinal);
		}
		
		if (ultimaData.after(dataFinal)) {
			try {
				ultimaData = formatter.parse(ultimo.getAnterior().getFesta().getDataFesta());
				ultimo = ultimo.getAnterior();
			} catch (ParseException e) {
				e.printStackTrace();
			}	
		}
						
		while (!primeiro.equals(ultimo)) {
			valor = valor + primeiro.getFesta().getValorCobrado();
			primeiro = primeiro.getProximo();
			i++;
			if (primeiro.equals(ultimo)) {
				valor = valor + primeiro.getFesta().getValorCobrado();
				i++;
			}
		}
		
		if (i == 0) {
			valor = primeiro.getFesta().getValorCobrado();
			i++;
		}
		
		return Double.toString(valor);
	}
}