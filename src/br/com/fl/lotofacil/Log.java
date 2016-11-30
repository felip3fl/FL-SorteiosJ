package br.com.fl.lotofacil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

//	private Date data;
//	private boolean sucesso;
//	private String nomeClasse;
//	private String acaoExecutada;
	
	
	public void setLog(int sucesso, String nomeClasse, String acaoExecutada) {

		SimpleDateFormat dataFormata = new SimpleDateFormat("hh:mm:ss dd/MM/yyy");
		Date data = new Date();
		
		if(sucesso == 1){
			System.out.println("["+dataFormata.format(data)+"]  Sucesso  | "+nomeClasse+" | "+acaoExecutada);
		}else if(sucesso == 2){
			System.out.println("["+dataFormata.format(data)+"] Iniciando | "+nomeClasse+" | "+acaoExecutada);
		}else{
			System.err.println("["+dataFormata.format(data)+"]   Falha   | "+nomeClasse+" | "+acaoExecutada);
		}
		
	}
	
}
