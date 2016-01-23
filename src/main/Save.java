/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Linco
 */
public class Save {
    public static int salvar(String Assunto,String Lingua,String Tipo,String Dificuldade,String Questao) throws IOException{
        try {
            int i=1;
            try {
                File file = new File("Indices/IndiceDeNomes.txt");
                if(!file.exists()) {
                    file.createNewFile();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro nas permissões da pasta do programa!(Erro 3)");
                return -1;
            }

            try (Scanner fileIn = new Scanner(new File("Indices/IndiceDeNomes.txt"))) {
                while(fileIn.hasNextLine()){
                    i++;
                    fileIn.nextLine();
                }
                try (PrintWriter writer = new PrintWriter(new FileWriter("Indices/IndiceDeNomes.txt", true))) {
                    writer.println(i+".txt");
                    writer.close();
                }
                try {
                    File arqQuestao = new File("Questoes/"+i+".txt");
                    if(!arqQuestao.exists()) {
                        arqQuestao.createNewFile();
                    }else{
                        JOptionPane.showMessageDialog(null, "Banco de dados Inválido encontrado, por favor revalide o banco.");
                        System.exit(0);
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erro nas permissões da pasta do programa!(Erro 1)");
                    return -1;
                }
                String linhas[] = Questao.split(System.lineSeparator());
                try (PrintWriter arqQuestao = new PrintWriter(new FileWriter("Questoes/"+i+".txt", true))) {
                    arqQuestao.println(Lingua);
                    arqQuestao.println(Assunto);
                    arqQuestao.println(Tipo);
                    arqQuestao.println(Dificuldade);
                    arqQuestao.println("          ");
                    for (String linha : linhas) {
                        arqQuestao.println(linha);
                    }
                    arqQuestao.close();
                }
            }
            Banco.Lingua.adicionar(Lingua, i+".txt");
            Banco.Assunto.adicionar(Assunto, i+".txt");
            Banco.Tipo.adicionar(Tipo, i+".txt");
            Banco.Dificuldade.adicionar(Dificuldade, i+".txt");
            JOptionPane.showMessageDialog(null, "Questao de número "+i+" salva com sucesso");
            return 0;
        } catch (FileNotFoundException ex) {
                Logger.getLogger(Save.class.getName()).log(Level.SEVERE,null, ex);
                JOptionPane.showMessageDialog(null, "Erro nas permissões da pasta do programa! (Erro 2)");
                return -1;
        }
    }
}
