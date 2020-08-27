package edu.curso;

import java.io.File;
import java.io.FileReader;

public class TesteFileReader1 {
    public static void main(String[] args) {
        File f = new File("C:/temp/meu_arquivo.txt");

        try (FileReader fr = new FileReader(f)) {
            int i = 0;
            while((i = fr.read()) != -1) {
                System.out.print((char) i);
                //System.out.printf("%d - %s - %s%n", i, Integer.toHexString(i), (char) i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
