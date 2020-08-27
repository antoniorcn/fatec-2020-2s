package edu.curso;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class TesteObjectInputStream {
    public static void main(String[] args) {
        File f = new File("C:/temp/objeto.dat");
        try (FileInputStream fIn = new FileInputStream(f)) {
            ObjectInputStream objIn = new ObjectInputStream(fIn);
            List<List<Number>> inst = (List<List<Number>>) objIn.readObject();
            System.out.println("Lendo do arquivo: ");
            for (List<Number> list : inst) {
                for( Number n : list ) {
                    System.out.println(n);
                }
            }
            objIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
