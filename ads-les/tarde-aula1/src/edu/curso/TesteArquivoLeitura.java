package edu.curso;

import java.io.File;
import java.io.FileInputStream;

public class TesteArquivoLeitura {
    public static void main(String[] args) {
        File f = new File("C:/Users/anton/OneDrive - Fatec Centro Paula Souza" +
                "/Documents/pgadmin.log");
        try {
            FileInputStream fi = new FileInputStream(f);
            int i;
            while ((i = fi.read()) != -1) {
//                 System.out.print(Integer.toHexString(i));
                System.out.print((char) i);
            }
            fi.close();
        } catch(Exception e) {
            System.out.println("Erro ao acessar o arquivo");
        }
    }
}
