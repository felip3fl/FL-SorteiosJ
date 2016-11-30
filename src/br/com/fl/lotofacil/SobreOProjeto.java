package br.com.fl.lotofacil;

import java.lang.annotation.Documented;
@Documented //Anotações aparecer na documentação

public @interface SobreOProjeto {
	
	String nomeProjeto();
	double versaoProjeto();
	String criador();
	String ultimaRevisao();
	int revisao() default 1;
	
	
	
}
