package br.com.fl.lotofacil;

import java.util.ArrayList;
import java.util.Collections;

public class ValoresParaNaoSortear{

	/**
	 *@author Felipe Lima
	 *
	 * ArrayList valoresSorteados armazena todos os valores que o usuario não quer que seja sorteado
	 */
	private static ArrayList<Integer> valoresParaNaoSorteados = new ArrayList<>();
	
	PadraoSorteio padraoSorteio = new PadraoSorteio();
	
	/**
	 *  <code>limiteBotaoApertado</code> limita a quantidade de números que o usuário pode optar para não sortear
	 *  @return false - Números adicionado chegou ao limite, então não poderá proceguir
	 *  @return true -  Números não chegou ao limite, então continuar a adicionar números no arrayList
	 */
	public boolean limiteBotaoApertado(int numeroBotaoApertado){
		
		if(valoresParaNaoSorteados.size() == padraoSorteio.quantNumeroBloqueados()){
			return false;
		}else{
			return true;
		}
		
	}
	
	
	public boolean add(int numeroNaoSortear){
		if(limiteBotaoApertado(numeroNaoSortear)){
			valoresParaNaoSorteados.add(numeroNaoSortear);
			
			Collections.sort(valoresParaNaoSorteados);
			System.out.println(valoresParaNaoSorteados);
			
			return true;
		}else{
			return false;
		}
	}
	
	public void remove(int numeroNaoSortear){
		valoresParaNaoSorteados.remove(valoresParaNaoSorteados.indexOf(numeroNaoSortear));
	}
	
	public boolean getValorNaoSortear(int numero){
		return valoresParaNaoSorteados.contains(numero);
	}
	
	public void removerTodosValores(){
		valoresParaNaoSorteados.removeAll(valoresParaNaoSorteados);
	}
	
	public String mensagemValoresBloqueados(){
		String texto;
		
		if(valoresParaNaoSorteados.size() == 0){
			texto = "Todos os "+padraoSorteio.getNumMaxSorteioLotofacil()+" números fazem parte do sorteio";
			
		}else if(valoresParaNaoSorteados.size() == 1){
			texto = (valoresParaNaoSorteados.get(0)+1)+" não faz parte do sorteio";
			
		}else{
			
			texto = Integer.toString(valoresParaNaoSorteados.get(0)+1);
			
			for(int i = 1; i < valoresParaNaoSorteados.size(); i++){
				texto += ", "+(valoresParaNaoSorteados.get(i)+1);
			}
			texto += " não serão sorteado";
			
		}
		
		return texto;
		
	}
	
}
