package edu.curso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class TesteObjectOutputStream {
    public static void main(String[] args) {
        List<List<Number>> numeros = Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(4,5,6));
        File f = new File("C:/temp/objeto.dat");
        try (FileOutputStream fout = new FileOutputStream(f)) {
            ObjectOutputStream objOut = new ObjectOutputStream(fout);
            objOut.writeObject(numeros);
            objOut.close();
            System.out.println("Objeto foi gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
