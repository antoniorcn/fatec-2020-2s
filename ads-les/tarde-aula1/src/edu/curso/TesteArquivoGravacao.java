package edu.curso;
import java.io.File;
import java.io.FileWriter;
public class TesteArquivoGravacao {

    public static void main(String[] args) {
        String arquivoNome = "C:/temp/helloworld.txt";
        File f = new File(arquivoNome);

        if (f.exists()) {
            System.out.printf("Arquivo %s Existe%n", arquivoNome);
        } else {
            System.out.printf("Arquivo %s Não Existe%n", arquivoNome);
        }
        try {
            FileWriter fw = new FileWriter(f, false);
            fw.write("Hello");
            fw.flush();
            fw.write("World2");
            fw.close();


        } catch(Exception e) {
            System.out.printf("Erro ao abrir o arquivo %s para gravação%n", arquivoNome);
        }
    }
}
