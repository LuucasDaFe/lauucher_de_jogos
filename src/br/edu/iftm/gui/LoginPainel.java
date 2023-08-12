package br.edu.iftm.gui;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.iftm.gui.componentes.Botao;
import br.edu.iftm.gui.componentes.TelaPainel;

public class LoginPainel extends TelaPainel{
    private Botao botaoLogin;

    public LoginPainel(JPanel telas, JFrame  janela){
        super(telas, janela);
        JLabel mensagem = new JLabel("Conteúdo do Login panel");

        JTextField txtLogin = new JTextField();
        txtLogin.setBounds(620, 260, 220, 30);

        JTextField txtSenha = new JTextField();
        txtSenha.setBounds(620, 300, 220, 30);

        botaoLogin = new Botao("Fazer login");
        botaoLogin.addActionListener(this);

        this.add(mensagem);
        this.add(botaoLogin);
        this.add(txtLogin);
        this.add(txtSenha);

    }

    public void executarBotao(ActionEvent e){
      trocarTela("Tela Principal");
    }
}
