package br.edu.iftm.gui.componentes;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaPainel extends JPanel implements ActionListener{
    private JPanel telas;
    private CardLayout controleTela;
    private JFrame janela;

    public TelaPainel(JPanel telas, JFrame janela){
        this.telas = telas;
        this.controleTela = (CardLayout) telas.getLayout();
        this.janela = janela;
        this.setBackground(Color.decode("202028"));
        this.setLayout(null);

        Imagem botaoFechar = new Imagem("fechar-simbolo-de-botao-circular.png");
        Imagem botaoMinimizar = new Imagem("minimize-o-sinal.png");
        botaoFechar.setBounds(1330, 0, 36, 36);
        botaoMinimizar.setBounds(1300, 5, 36, 36);

        botaoFechar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                janela.dispose();
            }
        });

        botaoMinimizar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                janela.setState(JFrame.ICONIFIED);
            }
        });

        this.add(botaoFechar);
        this.add(botaoMinimizar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        executarBotao(e);
    }

    protected void executarBotao(ActionEvent e){

    }

    protected void trocarTela(String identificador){
        controleTela.show(telas, identificador);
    }
    
}
