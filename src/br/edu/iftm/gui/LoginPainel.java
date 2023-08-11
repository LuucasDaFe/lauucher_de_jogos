package br.edu.iftm.gui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginPainel extends TelaPainel{
    private JButton botaoLogin;

    public LoginPainel(JPanel telas, JFrame  janela){
        super(telas, janela);
        JLabel mensagem = new JLabel("Conteúdo do Login panel");


        botaoLogin = new JButton("Fazer login");
        botaoLogin.addActionListener(this);

        this.add(mensagem);
        this.add(botaoLogin);

    }

    public void executarBotao(ActionEvent e){
      trocarTela("Tela Principal");
    }
}
