package br.com.fl.lotofacil;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;


public class EstilosBotoes {

	public Font fontNormal = new Font("Arial", Font.PLAIN, 8);
	public Font fontNegrito = new Font("Arial", Font.BOLD, 8);

	public Color corBranco = new Color(255, 255, 255);
	public Color corPreto = new Color(0, 0, 0);
	public Color corVermelho = new Color(255, 0, 0);

	ValoresParaNaoSortear valorNaoSortear = new ValoresParaNaoSortear();

	public void botaoNormal(JButton btnBotao) {
		btnBotao.setFont(fontNormal);
		btnBotao.setBackground(corBranco);
		btnBotao.setForeground(corPreto);
	}

	public void botaoSelecionado(JButton btnBotao) {
		btnBotao.setFont(fontNegrito);
		btnBotao.setBackground(corBranco);
		btnBotao.setForeground(corVermelho);
	}

	public void botaoSorteado(JButton btnBotao) {
		btnBotao.setFont(fontNormal);
		btnBotao.setBackground(corPreto);
		btnBotao.setForeground(corBranco);
	}

	public void botaoSorteadoSelecionado(JButton btnBotao) {
		btnBotao.setFont(fontNegrito);
		btnBotao.setBackground(corPreto);
		btnBotao.setForeground(corVermelho);
	}

	
	
	public boolean testeBotaoNormal(JButton btnBotao) {
		if (btnBotao.getFont() == fontNormal & btnBotao.getBackground() == corBranco & btnBotao.getForeground() == corPreto) {
			return true;
		} else {
			return false;
		}
	}

	public boolean testeBotaoSelecionado(JButton btnBotao) {
		if (btnBotao.getFont() == fontNegrito & btnBotao.getBackground() == corBranco	& btnBotao.getForeground() == corVermelho) {
			return true;
		} else {
			return false;
		}
	}

	public boolean testeBotaoSorteado(JButton btnBotao) {
		if (btnBotao.getFont() == fontNormal & btnBotao.getBackground() == corPreto & btnBotao.getForeground() == corBranco) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean testeBotaoSorteadoSelecionado(JButton btnBotao) {
		if (btnBotao.getFont() == fontNegrito & btnBotao.getBackground() == corPreto & btnBotao.getForeground() == corVermelho) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	public void alterarBotaoSelecionado(JButton btnBotao, JLabel CampoDeTexto) {

		//ValoresSorteados valorNaoSortear = new ValoresSorteados();

		//if (valorNaoSortear.limiteBotaoApertado(7)){
		
			
		if (testeBotaoNormal(btnBotao)) {
			if (valorNaoSortear.limiteBotaoApertado(7)) {
				botaoSelecionado(btnBotao);
				
				valorNaoSortear.add(Integer.parseInt(btnBotao.getText()) - 1);
				CampoDeTexto.setText(valorNaoSortear.mensagemValoresBloqueados());
			}

		} else if (testeBotaoSorteado(btnBotao)) {
			if (valorNaoSortear.limiteBotaoApertado(7)) {
				botaoSorteadoSelecionado(btnBotao);
				
				valorNaoSortear.add(Integer.parseInt(btnBotao.getText()) - 1);
				CampoDeTexto.setText(valorNaoSortear.mensagemValoresBloqueados());
			}

		} else if (testeBotaoSorteadoSelecionado(btnBotao)) {
			botaoSorteado(btnBotao);
			
			valorNaoSortear.remove(Integer.parseInt(btnBotao.getText()) - 1);
			CampoDeTexto.setText(valorNaoSortear.mensagemValoresBloqueados());

		} else if (testeBotaoSelecionado(btnBotao)) {
			botaoNormal(btnBotao);
			
			valorNaoSortear.remove(Integer.parseInt(btnBotao.getText()) - 1);
			CampoDeTexto.setText(valorNaoSortear.mensagemValoresBloqueados());
		}

		//}

		//return btnBotao;

	}
	

	

	public void alterarBotaoSorteado(JButton[] btnBotao) {

		PadraoSorteio padraoSorteio = new PadraoSorteio(); 
		HistoricoSorteio historicoSorteio = new HistoricoSorteio();
		
		for (int i = 0; i < padraoSorteio.getNumMaxSorteioLotofacil(); i++) {
			for (int j = 0; j < padraoSorteio.getQuantNumSorteio(); j++) {
				//if (historicoSorteio.possuiNumero(j)) {
				if (Integer.parseInt(btnBotao[i].getText()) == (historicoSorteio.getNumeroSorteado(j) + 1)) {
					btnBotao[i].setBackground(corPreto);
					btnBotao[i].setForeground(corBranco);
				}
			}
		}

	}

	public void limparBotao(JButton[] btnBotao, boolean limpezaCompleta) {

		PadraoSorteio padraoSorteio = new PadraoSorteio(); 
		
		for (int i = 0; i < padraoSorteio.getNumMaxSorteioLotofacil(); i++) {
			if (!valorNaoSortear.getValorNaoSortear(i) | limpezaCompleta) {
				btnBotao[i].setForeground(corPreto);
				btnBotao[i].setFont(fontNormal);
			}
			btnBotao[i].setBackground(corBranco);
		}

		if (limpezaCompleta) {
			valorNaoSortear.removerTodosValores();
		}
		
	}

	//	public Font Color getFontNormal(){
	//		
	//	}

}
