/*
 * Copyright (C) 2016 Linco
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Banco;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Linco
 */
public class OrdemAlfabetica {
    public static void OrdenaArquivo(File file){
        PrintWriter fileout;
        int k=0;
        String name;
        try {
            List<String> buff = new ArrayList<>();
            List<String> temp = new ArrayList<>();
            try(Scanner fileIn = new Scanner (file)){
                while(fileIn.hasNextLine()){
                    buff.add(fileIn.nextLine());
                }
                fileIn.close();
            }
            for(int i=0; i<buff.size();i++){
                for(int j=0; j<buff.size()-1; j++){
                    if(buff.get(j).compareToIgnoreCase(buff.get(j+1))>0){
                        temp.add(buff.get(j));
                        buff.set(j, buff.get(j+1));
                        buff.set(j+1, temp.get(0));
                        temp.clear();
                    }
                }
            }
            file.delete();
            file.createNewFile();
            fileout = new PrintWriter(new FileWriter(file.getAbsolutePath(), true));
            while(k<buff.size()){
                fileout.println(buff.get(k));
                k++;
            }
            fileout.close();
        } catch (IOException ex) {
            Logger.getLogger(OrdemAlfabetica.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro nas permissões da pasta do programa!(Erro 39)");
        }
    }
}
