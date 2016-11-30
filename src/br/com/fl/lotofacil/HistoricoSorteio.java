package br.com.fl.lotofacil;

import java.util.ArrayList;


public class HistoricoSorteio {

	PadraoSorteio padraoSorteio = new PadraoSorteio();
	
	static private ArrayList<Integer> vetNumerosSorteados = new ArrayList<>();

	
	public String getUltimoQuizeNumerosSorteados() {
		
		String texto;
		
		texto = "0"+Integer.toString(vetNumerosSorteados.get(0)+1);
		for(int i = 1; i < vetNumerosSorteados.size(); i++){
			if(vetNumerosSorteados.get(i) < 9){
				texto += ", 0"+Integer.toString(vetNumerosSorteados.get(i)+1);
			}else{
				texto += ", "+Integer.toString(vetNumerosSorteados.get(i)+1);
			}
		}
		
		return texto;
	}
	
	
	public int getNumeroSorteado(int valor){
		return vetNumerosSorteados.get(valor);
	}
	
	
	
	public void setQuizeNumerosSorteados(int[] numerosSorteados) {
	
		vetNumerosSorteados.removeAll(vetNumerosSorteados);
		
		for (int i : numerosSorteados) {
			vetNumerosSorteados.add(i);
		}
		
	}
	
	
	
}
