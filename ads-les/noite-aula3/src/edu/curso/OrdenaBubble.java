package edu.curso;

import java.util.Random;

public class OrdenaBubble implements Runnable {

    private String caracter;

    public OrdenaBubble(String caracter) {
        this.caracter = caracter;
    }

    public int[] cria100() {
        int[] vetor = new int[100];
        Random rnd = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rnd.nextInt() % 100;
        }
        return vetor;
    }

    public void bubbleSort(int[] numeros) {
        for (int i = 0; i < numeros.length - 1; i++) {
            if (numeros[i] > numeros[i + 1]) {
                int temp = numeros[i];
                numeros[i] = numeros[i + 1];
                numeros[i + 1] = temp;
            }
        }
    }

    public String criarString(String caracter, int tamanho) {
        StringBuffer strBuf = new StringBuffer();
        for (int i = 0; i < tamanho; i++) {
            strBuf.append(caracter);
        }
        return strBuf.toString();
    }

    public void printVetor(int[] numeros) {
        for (int i = 0; i < numeros.length - 1; i++) {
            String texto = criarString(this.caracter, numeros[i]);
            System.out.println(texto);
        }
    }

    public boolean estaOrdenada(int[] numeros) {
        int i = 0;
        boolean ordenada = true;
        while (i < numeros.length - 1 && ordenada)  {
            if (numeros[i] > numeros[i + 1]) {
                ordenada = false;
            }
            i++;
        }
        return ordenada;
    }

    @Override
    public void run() {
        int[] v1 = cria100();

        while(!estaOrdenada(v1)) {
            bubbleSort(v1);
            printVetor(v1);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
