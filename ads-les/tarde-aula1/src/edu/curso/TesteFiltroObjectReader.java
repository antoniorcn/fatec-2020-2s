package edu.curso;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class TesteFiltroObjectReader {
    public static void main(String[] args) {
        File f = new File("C:/temp/objeto.dat");
        try (FileInputStream fin = new FileInputStream(f)) {
            ObjectInputStream objIn = new ObjectInputStream(fin);

            Object obj = objIn.readObject();
            if (obj instanceof List<?>) {
                List<Object> lista = (List<Object>)obj;
                System.out.println("Objeto lido com sucesso:");
                for (Object o : lista) {
                    System.out.println(o.toString());
                }
            }
            objIn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
