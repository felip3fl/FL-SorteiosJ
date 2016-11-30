package br.com.fl.lotofacil;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame {

	public JanelaPrincipal(String VersaoProjeto) {

		super("FL Sorteio de números (Versão: " + VersaoProjeto + ")");

		final EstilosBotoes estiloBotao = new EstilosBotoes();
		final PadraoSorteio padraoSorteio = new PadraoSorteio();
		final ValoresParaNaoSortear valoresParaNaoSortear = new ValoresParaNaoSortear();
		
		
		/**
		 * Container principais e JFrames
		 * 
		 */
		final int BORDA_PADRAO = 6;
		
		getContentPane().setLayout(null);	
		Container containerCentro = new JPanel();
		
		ImageIcon imgTopoLotoFacil = new ImageIcon(getClass().getResource("imagens/lotofacil1.png"));
		JLabel imagemTopo = new JLabel(imgTopoLotoFacil);
		imagemTopo.setBounds(0,0,400,70);
		getContentPane().add(imagemTopo);
		
		final JLabel lblMensagem = new JLabel("Mensagens serão apresentados aqui", JLabel.CENTER);
		lblMensagem.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMensagem.setOpaque(true);
		lblMensagem.setBackground(Color.white);
		lblMensagem.setBorder(BorderFactory.createLineBorder(new Color(150,150,150)));
		lblMensagem.setBounds(14,(70+14),(330-14),40);
		getContentPane().add(lblMensagem);
		
		containerCentro.setLayout(new GridLayout(5, 5, 24, 6));
		containerCentro.setBounds(14,(70+14+40+14),(330-14),200);
		
		
		final JLabel lblResultado = new JLabel("Resultados serão apresentados aqui", JLabel.CENTER);
		lblResultado.setFont(new Font("Arial", Font.PLAIN, 12));
		lblResultado.setOpaque(true);
		lblResultado.setBackground(Color.white);
		lblResultado.setBorder(BorderFactory.createLineBorder(new Color(150,150,150)));
		lblResultado.setBounds(14,(70+14+40+14+316+14),(330-14),40);
		getContentPane().add(lblResultado);
		
		

		/**
		 * Botões principais do JFrame
		 * 
		 */
		
		Container containerInferior = new JPanel();
		containerInferior.setLayout(new GridLayout(1, 2, BORDA_PADRAO, BORDA_PADRAO));
		containerInferior.setBounds(14,(70+14+40+14+380+14+40+14),304,40);
		
		
		final JButton btnExpandi = new JButton(">>>");
		btnExpandi.setBounds(324,(70+14+40+14+380+14+40+14),56,40);
		getContentPane().add(btnExpandi);
		
		
		
		final JButton btnExecutar = new JButton("Sortear Números");
		containerInferior.add(btnExecutar);
		
		final JButton btnlimparCampos = new JButton("Limpar campos");
		containerInferior.add(btnlimparCampos);
		

		final Font fonteBotaoNormal = estiloBotao.fontNormal;
		final JButton[] btnBotao = new JButton[25];
		
		for (int numeroBotao = 20; numeroBotao != -1; numeroBotao -=5) {
			
			if(numeroBotao < 9){btnBotao[numeroBotao] = new JButton("0"+Integer.toString(numeroBotao+1));}else{
				btnBotao[numeroBotao] = new JButton(Integer.toString(numeroBotao + 1));
			}
				
			
			btnBotao[numeroBotao].setBackground(estiloBotao.corBranco);
			btnBotao[numeroBotao].setForeground(estiloBotao.corPreto);
			btnBotao[numeroBotao].setFont(fonteBotaoNormal);
			containerCentro.add(btnBotao[numeroBotao]);
			
			if(numeroBotao < 4){numeroBotao += 26;}

		}

		getContentPane().add(containerCentro);
		getContentPane().add(containerInferior);
		
		
		
		
		/**
		 * Ações dos Botões da Classe JanelaPrincipal
		 */
		btnExecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				//ValoresSorteados valoresSorteados = new ValoresSorteados();
				SortearNumerosAleatorios sorteioLotoFacil = new SortearNumerosAleatorios();
				HistoricoSorteio historico = new HistoricoSorteio();
				
				estiloBotao.limparBotao(btnBotao, false);
				sorteioLotoFacil.getNumeroAleatorio(); //Retorna uma array com números sorteados
				estiloBotao.alterarBotaoSorteado(btnBotao);
				
				lblResultado.setText(historico.getUltimoQuizeNumerosSorteados());
				lblMensagem.setText("<html><center>"+padraoSorteio.getQuantNumSorteio()+" sorteados!"+"<br>"+valoresParaNaoSortear.mensagemValoresBloqueados()+"</html>");
				
				
			}
		});

		btnlimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.limparBotao(btnBotao, true);
				lblResultado.setText("Resultados serão apresentados aqui");
				lblMensagem.setText("Todos os campos foram resetados!");
			}
		});

		
		
		
		btnBotao[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[0], lblMensagem);
			}
		});

		btnBotao[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[1], lblMensagem);
			}
		});

		btnBotao[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[2], lblMensagem);
			}
		});

		btnBotao[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[3], lblMensagem);
			}
		});

		btnBotao[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[4], lblMensagem);
			}
		});

		btnBotao[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[5], lblMensagem);
			}
		});

		btnBotao[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[6], lblMensagem);
			}
		});

		btnBotao[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[7], lblMensagem);
			}
		});

		btnBotao[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[8], lblMensagem);
			}
		});

		btnBotao[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[9], lblMensagem);
			}
		});

		btnBotao[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[10], lblMensagem);
			}
		});

		btnBotao[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[11], lblMensagem);
			}
		});

		btnBotao[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[12], lblMensagem);
			}
		});

		btnBotao[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[13], lblMensagem);
			}
		});

		btnBotao[14].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[14], lblMensagem);
			}
		});

		btnBotao[15].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[15], lblMensagem);
			}
		});

		btnBotao[16].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[16], lblMensagem);
			}
		});

		btnBotao[17].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[17], lblMensagem);
			}
		});

		btnBotao[18].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[18], lblMensagem);
			}
		});

		btnBotao[19].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[19], lblMensagem);
			}
		});

		btnBotao[20].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[20], lblMensagem);
			}
		});

		btnBotao[21].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[21], lblMensagem);
			}
		});

		btnBotao[22].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[22], lblMensagem);
			}
		});

		btnBotao[23].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[23], lblMensagem);
			}
		});

		btnBotao[24].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				estiloBotao.alterarBotaoSelecionado(btnBotao[24], lblMensagem);
			}
		});

		/**
		 * 
		 */
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(350, 600);
		ImageIcon icon = new ImageIcon(getClass().getResource("imagens/logo.gif"));
		super.setIconImage(icon.getImage());

	}

}
