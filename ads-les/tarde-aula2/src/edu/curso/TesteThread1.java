package edu.curso;
class MinhaThread extends Thread {
    public void run() {
        while (true) {
            System.out.println("Minha Thread");
        }
    }
}
public class TesteThread1 {
    public static void main(String[] args) {
        MinhaThread mt = new MinhaThread();
        mt.start();
        while(true) {
            System.out.println("Codigo Principal");
        }
    }
}
