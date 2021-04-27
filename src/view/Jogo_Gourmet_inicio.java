package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Jogo_Gourmet_inicio implements ActionListener {

	// ArrayList
	static ArrayList<String> listapratos = new ArrayList<String>();

	// Frames e Panel
	static JFrame frame = new JFrame("Jogo Gourmet 1.0 by Java");
	static JPanel painel = new JPanel();
	// Label
	static JLabel label, label_pergunta;
	// botão
	JButton btcomecar = new JButton("COMEÇAR");
	JButton btsobre = new JButton("Sobre");
	JButton btsair = new JButton("Sair");

	// inicio dos frames
	public void frames() {

		painel.setLayout(null);

		frame.add(painel);
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);

		// adicionando label e botão
		label();

		botao();
		btsobre();
		botao_sair();

		// setar arraylist inicial
		listapratos.add(0, "Bolo");

	}

	public static void label() {
		label = new JLabel("JOGO GOURMET");
		label.setBounds(240, 50, 120, 30);
		label.setForeground(Color.red);
		painel.add(label);

	}

	public void botao() {

		btcomecar.addActionListener(this);
		btcomecar.setBackground(Color.white);
		btcomecar.setBounds(230, 80, 120, 30);
		painel.add(btcomecar);

	}

	public void botao_sair() {

		btsair.addActionListener(this);
		btsair.setBackground(Color.white);
		btsair.setBounds(450, 10, 120, 30);
		painel.add(btsair);

	}

	public void btsobre() {

		btsobre.addActionListener(this);
		btsobre.setBackground(Color.white);
		btsobre.setBounds(20, 10, 120, 30);
		painel.add(btsobre);

	}

	// ação do botão
	public void actionPerformed(ActionEvent evt) {
		Object obj = evt.getSource();

		if (obj == btcomecar) {

			pensa();

		}
		if (obj == btsair) {
			System.exit(0);
		}
		if (obj == btsobre) {
			JOptionPane.showMessageDialog(null, " Jogo Gourmet - Autor Jeferson Cardoso dos Santos");
		}

	}

	public void pensa() {

		// Algo que deseja mostrar (aviso, mensagem de erro)
		String pensa = "Pensa num Prato ..";

		// Cria um JFrame
		JFrame frame = new JFrame("JOGO GOURMET");

		// Cria o JOptionPane por showMessageDialog
		JOptionPane.showMessageDialog(frame, "Aguarde \n \n " + pensa + ".", // mensagem
				"", // titulo da janela
				JOptionPane.INFORMATION_MESSAGE);

		perguntas();

	}

	// onde as perguntas são feitas
	public void perguntas() {

		int i = 0;
		for (i = 0; i < listapratos.size(); i++) {

			int respostaS = JOptionPane.showConfirmDialog(frame,
					"O prato que você pensou é " + listapratos.get(i) + " ? ", "Vou advinhar seu prato",
					JOptionPane.YES_NO_OPTION);
			// verfica se a resposta é SIM
			if (respostaS == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "Acertei");
				int novamente = JOptionPane.showConfirmDialog(frame, "Quer jogar novamente ? ",
						"Vou advinhar seu prato", JOptionPane.YES_NO_OPTION);
				if (novamente == JOptionPane.YES_OPTION) {
					pensa();
				} else {
					System.exit(0);
				}

			} else {
				JOptionPane.showMessageDialog(null, " Que Pena eu errei!!!");

			}

		}
		// cadastramento do prato
		cadastrar();
		listapratos.get(i++);
		i++;

	}

	// metodo de cadastro
	public void cadastrar() {
		String prato_usuario;
		String resposta_prato;

		prato_usuario = JOptionPane.showInputDialog("Qual é o Prato ?");
		resposta_prato = prato_usuario;

		listapratos.add(resposta_prato);
		JOptionPane.showMessageDialog(null, " Prato " + resposta_prato + " Cadastrado.");
		JOptionPane.showMessageDialog(null, " Joga novamente");

	}

}
