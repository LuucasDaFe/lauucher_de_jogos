package br.edu.iftm.gui.componentes;

import java.awt.Color;

import javax.swing.JButton;

public class Botao extends JButton{
    public Botao(String texto){
        super(texto);

        this.setBounds(1260 / 2, 400, 120, 60);
        this.setBackground(Color.decode("#6d5dd3"));
        this.setFocusPainted(false);
        this.setBorderPainted(false);
    }
}
