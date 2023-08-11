package br.edu.iftm.gui;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Janela extends JFrame{
    public Janela(){
        this.setBounds(0, 0, 1920, 1080);

        CardLayout controleTela = new CardLayout();
        JPanel telas = new JPanel(controleTela);

        LoginPainel loginPainel = new LoginPainel(telas, this);
        PrincipalPainel principalPainel = new PrincipalPainel(telas, this);

        telas.add(loginPainel, "Tela Login");
        telas.add(principalPainel, "Tela Principal");


        this.add(telas);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);

        this.setVisible(true);
    }
    
}
