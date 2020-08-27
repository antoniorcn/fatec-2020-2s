package edu.curso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class TesteFiltroObjectWriter {

    public static void main(String[] args) {
        List<Object> objetos = Arrays.asList("Texto", 12345, 12.6f, "Outro Texto");
        File f = new File("C:/temp/objeto.dat");

        try (FileOutputStream fout = new FileOutputStream(f)) {
            ObjectOutputStream objOut = new ObjectOutputStream(fout);
            objOut.writeObject(objetos);
            objOut.close();
            System.out.println("Objeto gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
