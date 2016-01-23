/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

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
public class ResultadoBusca {
    public static int ImprimeResultado(String [] questoes){
        File arq = new File("Buscas/Busca.txt");
        if(arq.exists())
            arq.delete();
        try{
            PrintWriter arqResultado;
            Scanner fileIn;
            File file;
            File Fileresult = new File("Buscas/Busca.txt");
            if(!Fileresult.exists()) {
                try {
                    Fileresult.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(ResultadoBusca.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Erro nas permissões da pasta do programa!(Erro 15)");
                }
            }
            arqResultado = new PrintWriter(new FileWriter("Buscas/Busca.txt", true));
            for (String nome : questoes) {
                file = new File("Questoes/"+nome); 
                if(!file.exists()){
                    JOptionPane.showMessageDialog(null, "Erro no Banco de Dados, por favor revalide o banco (no menu ferramentas, na tela inicial do programa)");
                    GUI.Busca.pag2.dispose();
                    GUI.Pg1.pag1.setVisible(true);
                    return -1;
                }
                fileIn = new Scanner(file);
                arqResultado.println(nome);
                while(fileIn.hasNextLine()){
                    String linha = fileIn.nextLine();
                    arqResultado.println(linha);
                }
                fileIn.close();
                arqResultado.println(System.lineSeparator());
            }
            arqResultado.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ResultadoBusca.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro nas permissões da pasta do programa!(Erro 16)");
        } catch (IOException ex) {
            Logger.getLogger(ResultadoBusca.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro nas permissões da pasta do programa!(Erro 17)");
        }
    return 0;
    }
}
