package edu.curso;

import java.io.File;
import java.io.FileWriter;

public class TesteFileWriter1 {

    public static void main(String[] args) {
        File f = new File("c:/temp/meu_arquivo.txt");
        System.out.printf("Existe: %s%n", f.exists());
        System.out.printf("Arquivo: %s%n", f.isFile());
        System.out.printf("Diretorio: %s%n", f.isDirectory());
        System.out.printf("Pode Ler: %s%n", f.canRead());
        System.out.printf("Pode Gravar: %s%n", f.canWrite());

        try {
            FileWriter fw = new FileWriter(f);
            fw.write("Hello World\n");
            fw.write("File Writer\n");
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
