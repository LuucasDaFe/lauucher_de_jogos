package br.edu.iftm.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.IIOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.json.JSONArray;
import org.json.JSONObject;

import br.edu.iftm.gui.componentes.Imagem;
import br.edu.iftm.gui.componentes.TelaPainel;
import br.edu.iftm.modelo.Jogo;

public class BibliotecaPainel extends TelaPainel{
    
    private ArrayList<Jogo> jogos;
    private JPanel grid;

    public BibliotecaPainel(JPanel telas, JFrame janela){

      super(telas, janela);
      this.jogos = new ArrayList<Jogo>();

      grid = new JPanel(new FlowLayout(FlowLayout.LEFT, 22, 22));
      grid.setBackground(Color.decode("#202028"));
      
      carregarJogos();
      exibirJogos();
      
      JScrollPane scrollPanel = new JScrollPane(grid);
      scrollPanel.setBounds(50, 50, 1360, 768);

      this.add(scrollPanel);
    }

    private void carregarJogos(){
      String jsonString = lerJsonJogos();
      JSONArray jsonArray = new JSONArray(jsonString);
      for (int i = 0; i < jsonArray.length(); i++){
        JSONObject jogJsonObject = (JSONObject) jsonArray.get(i);
        jogos.add(new Jogo(jogJsonObject));
      }
      
      for(Jogo jogo : jogos){
        System.out.println(jogo.getIcone());
      }
    };

    private void exibirJogos(){
      int posicaoX = 50;
      int posicaoY = 50;
      final int POSICAO_MAX_X = 1230;

      int altura = (jogos.size() / 7) * 222 + 20;
      grid.setPreferredSize(new Dimension(500, altura));

      for (Jogo jogo : jogos) {
        String icone = jogo.getIcone();
        Imagem imagem = new Imagem(icone);
        imagem.setBounds(posicaoX, posicaoY, 131,200);

        posicaoX += 20 + 131;
        if(posicaoX > POSICAO_MAX_X){
          posicaoX = 50;
          posicaoY += 20 + 200;
        }
        
        System.out.println(icone);

        imagem.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e){
            String caminho = jogo.getCaminho();
            //executarJogo(caminho);
          }
        });

        grid.add(imagem);       
      }
    }

    private void executarJogo(String caminho) throws IOException{
      File arquivo = new File(caminho);
      String pasta = arquivo.getAbsoluteFile().getParent();
      try{
        Runtime.getRuntime().exec(caminho, null, new File(pasta));
      } catch (IIOException e){
        e.printStackTrace();
      }
    }

    private String lerJsonJogos(){
      File arquivoJson = new File("jogos.json");
      StringBuilder conteudoArquivo = new StringBuilder();
      try {
        BufferedReader leitor = new BufferedReader(new FileReader(arquivoJson));

        String linha = leitor.readLine();
        while(linha != null){
          conteudoArquivo.append(linha);
          linha = leitor.readLine();
        }
        leitor.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
      return conteudoArquivo.toString();
    }

    @Override
    public void executarBotao(ActionEvent e) {
      trocarTela("Tela Login");
    }
}
