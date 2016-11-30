package br.com.fl.lotofacil;

@SobreOProjeto(

nomeProjeto = "Projeto Loto-Fácil",
versaoProjeto = 0_02_09D,
criador = "Felipe Lima",
ultimaRevisao = "09/02/2013",
revisao = 1

)

public class Principal{

	@Deprecated
	public static String versao = "0.02.23 alpha";
	
	public static void main(String[] args) {
		
		new JanelaPrincipal(versao);
		
	}
	
}

