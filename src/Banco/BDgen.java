/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Linco
 */
public class BDgen {
    //TODO adicionar, alterar, buscar
static String banco; 
 
    public static int adicionar (String nome){
        try {
            File file = new File(banco);
            if(!file.exists()) {
                file.createNewFile();
            }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro nas permissões da pasta do programa!(Erro 23)");
                return -1;
            }
            try (PrintWriter writer = new PrintWriter(new FileWriter(banco, true))) {
                writer.println(nome);
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(BDgen.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro nas permissões da pasta do programa!(Erro 24)");
            }
        File file = new File(banco);
        Banco.OrdemAlfabetica.OrdenaArquivo(file);
        return 0;
    }
    public static int remover (String nome){
        Materia.removerquestao(nome);
        Assunto.removerquestao(nome);
        Tipo.removertipo(nome);
        Dificuldade.removerdificuldade(nome);
        return 0;
    }
}

