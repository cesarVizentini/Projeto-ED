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
		
		if (ultimaData.before(dataFinal)) {
			ultimo = ultimo.getProximo();
			calculaFinancas(dataInicial, dataFinal);
		}
		
		while (!primeiro.equals(ultimo)) {
			valor = valor + primeiro.getFesta().getValorCobrado();
			primeiro = primeiro.getProximo();
		}
		
		return Double.toString(valor);
	}
}