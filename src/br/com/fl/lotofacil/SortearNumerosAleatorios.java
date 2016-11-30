package br.com.fl.lotofacil;

import java.util.Arrays;
import java.util.Random;


public class SortearNumerosAleatorios {

	/**
	 * @author Felipe Lima
	 * 
	 * Sortear números aleatorios
	 * Após sortear os números, que não repete, são re-organizados em ordem alfabetica em enviado para o <code>HistoricoSorterio</code>
	 * Não retorna nenhum numero
	 *  
	 */
	
	public void getNumeroAleatorio() {
		
		HistoricoSorteio historicoSorteio = new HistoricoSorteio();
		ValoresParaNaoSortear valoresNaoPermitido = new ValoresParaNaoSortear();
		PadraoSorteio padraoSorteio = new PadraoSorteio();
		Random sorteaNumero = new Random();
		
		int[] valoresSorteado = new int[padraoSorteio.getQuantNumSorteio()];

		for (int i = 0; i < padraoSorteio.getQuantNumSorteio(); i++) {
			int prosseguir;
			do {
				valoresSorteado[i] = (sorteaNumero.nextInt(padraoSorteio.getNumMaxSorteioLotofacil())); //Sortear
				
				if (valoresNaoPermitido.getValorNaoSortear(valoresSorteado[i])) {
					prosseguir = 1;
				} else {
					prosseguir = 2;
				}
				
				for (int j = 0; j <= i; j++){
					if(valoresSorteado[i] == valoresSorteado[j] & j != i){
						prosseguir = 1;
					}
				}
				
			} while (prosseguir != 2);
		}

	
		//Organiza em ordem alfabetica
		Arrays.sort(valoresSorteado, 0, valoresSorteado.length);		
		historicoSorteio.setQuizeNumerosSorteados(valoresSorteado);

	}
	
	

}