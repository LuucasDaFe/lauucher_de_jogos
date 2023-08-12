package br.edu.iftm.gui;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.json.JSONArray;
import org.json.JSONObject;

import br.edu.iftm.gui.componentes.TelaPainel;
import br.edu.iftm.modelo.Jogo;

public class BibliotecaPainel extends TelaPainel{
    
    private ArrayList<Jogo> jogos;
    public BibliotecaPainel(JPanel telas, JFrame janela){

      super(telas, janela);
      this.jogos = new ArrayList<Jogo>();

      carregarJogos();
    
      //JButton botao = new JButton("Voltar");
      //botao.addActionListener(this);
      //botao.setBounds(0, 0, 100, 30);

      //this.add(botao);
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
