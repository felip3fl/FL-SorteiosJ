package br.com.fl.lotofacil;

public class PadraoSorteio {

	/*
	 * Definindo quantidade de numeros para sorteio
	 * 
	 */
	private int quantNumSorteio = 15;
	private final int NUM_MAX_SORTEIO_LOTOFACIL = 25;
	
	public int getNumMaxSorteioLotofacil() {
		return NUM_MAX_SORTEIO_LOTOFACIL;
	}

	public int getQuantNumSorteio() {
		return quantNumSorteio;
	}

	public void setQuantNumSorteio(int quantNumSorteio) {
		this.quantNumSorteio = quantNumSorteio;
	}
	
	public int quantNumeroBloqueados(){
		return (NUM_MAX_SORTEIO_LOTOFACIL - quantNumSorteio - 1);
	}
	
	
	
}
