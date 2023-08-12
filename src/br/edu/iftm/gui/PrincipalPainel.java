package br.edu.iftm.gui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.edu.iftm.gui.componentes.TelaPainel;

public class PrincipalPainel extends TelaPainel{

    
    public PrincipalPainel(JPanel telas, JFrame janela){

      super(telas, janela);

        JLabel mensagem = new JLabel("Conteúdo do Principal panel");

        JButton botao = new JButton("Voltar");
        botao.addActionListener(this);

        this.add(botao);
        this.add(mensagem);
    }

    @Override
    public void executarBotao(ActionEvent e) {
      trocarTela("Tela Login");
    }
}
